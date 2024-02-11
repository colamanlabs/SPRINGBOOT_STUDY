package com.colamanlabs.springbootstudy.s0003;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootStudy0003Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootStudy0003Application.class, args);
    }
    
    /*
     * 
     * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/event/SpringApplicationEvent.html
     * 
     * Direct Known Subclasses: ApplicationContextInitializedEvent, ApplicationEnvironmentPreparedEvent, ApplicationFailedEvent, ApplicationPreparedEvent,
     * ApplicationReadyEvent, ApplicationStartedEvent, ApplicationStartingEvent
     * 
     * 각각의 역할은 javadoc 문서 보고 확인하자.
     *
     */
    
    @Autowired
    private MySimpleServer simpleServer = null;
    
    /*
     * 리거시 소켓서버 형태의 에코서버 구현후 테스트 한다.
     */
    
    @EventListener(ApplicationReadyEvent.class)
    public void init() throws Exception
    {
        log.info(String.format("[SpringbootStudy0002Application/init] BEGIN"));
        simpleServer.initServer();
        log.info(String.format("[SpringbootStudy0002Application/init] END"));
    }
    
}
