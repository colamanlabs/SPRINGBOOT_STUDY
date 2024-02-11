package com.colamanlabs.springbootstudy.s0002;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class MyJDBCTemplateComponent0001
{
    
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public MyJDBCTemplateComponent0001(JdbcTemplate jdbcTemplate)
    {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    

    
    
    
    /*
     * 10 개 까지 성공하고, 이후 에러난다.
     * 기본 히카리시피의 커넥션 개수는 10개임을 확인할 수 있다.
     * 
[2m2024-02-09T23:16:37.783+09:00[0;39m [32m INFO[0;39m [35m8256[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [2m[0;39m[36mc.c.s.s0002.MyJDBCTemplateComponent0001             [0;39m [2m:[0;39m [MyJDBCTemplateComponent0001/checkJdbcTemplate] dataSource:[HikariDataSource (HikariPool-1)]
java.sql.SQLTransientConnectionException: HikariPool-1 - Connection is not available, request timed out after 30014ms.
    at com.zaxxer.hikari.pool.HikariPool.createTimeoutException(HikariPool.java:696)
    at com.zaxxer.hikari.pool.HikariPool.getConnection(HikariPool.java:181)
    at com.zaxxer.hikari.pool.HikariPool.getConnection(HikariPool.java:146)
    at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:128)
    at com.colamanlabs.springbootstudy.s0002.MyJDBCTemplateComponent0001.checkJdbcTemplate_0000(MyJDBCTemplateComponent0001.java:57)
    at com.colamanlabs.springbootstudy.s0002.MyJDBCTemplateComponent0001.test0000(MyJDBCTemplateComponent0001.java:41)
    at com.colamanlabs.springbootstudy.s0002.SpringbootStudy0002Application.init(SpringbootStudy0002Application.java:32)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:568)
    at org.springframework.context.event.ApplicationListenerMethodAdapter.doInvoke(ApplicationListenerMethodAdapter.java:365)
    at org.springframework.context.event.ApplicationListenerMethodAdapter.processEvent(ApplicationListenerMethodAdapter.java:237)
    at org.springframework.context.event.ApplicationListenerMethodAdapter.onApplicationEvent(ApplicationListenerMethodAdapter.java:168)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:178)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:171)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:149)
    at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:451)
    at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:384)
    at org.springframework.boot.context.event.EventPublishingRunListener.ready(EventPublishingRunListener.java:109)
    at org.springframework.boot.SpringApplicationRunListeners.lambda$ready$6(SpringApplicationRunListeners.java:80)
    at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:118)
    at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:112)
    at org.springframework.boot.SpringApplicationRunListeners.ready(SpringApplicationRunListeners.java:80)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:348)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1354)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1343)
    at com.colamanlabs.springbootstudy.s0002.SpringbootStudy0002Application.main(SpringbootStudy0002Application.java:17)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:568)
    at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50)
    
    
    checkJdbcTemplate_0000() 에서는 getConnection 으로 가져온 것을 conn.close() 시키므로, 마지막 커넥션이 끝나면 에러이다.
     */
    public void checkJdbcTemplate_0000() throws Exception
    {
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] BEGIN"));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] jdbcTemplate:[%s]", jdbcTemplate));
        
        DataSource dataSource = jdbcTemplate.getDataSource();
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate] dataSource:[%s]", dataSource));
        try
        {
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] dataSource.getConnection() READY"));
            Connection conn = dataSource.getConnection();
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] dataSource.getConnection() OK\tconn:[%s]", conn));
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] conn:[%s]", conn));
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] conn.isClosed() READY\tconn.isClosed:[%b]", conn.isClosed()));
            conn.close();
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] conn.isClosed() OK\tconn.isClosed:[%b]", conn.isClosed()));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] END"));        
    }
    

    
    
    public void checkJdbcTemplate_0000_1() throws Exception
    {
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] BEGIN"));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] jdbcTemplate:[%s]", jdbcTemplate));
        
        DataSource dataSource = jdbcTemplate.getDataSource();
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate] dataSource:[%s]", dataSource));
        while(true)
        {
            try
            {
                log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] dataSource.getConnection() READY"));
                Connection conn = dataSource.getConnection();
                log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] dataSource.getConnection() OK\tconn:[%s]", conn));
                log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] conn:[%s]", conn));
                log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] conn.isClosed() READY\tconn.isClosed:[%b]", conn.isClosed()));
                conn.close();
                log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] conn.isClosed() OK\tconn.isClosed:[%b]", conn.isClosed()));
            }
            catch(Exception e)
            {
                e.printStackTrace();
                throw new Exception(e);
            }
        }
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] END"));        
    }
    
    
    
    
    
    
    public void test0001()
    {
        for (int i = 0; i<100; ++i)
        {
            log.info(String.format("[MyJDBCTemplateComponent0001/test0001] i:[%d]", i));    
            checkJdbcTemplate_0001();
        }
    }
    
    
    
    /*
     * getConnection() close 없이 연속으로 6개 하면 결국 에러다.
     * 
2024-02-09T23:20:07.330+09:00[0;39m [32m INFO[0;39m [35m444[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [2m[0;39m[36mc.c.s.s0002.MyJDBCTemplateComponent0001             [0;39m [2m:[0;39m [MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] dataSource:[HikariDataSource (HikariPool-2)]
java.sql.SQLTransientConnectionException: HikariPool-1 - Connection is not available, request timed out after 30004ms.
    at com.zaxxer.hikari.pool.HikariPool.createTimeoutException(HikariPool.java:696)
    at com.zaxxer.hikari.pool.HikariPool.getConnection(HikariPool.java:181)
    at com.zaxxer.hikari.pool.HikariPool.getConnection(HikariPool.java:146)
    at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:128)
    at com.colamanlabs.springbootstudy.s0002.MyJDBCTemplateComponent0001.checkJdbcTemplate_0001(MyJDBCTemplateComponent0001.java:139)
    at com.colamanlabs.springbootstudy.s0002.MyJDBCTemplateComponent0001.test0001(MyJDBCTemplateComponent0001.java:125)
    at com.colamanlabs.springbootstudy.s0002.SpringbootStudy0002Application.init(SpringbootStudy0002Application.java:33)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:568)
    at org.springframework.context.event.ApplicationListenerMethodAdapter.doInvoke(ApplicationListenerMethodAdapter.java:365)
    at org.springframework.context.event.ApplicationListenerMethodAdapter.processEvent(ApplicationListenerMethodAdapter.java:237)
    at org.springframework.context.event.ApplicationListenerMethodAdapter.onApplicationEvent(ApplicationListenerMethodAdapter.java:168)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:178)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:171)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:149)
    at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:451)
    at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:384)
    at org.springframework.boot.context.event.EventPublishingRunListener.ready(EventPublishingRunListener.java:109)
    at org.springframework.boot.SpringApplicationRunListeners.lambda$ready$6(SpringApplicationRunListeners.java:80)
    at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:118)
    at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:112)
    at org.springframework.boot.SpringApplicationRunListeners.ready(SpringApplicationRunListeners.java:80)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:348)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1354)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1343)
    at com.colamanlabs.springbootstudy.s0002.SpringbootStudy0002Application.main(SpringbootStudy0002Application.java:17)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:568)
    at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50)
     */
    
    public void checkJdbcTemplate_0001()
    {
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] BEGIN"));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] jdbcTemplate:[%s]", jdbcTemplate));
        
        DataSource dataSource = jdbcTemplate.getDataSource();
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] dataSource:[%s]", dataSource));
        try
        {
            Connection conn = dataSource.getConnection();
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] dataSource.getConnection():[%s]", dataSource.getConnection()));
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] conn:[%s]", conn));
            conn.close();
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] conn.isClosed():[%b]", conn.isClosed()));            
        }
        catch(Exception e)
        {
            e.printStackTrace();            
        }
        
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] END"));
        
    }
    
    
    public void test0002() throws Exception
    {
//        for (int i = 0; i<30; ++i)
//        {
//            log.info(String.format("[MyJDBCTemplateComponent0001/test0002] i:[%d]", i));    
//            checkJdbcTemplate_0002();
//        }
        checkJdbcTemplate_0002();
    }
    
    
/*
2024-02-10T09:18:46.335+09:00[0;39m [32m INFO[0;39m [35m8536[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [2m[0;39m[36mc.c.s.s0002.MyJDBCTemplateComponent0001             [0;39m [2m:[0;39m [MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] dataSource:[HikariDataSource (HikariPool-1)]
java.sql.SQLTransientConnectionException: HikariPool-1 - Connection is not available, request timed out after 30008ms.
    at com.zaxxer.hikari.pool.HikariPool.createTimeoutException(HikariPool.java:696)
    at com.zaxxer.hikari.pool.HikariPool.getConnection(HikariPool.java:181)
    at com.zaxxer.hikari.pool.HikariPool.getConnection(HikariPool.java:146)
    at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:128)
    at com.colamanlabs.springbootstudy.s0002.MyJDBCTemplateComponent0001.checkJdbcTemplate_0002(MyJDBCTemplateComponent0001.java:217)
    at com.colamanlabs.springbootstudy.s0002.MyJDBCTemplateComponent0001.test0002(MyJDBCTemplateComponent0001.java:202)
    at com.colamanlabs.springbootstudy.s0002.SpringbootStudy0002Application.init(SpringbootStudy0002Application.java:33)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:568)
    at org.springframework.context.event.ApplicationListenerMethodAdapter.doInvoke(ApplicationListenerMethodAdapter.java:365)
    at org.springframework.context.event.ApplicationListenerMethodAdapter.processEvent(ApplicationListenerMethodAdapter.java:237)
    at org.springframework.context.event.ApplicationListenerMethodAdapter.onApplicationEvent(ApplicationListenerMethodAdapter.java:168)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:178)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:171)
    at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:149)
    at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:451)
    at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:384)
    at org.springframework.boot.context.event.EventPublishingRunListener.ready(EventPublishingRunListener.java:109)
    at org.springframework.boot.SpringApplicationRunListeners.lambda$ready$6(SpringApplicationRunListeners.java:80)
    at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:118)
    at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:112)
    at org.springframework.boot.SpringApplicationRunListeners.ready(SpringApplicationRunListeners.java:80)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:348)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1354)
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1343)
    at com.colamanlabs.springbootstudy.s0002.SpringbootStudy0002Application.main(SpringbootStudy0002Application.java:17)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:568)
    at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50)
[2m2024-02-10T09:19:16.365+09:00[0;39m [31mERROR[0;39m [35m8536[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [2m[0;39m[36mo.s.boot.SpringApplication              [0;39m [2m:[0;39m Application run failed
     
 */
    
    public void checkJdbcTemplate_0002() throws Exception
    {
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002] BEGIN"));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002] jdbcTemplate:[%s]", jdbcTemplate));
        
        HikariDataSource hikariDataSource = (HikariDataSource)(jdbcTemplate.getDataSource());
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002] hikariDataSource:[%s]", hikariDataSource));
        
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002] hikariDataSource.getDataSourceProperties():[%s]", hikariDataSource.getDataSourceProperties()));
        
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002] hikariDataSource.getPoolName():[%s]", hikariDataSource.getPoolName() ));
        
        
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002] hikariDataSource.getJdbcUrl():[%s]", hikariDataSource.getJdbcUrl() ));
        Connection conn = hikariDataSource.getConnection();
        
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002] conn:[%s]", conn ));
        
        
        
        
//        
//        
//        try
//        {
//            Connection conn = dataSource.getConnection();
//            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] dataSource.getConnection():[%s]", dataSource.getConnection()));
//            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] conn:[%s]", conn));
////            conn.close();
//            
//            
//            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] conn.isClosed():[%b]", conn.isClosed()));            
//        }
//        catch(Exception e)
//        {            
//            e.printStackTrace();
//            throw new Exception(e);
//        }
        
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] END"));
        
    }        
    
    
    
    
    
    /*
     * Package org.springframework.jdbc.core
     * 
     * Class JdbcTemplate
     * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
     */
    
    
    
    
    
    
    public void test0003() throws Exception
    {
        for (int i = 0; i<10000; ++i)
        {
//            log.info(String.format("[MyJDBCTemplateComponent0001/test0003] i:[%d]", i));    
            checkJdbcTemplate_0003();
        }
    }
    
    
    
    public void checkJdbcTemplate_0003() throws Exception
    {
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0003] BEGIN"));
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0003] jdbcTemplate:[%s]", jdbcTemplate));
        List<Map<String, Object>> listResult = jdbcTemplate.queryForList("SELECT now() ;");
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0003] listResult:[%s]", listResult));
        
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] END"));        
    }       
    
    
    
    public void test0004() throws Exception
    {
        for (int i = 0; i<10000; ++i)
        {
            checkJdbcTemplate_0004();
            Thread.sleep(100);
        }
    }
    
    public void checkJdbcTemplate_0004() throws Exception
    {
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0004] BEGIN"));
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0004] jdbcTemplate:[%s]", jdbcTemplate));
        
        
        String strSqlInsert0 = "INSERT test_table_0001(value1, value2) VALUES ( ?, ? ) ;";
        
        String strValue1 = new java.util.Date().toString(); 
        String strValue2 = String.format("%d", (int)(Math.random()*1000000));
        
        
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0004] strValue1:[%s]\tstrValue2:[%s]", strValue1, strValue2));
        
        jdbcTemplate.update(strSqlInsert0, strValue1, strValue2);
        
        
        List<Map<String, Object>> listResult = jdbcTemplate.queryForList("SELECT * from test_table_0001 ;");
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0004] listResult:[%s]", listResult));
        
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0004] END"));        
    }         
}
