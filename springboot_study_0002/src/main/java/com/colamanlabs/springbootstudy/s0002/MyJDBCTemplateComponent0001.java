package com.colamanlabs.springbootstudy.s0002;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class MyJDBCTemplateComponent0001
{
    
    // private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public MyJDBCTemplateComponent0001(JdbcTemplate jdbcTemplate)
    {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    
    /*
     * JDBCTempleate 테스트
     * 
     * 
     * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
     * 
     * 
     * Package org.springframework.jdbc.core Class JdbcTemplate java.lang.Object org.springframework.jdbc.support.JdbcAccessor
     * org.springframework.jdbc.core.JdbcTemplate All Implemented Interfaces: InitializingBean, JdbcOperations
     * 
     * 
     * 1. 클래스이다. 추상 클래스도 아니고, 인터페이스도 아니다.
     * 
     * 2. 저자에 로드존슨이 있다.
     * 
     * jdbcTemplate 는 주입 되도록 멤버변수로 선언한다.
     */
    
    /*
     * JDBCTemplate 메소드들을 보면 query(...) 형태의 메소드가 있다. 파라미터로 SQL 이 들어간다.
     * 
     * JDBCTemplate 를 바로 주입시키고, query(...) 계열 메소드로 실행시키면 바로 결과를 받을 수 있다. - Connection을 가져오는 것도 없고, - Statement(PreparedStatement) 를 생성하는 것도 없고, - ResultSet 을 리턴받아,
     * 순회하며 결과집합에서 데이터를 추출하는 것도 없다.
     *
     * 
     * 테스트 1) dataSource.getConnection() 할때마다 새로운 커넥션 객체가 리턴된다. conn:[HikariProxyConnection@489123888 wrapping org.mariadb.jdbc.Connection@17609f7f] 그러나, 리턴객체 내부의
     * MariaDB 커넥션 객체는 같은 것을 사용한다. (해시코드가 같다)
     * 
     * conn.close() 를 하지 않으면, 풀 개수에서 허용되는 최대 개수 까지만 허용한다. (active)
     * 
     * close() 하면 실제 isClose false 로 응답하고, 계속 getConnection 허용을 한다.
     * 
     * 그리고, 새로운 getConnection 할때 다시 isClose() false 이다.
     * 
     * 내부까지 확인하지 않았으나,
     * 
     * 1. close() 를 하면 적어도 getConnection() 으로 가져올 경우, 최대 커넥션에 영향을 주지 않는다.
     * 
     * 가능성 1) close() 를 실제 releaseConnecction() 용도로 구현했을 수도 있고,
     * 
     * 가능성 2) close() 는 실제 close() 인데, getConnection() 시 다시 connection 을 맺을 수도 있겠다. (다만 MariaDB 커넥션 객체의 해시코드가 같은 것을 보면, 새로 만들지 않는 것 같다)
     * 
     * 
     * [MyJDBCTemplateComponent0001/checkJdbcTemplate_0000/i:[9998]] dataSource.getConnection() READY [MyJDBCTemplateComponent0001/checkJdbcTemplate_0000/i:[9998]]
     * dataSource.getConnection() OK conn:[HikariProxyConnection@352387249 wrapping org.mariadb.jdbc.Connection@1e889e49] conn.isClosed:[false]
     * [MyJDBCTemplateComponent0001/checkJdbcTemplate_0000/i:[9998]] strNow:[2024-02-11 15:29:59] [MyJDBCTemplateComponent0001/checkJdbcTemplate_0000]
     * conn.isClosed() OK conn.isClosed:[true] [MyJDBCTemplateComponent0001/checkJdbcTemplate_0000/i:[9999]] dataSource.getConnection() READY
     * [MyJDBCTemplateComponent0001/checkJdbcTemplate_0000/i:[9999]] dataSource.getConnection() OK conn:[HikariProxyConnection@1645374430 wrapping
     * org.mariadb.jdbc.Connection@1e889e49] conn.isClosed:[false] [MyJDBCTemplateComponent0001/checkJdbcTemplate_0000/i:[9999]] strNow:[2024-02-11 15:29:59]
     * [MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] conn.isClosed() OK conn.isClosed:[true]
     * 
     */
    
    
    /*
     * 테스트 0000
     */
    
    public void checkJdbcTemplate_0000() throws Exception
    {
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] BEGIN"));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] jdbcTemplate:[%s]", jdbcTemplate));
        
        /*
         * DataSource 를 직접 가져와서 할 경우의 동작
         * 
         * 일단 DataSource 를 가져와서, getConnection() 을 한다면 매번 새로운 커넥션을 DB 에서 가져와서 하는지, 같은 커넥션을 재활용하는지 확인
         * 
         * 10000 번을 반복해서 확인한다.
         */
        
        DataSource dataSource = jdbcTemplate.getDataSource();
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate] dataSource:[%s]", dataSource));
        
        for (int i = 0; i < 10000; ++i)
        {
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000/i:[%04d]] dataSource.getConnection() READY", i));
            Connection conn = dataSource.getConnection();
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000/i:[%04d]] dataSource.getConnection() OK\tconn:[%s]\tconn.isClosed:[%b]", i, conn, conn.isClosed()));
            
            PreparedStatement pStmt = conn.prepareStatement("SELECT now() ;");
            ResultSet rs = pStmt.executeQuery();
            while (rs.next() == true)
            {
                String strNow = rs.getString(1);
                log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000/i:[%04d]] strNow:[%s]", i, strNow));
            }
            rs.close();
            pStmt.close();
            conn.close();
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] conn.isClosed() OK\tconn.isClosed:[%b]", conn.isClosed()));
        }
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0000] END"));
    }
    
    /*
     * 테스트 0001
     * 
     * jdbcTemplate.getDataSource() 의 리턴타입은 DataSource 이지만, 실제 객체는 DataSource 구현체인 HikariDataSource 이다.
     * 
     * HikariDataSource 의 값을 확인한다.

[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] BEGIN
[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] jdbcTemplate:[org.springframework.jdbc.core.JdbcTemplate@72c9c32c]
[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] hikariDataSource:[HikariDataSource (null)]
[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] hikariDataSource.getDataSourceProperties():[{}]
[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] hikariDataSource.getPoolName():[HikariCP TEST POOL]
[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] hikariDataSource.getJdbcUrl():[jdbc:mariadb://127.0.0.1:13306/study]
[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] hikariDataSource.getMaximumPoolSize():[5]
[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] END

     */
    public void checkJdbcTemplate_0001() throws Exception
    {
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] BEGIN"));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] jdbcTemplate:[%s]", jdbcTemplate));
        
        HikariDataSource hikariDataSource = (HikariDataSource) (jdbcTemplate.getDataSource());
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] hikariDataSource:[%s]", hikariDataSource));
        
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] hikariDataSource.getDataSourceProperties():[%s]", hikariDataSource.getDataSourceProperties()));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] hikariDataSource.getPoolName():[%s]", hikariDataSource.getPoolName()));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] hikariDataSource.getJdbcUrl():[%s]", hikariDataSource.getJdbcUrl()));
        
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] hikariDataSource.getMaximumPoolSize():[%d]", hikariDataSource.getMaximumPoolSize()));

//        HikariPoolMXBean mxBean = hikariDataSource.getHikariPoolMXBean();
//        
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] mxBean:[%s]", mxBean));
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] mxBean.getTotalConnections():[%d]", mxBean.getTotalConnections()));
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] mxBean.getActiveConnections():[%d]", mxBean.getActiveConnections()));
//        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] mxBean.getIdleConnections():[%d]", mxBean.getIdleConnections()));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0001] END"));
    }
    
    
    
    
    
    /*
     * 테스트 0002_1
     */
    public void checkJdbcTemplate_0002_1() throws Exception
    {
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_1] BEGIN"));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_1] jdbcTemplate:[%s]", jdbcTemplate));
        
        StringBuffer sbQuery = new StringBuffer();
        sbQuery.append("\n  SELECT                      ");
        sbQuery.append("\n      a.seq_no                ");
        sbQuery.append("\n      , a.value1              ");
        sbQuery.append("\n      , a.value2              ");
        sbQuery.append("\n      , a.value3              ");
        sbQuery.append("\n      , a.reg_dt              ");
        sbQuery.append("\n  FROM                        ");
        sbQuery.append("\n      test_table_0001 a       ");
        sbQuery.append("\n  ORDER BY                    ");
        sbQuery.append("\n      a.seq_no ASC ;          ");
        String strQuery = sbQuery.toString();
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_1] strQuery:[%s]", strQuery));
        
        List<Map<String, Object>> listResult = jdbcTemplate.queryForList(strQuery);
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_1] listResult.size():[%d]", listResult.size()));
        
        for (int i = 0; i<listResult.size(); ++i)
        {
            Map<String, Object> mapData = listResult.get(i);
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_1] i:[%d]\tmapData:[%s]", i, mapData));
            
            Object objValue3 = mapData.get("value3");
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_1] i:[%d]\tObjects.isNull(objValue3):[%b]", i, Objects.isNull(objValue3)));
            
        }
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_1] END"));
    }    
    
    
    
    
    /*
     * 테스트 0002_2
     * 
     * 파라미터 지정
     */
    public void checkJdbcTemplate_0002_2() throws Exception
    {
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_2] BEGIN"));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_2] jdbcTemplate:[%s]", jdbcTemplate));
        
        int seqNoBegin = 1000;
        int seqNoEnd = 1010;
        
        StringBuffer sbQuery = new StringBuffer();
        sbQuery.append("\n  SELECT                      ");
        sbQuery.append("\n      a.seq_no                ");
        sbQuery.append("\n      , a.value1              ");
        sbQuery.append("\n      , a.value2              ");
        sbQuery.append("\n      , a.value3              ");
        sbQuery.append("\n      , a.reg_dt              ");
        sbQuery.append("\n  FROM                        ");
        sbQuery.append("\n      test_table_0001 a       ");
        sbQuery.append("\n  WHERE                       ");
        sbQuery.append("\n      1 = 1                   ");
        sbQuery.append("\n      AND a.seq_no >= ?       ");
        sbQuery.append("\n      AND a.seq_no <  ?       ");
        sbQuery.append("\n  ORDER BY                    ");
        sbQuery.append("\n      a.seq_no ASC ;          ");
        String strQuery = sbQuery.toString();
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_2] strQuery:[%s]", strQuery));
        
        List<Map<String, Object>> listResult = jdbcTemplate.queryForList(strQuery, seqNoBegin, seqNoEnd);
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_2] listResult.size():[%d]", listResult.size()));
        
        for (int i = 0; i<listResult.size(); ++i)
        {
            Map<String, Object> mapData = listResult.get(i);
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_2] i:[%d]\tmapData:[%s]", i, mapData));
            
            Object objValue3 = mapData.get("value3");
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_2] i:[%d]\tObjects.isNull(objValue3):[%b]", i, Objects.isNull(objValue3)));
            
        }
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0002_2] END"));
    }    
    
    
    /*
     * 테스트 0003_1
     * 
     * 파라미터 지정
     */
    public void checkJdbcTemplate_0003_1() throws Exception
    {
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0003_1] BEGIN"));
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0003_1] jdbcTemplate:[%s]", jdbcTemplate));
        
        StringBuffer sbQuery = new StringBuffer();
        sbQuery.append("\n  INSERT INTO test_table_0001     ");
        sbQuery.append("\n  (                               ");       
        sbQuery.append("\n      value1                      ");
        sbQuery.append("\n      , value2                    ");
        sbQuery.append("\n      , value3                    ");
        sbQuery.append("\n  )                               ");
        sbQuery.append("\n  VALUES                          ");
        sbQuery.append("\n  (                               ");
        sbQuery.append("\n      ?                           ");
        sbQuery.append("\n      , ?                         ");
        sbQuery.append("\n      , ?                         ");       
        sbQuery.append("\n  ) ;                             ");
        String strQuery = sbQuery.toString();
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0003_1] strQuery:[%s]", strQuery));
        
        
        for (int i = 1; i < 100; ++i)
        {
            String value1 = new java.util.Date().toString();
            String value2 = String.format("%d", (int) (Math.random() * 1000000));
            String value3 = null;
            int result = jdbcTemplate.update(strQuery, value1, value2, value3);
            log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0003_1] i:[%d]\tresult:[%d]", i, result));
        }        
        log.info(String.format("[MyJDBCTemplateComponent0001/checkJdbcTemplate_0003_1] END"));
    }
}
