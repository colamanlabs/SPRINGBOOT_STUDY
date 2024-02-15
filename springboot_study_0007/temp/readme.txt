

스프링배치 완벽가이드 2판

3장 예제 잡 애플리케이션

업무요건 소개로서 개발 관련 내용은 없다.



4장 잡과 스텝 이해하기






22:58:52.446 [Thread-0] DEBUG org.springframework.boot.devtools.restart.classloader.RestartClassLoader - Created RestartClassLoader org.springframework.boot.devtools.restart.classloader.RestartClassLoader@75d256d0

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m             [2m (v2.7.18)[0;39m

[2m2024-02-15 22:58:52.703[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0007Application  [0;39m [2m:[0;39m Starting SpringbootStudy0007Application using Java 17 on DEFAULT3 with PID 452 (C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0007\target\classes started by colaman in C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0007)
[2m2024-02-15 22:58:52.704[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0007Application  [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2024-02-15 22:58:52.739[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36m.e.DevToolsPropertyDefaultsPostProcessor[0;39m [2m:[0;39m Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
[2m2024-02-15 22:58:53.230[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mcom.zaxxer.hikari.HikariDataSource      [0;39m [2m:[0;39m HikariCP TEST POOL - Starting...
[2m2024-02-15 22:58:53.298[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mcom.zaxxer.hikari.HikariDataSource      [0;39m [2m:[0;39m HikariCP TEST POOL - Start completed.
[2m2024-02-15 22:58:53.347[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.r.s.JobRepositoryFactoryBean    [0;39m [2m:[0;39m No database type set, using meta data indicating: MYSQL
[2m2024-02-15 22:58:53.459[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m No TaskExecutor has been set, defaulting to synchronous executor.
[2m2024-02-15 22:58:53.522[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.d.a.OptionalLiveReloadServer      [0;39m [2m:[0;39m LiveReload server is running on port 35729
[2m2024-02-15 22:58:53.537[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0007Application  [0;39m [2m:[0;39m Started SpringbootStudy0007Application in 1.081 seconds (JVM running for 1.592)
[2m2024-02-15 22:58:53.538[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.a.b.JobLauncherApplicationRunner  [0;39m [2m:[0;39m Running default command line with: []
[2m2024-02-15 22:58:53.552[0;39m [33m WARN[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.m.jdbc.message.server.ErrorPacket     [0;39m [2m:[0;39m Error: 1146-42S02: Table 'study.batch_job_instance' doesn't exist
[2m2024-02-15 22:58:53.608[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mConditionEvaluationReportLoggingListener[0;39m [2m:[0;39m 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
[2m2024-02-15 22:58:53.630[0;39m [31mERROR[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.boot.SpringApplication              [0;39m [2m:[0;39m Application run failed

java.lang.IllegalStateException: Failed to execute ApplicationRunner
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:759) ~[spring-boot-2.7.18.jar:2.7.18]
	at org.springframework.boot.SpringApplication.lambda$callRunners$2(SpringApplication.java:746) ~[spring-boot-2.7.18.jar:2.7.18]
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183) ~[na:na]
	at java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) ~[na:na]
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150) ~[na:na]
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596) ~[na:na]
	at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:744) ~[spring-boot-2.7.18.jar:2.7.18]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[spring-boot-2.7.18.jar:2.7.18]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1300) ~[spring-boot-2.7.18.jar:2.7.18]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1289) ~[spring-boot-2.7.18.jar:2.7.18]
	at com.colamanlabs.springbootstudy.s0007.SpringbootStudy0007Application.main(SpringbootStudy0007Application.java:20) ~[classes/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50) ~[spring-boot-devtools-2.7.18.jar:2.7.18]
Caused by: org.springframework.jdbc.BadSqlGrammarException: PreparedStatementCallback; bad SQL grammar [SELECT JOB_INSTANCE_ID, JOB_NAME from BATCH_JOB_INSTANCE where JOB_NAME = ? and JOB_KEY = ?]; nested exception is java.sql.SQLSyntaxErrorException: (conn=3) Table 'study.batch_job_instance' doesn't exist
	at org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator.doTranslate(SQLErrorCodeSQLExceptionTranslator.java:236) ~[spring-jdbc-5.3.31.jar:5.3.31]
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73) ~[spring-jdbc-5.3.31.jar:5.3.31]
	at org.springframework.jdbc.core.JdbcTemplate.translateException(JdbcTemplate.java:1577) ~[spring-jdbc-5.3.31.jar:5.3.31]
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:669) ~[spring-jdbc-5.3.31.jar:5.3.31]
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:715) ~[spring-jdbc-5.3.31.jar:5.3.31]
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:746) ~[spring-jdbc-5.3.31.jar:5.3.31]
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:759) ~[spring-jdbc-5.3.31.jar:5.3.31]
	at org.springframework.jdbc.core.JdbcTemplate.query(JdbcTemplate.java:817) ~[spring-jdbc-5.3.31.jar:5.3.31]
	at org.springframework.batch.core.repository.dao.JdbcJobInstanceDao.getJobInstance(JdbcJobInstanceDao.java:151) ~[spring-batch-core-4.3.10.jar:4.3.10]
	at org.springframework.batch.core.repository.support.SimpleJobRepository.isJobInstanceExists(SimpleJobRepository.java:93) ~[spring-batch-core-4.3.10.jar:4.3.10]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344) ~[spring-aop-5.3.31.jar:5.3.31]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.3.31.jar:5.3.31]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.3.31.jar:5.3.31]
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123) ~[spring-tx-5.3.31.jar:5.3.31]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:388) ~[spring-tx-5.3.31.jar:5.3.31]
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119) ~[spring-tx-5.3.31.jar:5.3.31]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.31.jar:5.3.31]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:241) ~[spring-aop-5.3.31.jar:5.3.31]
	at jdk.proxy2/jdk.proxy2.$Proxy60.isJobInstanceExists(Unknown Source) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344) ~[spring-aop-5.3.31.jar:5.3.31]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.3.31.jar:5.3.31]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.3.31.jar:5.3.31]
	at org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$PassthruAdvice.invoke(SimpleBatchConfiguration.java:128) ~[spring-batch-core-4.3.10.jar:4.3.10]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.31.jar:5.3.31]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:241) ~[spring-aop-5.3.31.jar:5.3.31]
	at jdk.proxy3/jdk.proxy3.$Proxy48.isJobInstanceExists(Unknown Source) ~[na:na]
	at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.getNextJobParameters(JobLauncherApplicationRunner.java:220) ~[spring-boot-autoconfigure-2.7.18.jar:2.7.18]
	at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.execute(JobLauncherApplicationRunner.java:212) ~[spring-boot-autoconfigure-2.7.18.jar:2.7.18]
	at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.executeLocalJobs(JobLauncherApplicationRunner.java:193) ~[spring-boot-autoconfigure-2.7.18.jar:2.7.18]
	at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.launchJobFromProperties(JobLauncherApplicationRunner.java:172) ~[spring-boot-autoconfigure-2.7.18.jar:2.7.18]
	at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.run(JobLauncherApplicationRunner.java:167) ~[spring-boot-autoconfigure-2.7.18.jar:2.7.18]
	at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.run(JobLauncherApplicationRunner.java:162) ~[spring-boot-autoconfigure-2.7.18.jar:2.7.18]
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:756) ~[spring-boot-2.7.18.jar:2.7.18]
	... 19 common frames omitted
Caused by: java.sql.SQLSyntaxErrorException: (conn=3) Table 'study.batch_job_instance' doesn't exist
	at org.mariadb.jdbc.export.ExceptionFactory.createException(ExceptionFactory.java:282) ~[mariadb-java-client-3.1.4.jar:na]
	at org.mariadb.jdbc.export.ExceptionFactory.create(ExceptionFactory.java:370) ~[mariadb-java-client-3.1.4.jar:na]
	at org.mariadb.jdbc.message.ClientMessage.readPacket(ClientMessage.java:134) ~[mariadb-java-client-3.1.4.jar:na]
	at org.mariadb.jdbc.client.impl.StandardClient.readPacket(StandardClient.java:872) ~[mariadb-java-client-3.1.4.jar:na]
	at org.mariadb.jdbc.client.impl.StandardClient.readResults(StandardClient.java:811) ~[mariadb-java-client-3.1.4.jar:na]
	at org.mariadb.jdbc.client.impl.StandardClient.readResponse(StandardClient.java:730) ~[mariadb-java-client-3.1.4.jar:na]
	at org.mariadb.jdbc.client.impl.StandardClient.execute(StandardClient.java:654) ~[mariadb-java-client-3.1.4.jar:na]
	at org.mariadb.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:95) ~[mariadb-java-client-3.1.4.jar:na]
	at org.mariadb.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:288) ~[mariadb-java-client-3.1.4.jar:na]
	at com.zaxxer.hikari.pool.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:52) ~[HikariCP-4.0.3.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyPreparedStatement.executeQuery(HikariProxyPreparedStatement.java) ~[HikariCP-4.0.3.jar:na]
	at org.springframework.jdbc.core.JdbcTemplate$1.doInPreparedStatement(JdbcTemplate.java:724) ~[spring-jdbc-5.3.31.jar:5.3.31]
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:650) ~[spring-jdbc-5.3.31.jar:5.3.31]
	... 56 common frames omitted

[2m2024-02-15 22:58:53.633[0;39m [33m WARN[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.m.jdbc.message.server.ErrorPacket     [0;39m [2m:[0;39m Error: 1227-42000: Access denied; you need (at least one of) the SHUTDOWN privilege(s) for this operation
[2m2024-02-15 22:58:53.634[0;39m [33m WARN[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.f.support.DisposableBeanAdapter   [0;39m [2m:[0;39m Invocation of destroy method failed on bean with name 'inMemoryDatabaseShutdownExecutor': java.sql.SQLSyntaxErrorException: (conn=3) Access denied; you need (at least one of) the SHUTDOWN privilege(s) for this operation
[2m2024-02-15 22:58:53.634[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mcom.zaxxer.hikari.HikariDataSource      [0;39m [2m:[0;39m HikariCP TEST POOL - Shutdown initiated...
[2m2024-02-15 22:58:53.636[0;39m [32m INFO[0;39m [35m452[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mcom.zaxxer.hikari.HikariDataSource      [0;39m [2m:[0;39m HikariCP TEST POOL - Shutdown completed.
