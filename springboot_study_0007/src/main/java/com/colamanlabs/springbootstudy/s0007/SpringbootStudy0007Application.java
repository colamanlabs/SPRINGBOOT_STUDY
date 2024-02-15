package com.colamanlabs.springbootstudy.s0007;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootStudy0007Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootStudy0007Application.class, args);
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void init()
    {
        log.info(String.format("[SpringbootStudy0007Application/init] BEGIN"));
        log.info(String.format("[SpringbootStudy0007Application/init] END"));
    }
}
