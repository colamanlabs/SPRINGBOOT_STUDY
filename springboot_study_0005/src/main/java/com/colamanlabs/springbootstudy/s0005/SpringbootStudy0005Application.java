package com.colamanlabs.springbootstudy.s0005;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootStudy0005Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootStudy0005Application.class, args);
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void init() throws Exception
    {
        log.info(String.format("[SpringbootStudy0005Application/init] BEGIN"));
        log.info(String.format("[SpringbootStudy0005Application/init] END"));
    }
}
