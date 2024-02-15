package com.colamanlabs.springbootstudy.s0007;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;



/*
 * @SpringBootApplication 어노테이션은 선언된 클래스를 Configuration 클래스로 간주하므로, @Configuration 을 명시적으로 선언할 필요가 없다. (스프링배치 완벽가이드 p 98)
 * 
 */
@EnableBatchProcessing
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
