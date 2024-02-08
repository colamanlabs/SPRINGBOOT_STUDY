package com.colamanlabs.springbootstudy.s0001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MyBeanConfig
{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    /*
     * @Bean 으로만 지정시
     * [SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[12]:[createMyBean0001]]
     * 
     * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html
     * 
     * name 이나 value 나 같다. value 가 name 의 alias 이다.
     * 
     * [SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[12]:[myBean0001]]
     */
    @Bean(name = "myBean0001")
    public MyBean0001 createMyBean0001()
    {
        log.debug(String.format("[MyBeanConfig/createMyBean0001] BEGIN"));
        MyBean0001 b0001 = new MyBean0001();
        log.debug(String.format("[MyBeanConfig/createMyBean0001] b0001:[%s]", b0001));
        log.debug(String.format("[MyBeanConfig/createMyBean0001] END"));
        return b0001;
    }
}
