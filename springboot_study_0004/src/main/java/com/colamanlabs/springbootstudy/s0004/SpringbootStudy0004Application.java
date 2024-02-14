package com.colamanlabs.springbootstudy.s0004;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootStudy0004Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootStudy0004Application.class, args);
    }
    
    @Autowired
    private MySimpleNIOTcpServer simpleServer = null;
    
    /*
     * NIO 소켓서버 샘플 구현
     */
    
    @EventListener(ApplicationReadyEvent.class)
    public void init() throws Exception
    {
        log.info(String.format("[SpringbootStudy0004Application/init] BEGIN"));
        simpleServer.initServerSocket(true);
        
        Thread thread = new Thread(simpleServer);
        thread.start();
        
        log.info(String.format("[SpringbootStudy0004Application/init] END"));
    }
}
