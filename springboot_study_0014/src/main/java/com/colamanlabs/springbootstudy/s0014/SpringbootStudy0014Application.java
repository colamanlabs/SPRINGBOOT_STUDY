package com.colamanlabs.springbootstudy.s0014;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;



import lombok.extern.slf4j.Slf4j;

@EnableBatchProcessing
@SpringBootApplication
@Slf4j
public class SpringbootStudy0014Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(ChunkJob.class, args);
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void init()
    {
        log.info(String.format("[SpringbootStudy0013Application/init] BEGIN"));
        log.info(String.format("[SpringbootStudy0013Application/init] END"));
    }
}
