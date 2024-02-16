package com.colamanlabs.springbootstudy.s0008;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@EnableBatchProcessing
@SpringBootApplication
@Slf4j
public class SpringbootStudy0008Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootStudy0008Application.class, args);
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void init()
    {
        log.info(String.format("[SpringbootStudy0008Application/init] BEGIN"));
        log.info(String.format("[SpringbootStudy0008Application/init] END"));
    }
    
}
