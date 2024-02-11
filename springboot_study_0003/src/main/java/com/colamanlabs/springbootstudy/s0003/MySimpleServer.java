package com.colamanlabs.springbootstudy.s0003;

import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MySimpleServer
{
    
    private ServerSocket serverSocket = null;
    
    @Value("${server.listen_port}")
    private int serverListenPort;
    
    /*
     * legacy TCP 서버 방식으로 구현
     */
    public void initServer() throws Exception
    {
        serverSocket = new ServerSocket(serverListenPort);
        
        Socket socket = null;
        while ((socket = acceptSocket(serverSocket)) != null)
        {
            log.info(String.format("[MySimpleServer/initServer] socket:[%s]", socket));
            MySimpleServerHandler socketHandler = new MySimpleServerHandler(socket, true);
            Thread thrHandler = new Thread(socketHandler);
            thrHandler.start();
            log.info(String.format("[MySimpleServer/initServer] thrHandler.start() OK"));
        }
    }
    
    public Socket acceptSocket(ServerSocket serverSocket) throws Exception
    {
        log.info(String.format("[MySimpleServer/acceptSocket] serverSocket.accept() ready"));
        Socket socket = serverSocket.accept();
        log.info(String.format("[MySimpleServer/acceptSocket] serverSocket.accept() OK"));
        return socket;
    }
    
}
