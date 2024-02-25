package com.colamanlabs.springbootstudy.s0019;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@EnableBatchProcessing
@SpringBootApplication
@Slf4j
public class SpringbootStudy0019Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootStudy0019Application.class, args);
    }
    
    @Autowired
    private final SlackWebhookManager slackMgr = null;
    
    @EventListener(ApplicationReadyEvent.class)
    public void init() throws Exception
    {
        log.info(String.format("[SpringbootStudy0019Application/init] BEGIN"));
        // slackMgr.apiTest1();
        
        String slackMsg = String.format("슬렉 웹훅 메세지 테스트 date:[%s]", new java.util.Date().toString());

        // slackMgr.apiTest2(slackMsg);
        slackMgr.apiTest3(slackMsg, true);
        log.info(String.format("[SpringbootStudy0019Application/init] END"));
    }
}
