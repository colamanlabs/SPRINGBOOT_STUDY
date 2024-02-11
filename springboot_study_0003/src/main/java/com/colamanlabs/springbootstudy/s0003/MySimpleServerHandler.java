package com.colamanlabs.springbootstudy.s0003;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

import org.apache.commons.codec.binary.Hex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySimpleServerHandler implements Runnable
{
    
    private Socket socket = null;
    
    private boolean isRun = false;
    
    public MySimpleServerHandler(Socket socket, boolean isRun)
    {
        super();
        this.socket = socket;
        this.isRun = isRun;
        log.info(String.format("[MySimpleServerHandler/MySimpleServerHandler] socket:[%s]", socket));
        log.info(String.format("[MySimpleServerHandler/MySimpleServerHandler] isRun:[%b]", isRun));
    }
    
    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        log.info(String.format("[MySimpleServerHandler/run] BEGIN"));
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        
        OutputStream os = null;
        BufferedOutputStream bos = null;
        PrintWriter pw = null;
        try
        {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            bos = new BufferedOutputStream(os);
            pw = new PrintWriter(bos);
            
            log.info(String.format("[MySimpleServerHandler/run] isRun:[%b]", isRun));
            while (isRun)
            {
                String strRecv = "";
                while ((strRecv = br.readLine()) != null)
                {
                    String strResponse = String.format("length:[%04d]\trecvData:[%s]", strRecv.length(), strRecv);
                    log.info(String.format("[MySimpleServerHandler/run] strResponse:[%s]", strResponse));
                    pw.println(strResponse);
                    pw.flush();
                    if (strRecv.trim().equals("SHUTDOWN") == true)
                    {
                        isRun = false;
                        break;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeOutputStream(bos);
            closeOutputStream(os);
            closeReader(br);
            closeReader(isr);
            closeInputStream(is);
            closeSocket();
        }
        log.info(String.format("[MySimpleServerHandler/run] END"));
    }
    
    public void closeOutputStream(OutputStream os)
    {
        log.info(String.format("[MySimpleServerHandler/closeOutputStream] BEGIN"));
        log.info(String.format("[MySimpleServerHandler/closeOutputStream] os:[%s]", os));
        if (os != null)
        {
            try
            {
                os.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        log.info(String.format("[MySimpleServerHandler/closeOutputStream] END"));
    }
    
    public void closeReader(Reader r)
    {
        log.info(String.format("[MySimpleServerHandler/closeReader] BEGIN"));
        log.info(String.format("[MySimpleServerHandler/closeReader] r:[%s]", r));
        if (r != null)
        {
            try
            {
                r.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        log.info(String.format("[MySimpleServerHandler/closeReader] END"));
    }
    
    public void closeWriter(Writer w)
    {
        log.info(String.format("[MySimpleServerHandler/closeWriter] BEGIN"));
        log.info(String.format("[MySimpleServerHandler/closeWriter] w:[%s]", w));
        if (w != null)
        {
            try
            {
                w.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        log.info(String.format("[MySimpleServerHandler/closeWriter] END"));
    }
    
    public void closeInputStream(InputStream is)
    {
        log.info(String.format("[MySimpleServerHandler/closeInputStream] BEGIN"));
        log.info(String.format("[MySimpleServerHandler/closeInputStream] is:[%s]", is));
        if (is != null)
        {
            try
            {
                is.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        log.info(String.format("[MySimpleServerHandler/closeInputStream] END"));
    }
    
    public void closeSocket()
    {
        log.info(String.format("[MySimpleServerHandler/closeSocket] BEGIN"));
        try
        {
            if (socket != null)
            {
                socket.close();
                log.info(String.format("[MySimpleServerHandler/closeSocket] socket.close() OK"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (socket != null)
            {
                log.info(String.format("[MySimpleServerHandler/closeSocket] socket.isClosed():[%b]", socket.isClosed()));
            }
        }
        log.info(String.format("[MySimpleServerHandler/closeSocket] END"));
    }
    
}
