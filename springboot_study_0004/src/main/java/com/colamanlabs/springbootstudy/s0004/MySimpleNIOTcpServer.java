package com.colamanlabs.springbootstudy.s0004;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MySimpleNIOTcpServer implements Runnable
{
    
    private Selector selector = null;
    
    @Value("${server.listen_port}")
    private int serverListenPort;
    
    private boolean isRun = false;
    
    public void initServerSocket(boolean isRun) throws Exception
    {
        this.isRun = isRun;
        InetSocketAddress inetAddr = new InetSocketAddress(serverListenPort);
        initServerSocket(inetAddr, this.isRun);
    }
    
    public void initServerSocket(InetSocketAddress listenAddr, boolean isRun) throws Exception
    {
        log.info(String.format("[MySimpleNIOTcpServer/initServerSocket] BEGIN"));
        log.info(String.format("[MySimpleNIOTcpServer/initServerSocket] listenAddr:[%s]", listenAddr));
        log.info(String.format("[MySimpleNIOTcpServer/initServerSocket] isRun:[%b]", isRun));
        selector = Selector.open();
        ServerSocketChannel srcSockChannel = null;
        srcSockChannel = ServerSocketChannel.open();
        srcSockChannel.configureBlocking(false);
        ServerSocket srvSock = srcSockChannel.socket();
        srvSock.bind(listenAddr);
        srcSockChannel.register(selector, SelectionKey.OP_ACCEPT);
        log.info(String.format("[MySimpleNIOTcpServer/initServerSocket] END"));
    }
    
    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        log.info(String.format("[MySimpleNIOTcpServer/run] BEGIN"));
        
        while (isRun)
        {
            try
            {
                selector.select();
                Set<SelectionKey> setKey = selector.selectedKeys();
                log.info(String.format("[MySimpleNIOTcpServer/run/BEFORE] setKey.size():[%d]", setKey.size()));
                if (setKey.size() > 0)
                {
                    Iterator<SelectionKey> iterKey = setKey.iterator();
                    while (iterKey.hasNext() == true)
                    {
                        SelectionKey selectionKey = iterKey.next();
                        if (selectionKey.isValid() == false)
                        {
                            continue;
                        }
                        else
                        {
                            processSelectionKey(selectionKey);
                        }
                    }
                }
                setKey.clear();
                log.info(String.format("[MySimpleNIOTcpServer/run/AFTER] setKey.size():[%d]", setKey.size()));
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            
        }
        log.info(String.format("[MySimpleNIOTcpServer/run] END"));
    }
    
    public void processSelectionKey(SelectionKey selectionKey) throws IOException
    {
        log.info(String.format("[MySimpleNIOTcpServer/processSelectionKey] BEGIN"));
        log.info(String.format("[MySimpleNIOTcpServer/processSelectionKey] selectionKey:[%s]", selectionKey));
        if (selectionKey.isAcceptable() == true)
        {
            processIsAcceptable(selectionKey);
        }
        else if (selectionKey.isReadable() == true)
        {
            processIsReadable(selectionKey);
        }
        else
        {
            
        }
        log.info(String.format("[MySimpleNIOTcpServer/processSelectionKey] END"));
    }
    
    public void processIsAcceptable(SelectionKey selectionKey) throws IOException
    {
        log.info(String.format("[MySimpleNIOTcpServer/processIsAcceptable] BEGIN"));
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) (selectionKey.channel());
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        mapSocketChannel.put(socketChannel, baos);
        
        log.info(String.format("[MySimpleNIOTcpServer/processIsAcceptable] END"));
    }
    
    private static final byte CR = (byte) 0x0D;
    private static final byte LF = (byte) 0x0A;

    private HashMap<SocketChannel, ByteArrayOutputStream> mapSocketChannel = new HashMap<SocketChannel, ByteArrayOutputStream>(); 
    
    public void processIsReadable(SelectionKey selectionKey) throws IOException
    {
        log.info(String.format("[MySimpleNIOTcpServer/processIsReadable] BEGIN"));
        SocketChannel socketChannel = (SocketChannel) (selectionKey.channel());
        socketChannel.configureBlocking(false);
        int readBytes = -1;
        
        ByteArrayOutputStream baos = mapSocketChannel.get(socketChannel);
        if (baos == null)
        {
            baos = new ByteArrayOutputStream();
            mapSocketChannel.put(socketChannel, baos);
        }
        
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        
        while ((readBytes = socketChannel.read(readBuffer)) > 0)
        {
            /*
             * read(readBuffer) 에서는 테스트결과 앞에서 부터 채운다.
[MySimpleNIOTcpServer/processIsReadable] readBuffer:[java.nio.HeapByteBuffer[pos=1 lim=1024 cap=1024]]
[MySimpleNIOTcpServer/processIsReadable] readBuffer:[java.nio.HeapByteBuffer[pos=1 lim=1024 cap=1024]]
[MySimpleNIOTcpServer/processIsReadable] readBuffer:[java.nio.HeapByteBuffer[pos=1 lim=1024 cap=1024]]
[MySimpleNIOTcpServer/processIsReadable] readBuffer:[java.nio.HeapByteBuffer[pos=1 lim=1024 cap=1024]]
...
pos 값이 바뀌지 않는다.
             */
            log.info(String.format("[MySimpleNIOTcpServer/processIsReadable] readBuffer:[%s]", readBuffer));
            
            
            /*
            [MySimpleNIOTcpServer/processIsReadable] bReadBuffer.length:[1024]
            
            readBuffer.array() 는 ByteBuffer 의 수신한 사이즈만큼만 배열을 만들어 리턴하는게 아니라, 버퍼 사이즈 만큼 리턴한다.
            따라서, 실제 수신한 만큼만 담으려면 readBytes 값으로 복사해야 한다.
            */
            byte[] bRead = new byte[readBytes];
            System.arraycopy(readBuffer.array(), 0, bRead, 0, readBytes);
            baos.write(bRead);
            
            readBuffer.clear();
            
            byte[] bRecvDataAll = baos.toByteArray();
            log.info(String.format("[MySimpleNIOTcpServer/processIsReadable] bRecvDataAll.length:[%d]", bRecvDataAll.length));
            if (bRecvDataAll.length > 2)
            {
                if ((bRecvDataAll[bRecvDataAll.length - 2] == CR) && (bRecvDataAll[bRecvDataAll.length - 1] == LF))
                {
                    baos.reset();
                    String strRecvDataAll = new String(bRecvDataAll, 0, bRecvDataAll.length - 2);
                    String strReturn = String.format("strRecvDataAll:[%s]\tlength:[%d]\tbRecvDataAll.length:[%d]\r\n", strRecvDataAll, strRecvDataAll.length(), bRecvDataAll.length);
                    ByteBuffer writeBuffer = ByteBuffer.wrap(strReturn.getBytes());
                    socketChannel.write(writeBuffer);
                    if (strRecvDataAll.equals("SHUTDOWN") == true)
                    {   
                        socketChannel.close();
                        selectionKey.cancel();
                        baos.close();
                        mapSocketChannel.remove(socketChannel);                        
                        break;
                    }                    
                }
            }         
        }
        log.info(String.format("[MySimpleNIOTcpServer/processIsReadable] END"));       
    }
    
}
