

================================================================================
최초 실행시 아래와 같은 에러가 발생한다.



  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.2.2)[0;39m

[2m2024-02-09T16:38:30.211+09:00[0;39m [32m INFO[0;39m [35m8008[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [2m[0;39m[36mc.c.s.s.SpringbootStudy0002Application  [0;39m [2m:[0;39m Starting SpringbootStudy0002Application using Java 17 with PID 8008 (C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0002\target\classes started by colaman in C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0002)
[2m2024-02-09T16:38:30.213+09:00[0;39m [32m INFO[0;39m [35m8008[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [2m[0;39m[36mc.c.s.s.SpringbootStudy0002Application  [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2024-02-09T16:38:30.240+09:00[0;39m [32m INFO[0;39m [35m8008[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [2m[0;39m[36m.e.DevToolsPropertyDefaultsPostProcessor[0;39m [2m:[0;39m Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
[2m2024-02-09T16:38:30.662+09:00[0;39m [33m WARN[0;39m [35m8008[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [2m[0;39m[36ms.c.a.AnnotationConfigApplicationContext[0;39m [2m:[0;39m Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSource' defined in class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceConfiguration$Hikari.class]: Failed to instantiate [com.zaxxer.hikari.HikariDataSource]: Factory method 'dataSource' threw exception with message: Failed to determine a suitable driver class
[2m2024-02-09T16:38:30.668+09:00[0;39m [32m INFO[0;39m [35m8008[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [2m[0;39m[36m.s.b.a.l.ConditionEvaluationReportLogger[0;39m [2m:[0;39m 

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
[2m2024-02-09T16:38:30.684+09:00[0;39m [31mERROR[0;39m [35m8008[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [2m[0;39m[36mo.s.b.d.LoggingFailureAnalysisReporter  [0;39m [2m:[0;39m 

***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.

Reason: Failed to determine a suitable driver class


Action:

Consider the following:
	If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.
	If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).



스프링 스타터에서 MariaDB Driver 를 선택하면 발생하는 것으로 보인다.
================================================================================


https://velog.io/@agline/SpringBoot-Failed-to-configure-a-DataSource-url-attribute-is-not-specified-and-no-embedded-datasource-could-be-configured
 
 
DB를 사용하지 않는 경우
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) 추가

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

DB를 사용하는 경우
application.properties에서 설정 추가

spring.datasource.url=jdbc:[Database]://localhost:3306/[Database스키마]
spring.datasource.username=[DB 아이디]
spring.datasource.password=[DB 비밀번호]
spring.datasource.driver-class-name=[JDBC 드라이버]



================================================================================


https://docs.spring.io/spring-boot/docs/current/reference/html/data.html


스프링부트 공식 가이드

spring.datasource.url=jdbc:mysql://localhost/test
spring.datasource.username=dbuser
spring.datasource.password=dbpass
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

spring.datasource.url=jdbc:mariadb://127.0.0.1:13306/study
spring.datasource.username=studyuser
spring.datasource.password=studyuser
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver








================================================================================



https://www.baeldung.com/spring-boot-hikari





#spring.datasource.url=jdbc:mariadb://127.0.0.1:13306/study
#spring.datasource.username=studyuser
#spring.datasource.password=studyuser
#spring.datasource.driver-class-name=org.mariadb.jdbc.Driver


spring.datasource.hikari.jdbc-url=jdbc:mariadb://127.0.0.1:13306/study
spring.datasource.hikari.username=studyuser
spring.datasource.hikari.password=studyuser
spring.datasource.hikari.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.hikari.maximum-pool-size=5
spring.datasource.hikari.pool-name=HikariCP TEST POOL


# hikariCP 의 로그레벨 설정
logging.level.com.zaxxer.hikari.pool:debug

# springjdbc 로그레벨 설정
logging.level.org.springframework.jdbc=debug



================================================================================