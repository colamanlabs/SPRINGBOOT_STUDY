package com.colamanlabs.springbootstudy.s0001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootStudy0001Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudy0001Application.class, args);
	}
	
	
	/*
	 * [issue 0001]
	 * @Slf4j 어노테이션을 추가했음에도, log.info() 가 인식되지 않으면, Logger 를 추가한다. 
	 * private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());   
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	
	@Autowired
	private final ApplicationContext applicationContext = null;
	
	/*
	 * @EventListener 
	 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/event/EventListener.html
	 * 
	 * ApplicationReadyEvent
	 * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/event/ApplicationReadyEvent.html
	 * SpringApplication의 초기화가 완료되었을때 콜백 된다. 
	 */
    @EventListener(ApplicationReadyEvent.class)
    public void init()
    {
        log.debug(String.format("[SpringbootStudy0001Application/init] BEGIN"));

        checkApplicationContext();
        
        
        checkValueAnnotation();
        
        log.debug(String.format("[SpringbootStudy0001Application/init] END"));
    }	
    
    
    
    public void checkApplicationContext()
    {
        log.debug(String.format("[SpringbootStudy0001Application/checkApplicationContext] BEGIN"));
        
        /*
         * [SpringbootStudy0001Application/checkApplicationContext] applicationContext:[org.springframework.context.annotation.AnnotationConfigApplicationContext@2b3df9ff, started on Thu Feb 08 23:18:54 KST 2024]
         */
        log.debug(String.format("[SpringbootStudy0001Application/checkApplicationContext] applicationContext:[%s]", applicationContext));
        
        String[] arrBeanNames = applicationContext.getBeanDefinitionNames();
        
        /*
         * [SpringbootStudy0001Application/checkApplicationContext] arrBeanNames.length:[75]
         */
        log.debug(String.format("[SpringbootStudy0001Application/checkApplicationContext] arrBeanNames.length:[%d]", arrBeanNames.length));
        
        /*
         * 등록된 bean 이 줄줄줄 출력된다.
         * @Component 로 등록한 빈도 같이 출력된다.
         * 별도로 이름을 지정하지 않으면 클래스명 을 따르고, 맨 앞 글자만 소문자로 변경된다. 
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[7]:[myComponent0001]]
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[8]:[myComponent0002]]
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[9]:[myComponent0003]]
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[10]:[myComponent0004]]
         */
        for (int i = 0; i<arrBeanNames.length; ++i)
        {
            String beanInfo = String.format("arrBeanNames[%d]:[%s]", i, arrBeanNames[i]);
            log.debug(String.format("[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[%s]", beanInfo));                    
        }
        
        
        /*
         * @Component 로 된 것은 컴포넌트 스캔 과정에서 자동으로 어플리케이션 컨텍스트에 등록된다.
         * 컴포넌트 생성 정책(스코프)은 싱글톤 이다.
         * 프로토타입으로 하면 요청시마다 만들 수 있다.
         * 
         * 프로토타입 빈에서 싱글톤 빈을 참조하는 것은 문제 없으나,
         * 싱글톤 빈에서 프로토타입 빈을 참조하면, 
         * 싱글톤 빈은 1회만 주입되는데, 이때 프로토타입 빈 주입도 완료되므로,
         * 프로토타입빈 변경(새로 만들어진 것들)이 반영되지 않는다.
         */

        /*
         * 스트링으로 바로 쓰면 대소문자 차이로 오동작 할 수 있으니, static 상수를 쓰는게 낫겠다.
         */
        log.debug(String.format("[SpringbootStudy0001Application/checkApplicationContext] ConfigurableBeanFactory.SCOPE_SINGLETON:[%s]", ConfigurableBeanFactory.SCOPE_SINGLETON));
        log.debug(String.format("[SpringbootStudy0001Application/checkApplicationContext] ConfigurableBeanFactory.SCOPE_PROTOTYPE:[%s]", ConfigurableBeanFactory.SCOPE_PROTOTYPE));
        
        /*
         * @Configuration 으로 정의한 클래스에 @Bean 어노테이션으로 빈을 등록할 수 있다. 
         */
        
        log.debug(String.format("[SpringbootStudy0001Application/checkApplicationContext] END"));
    }
    
    
    
    
    
    
    
    
    /*
@Value
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Value.html


     */
    
    
    @Value("${app.name}")
    private final String appName = null;
    
    @Value("${app.name.sample01}")
    private final String appNameSample01 = null;
    
    @Value("${app.name.sample02}")
    private final String appNameSample02 = null;
    
    @Value("${app.name.sample03}")
    private final String appNameSample03 = null;        
    
    @Value("${app.name.sample04}")
    private final String appNameSample04 = null;    
    
    
    public void checkValueAnnotation()
    {
        log.debug(String.format("[SpringbootStudy0001Application/checkValueAnnotation] BEGIN"));
        log.debug(String.format("[SpringbootStudy0001Application/checkValueAnnotation] appName:[%s]", appName));
        
        
        /*
         * 
app.name=springboot_study_0001
app.name.sample1="springboot_study_0001_sample1"
app.name.sample2="springboot_study_0001_sample2


[SpringbootStudy0001Application/checkValueAnnotation] appName:[springboot_study_0001]


프로퍼티 지정시 "" 를 추가하면 "" 이 포함이 된다.
[SpringbootStudy0001Application/checkValueAnnotation] appName:[springboot_study_0001]
[SpringbootStudy0001Application/checkValueAnnotation] appNameSample01:["springboot_study_0001_sample01"]
[SpringbootStudy0001Application/checkValueAnnotation] appNameSample02:["springboot_study_0001_sample02]
[SpringbootStudy0001Application/checkValueAnnotation] appNameSample03:[springboot_study_0001_sample03 param1 param2 param3 param4 param5]
[SpringbootStudy0001Application/checkValueAnnotation] appNameSample04:[springboot_study_0001_sample04 param1 param2 ]


프로퍼티 지정은 개행문자 나올때 까지 인식된다.
app.name.sample04=springboot_study_0001_sample04 param1 param2 
param3 param4 param5


         */
        log.debug(String.format("[SpringbootStudy0001Application/checkValueAnnotation] appNameSample01:[%s]", appNameSample01));
        log.debug(String.format("[SpringbootStudy0001Application/checkValueAnnotation] appNameSample02:[%s]", appNameSample02));
        log.debug(String.format("[SpringbootStudy0001Application/checkValueAnnotation] appNameSample03:[%s]", appNameSample03));
        log.debug(String.format("[SpringbootStudy0001Application/checkValueAnnotation] appNameSample04:[%s]", appNameSample04));
        log.debug(String.format("[SpringbootStudy0001Application/checkValueAnnotation] END"));
    }

}
