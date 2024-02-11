package com.colamanlabs.springbootstudy.s0002;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootStudy0002Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootStudy0002Application.class, args);
    }
    
    /*
     * STS(eclipse) 에 lombok 을 설치하지 않고 하면,
     * @Slf4j 어노테이션을 지정해도 log 를 인식하지 못하거나, 콘솔로 출력이 안된다.
     * 
     * private final Logger log = LoggerFactory.getLogger(this.getClass());
     * 
     * 회피방법으로 위와 같이 지정해서 사용할 수 있으나,
     * 새 STS(혹은 eclipse) 설치시 lombok 설치 여부를 꼭 확인하자.
     * 
     * 설치여부가 불분명하면,
     * 
     * sts.ini 파일에 lombok 설정이 추가되었는지 확인한다.
     * 
     * ex) 
     * -javaagent:C:\WORKS\WORKS_STS4_GITHUB\STS4\sts-4.21.0.RELEASE\lombok.jar
     *  
     */
    
    @Autowired
    private final MyJDBCTemplateComponent0001 myComponent0001 = null;
    
    
    
    /*

     */
    
    @EventListener(ApplicationReadyEvent.class)
    public void init() throws Exception
    {
        log.info(String.format("[SpringbootStudy0002Application/init] BEGIN"));
        test0001();        
        log.info(String.format("[SpringbootStudy0002Application/init] END"));
    }
    
    
    
    public void test0001() throws Exception
    {
        log.info(String.format("[SpringbootStudy0002Application/test0001] BEGIN"));        
        log.info(String.format("[SpringbootStudy0002Application/test0001] myComponent0001:[%s]", myComponent0001));
//        myComponent0001.checkJdbcTemplate_0000();
//        myComponent0001.checkJdbcTemplate_0001();
        
//        myComponent0001.checkJdbcTemplate_0002_1();
//        myComponent0001.checkJdbcTemplate_0002_2();
//        myComponent0001.checkJdbcTemplate_0003_1();
//        myComponent0001.checkJdbcTemplate_0002_1();
        
        log.info(String.format("[SpringbootStudy0002Application/test0001] END"));
    }
    
}

