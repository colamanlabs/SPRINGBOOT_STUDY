

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





/*
[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0007Application  [0;39m [2m:[0;39m Started SpringbootStudy0007Application in 1.156 seconds (JVM running for 1.659)

잡의 실행은 잡 러너에서 시작된다.
잡 러너는 잡 이름과, 파라미터를 받아들여 잡을 실행시키는 역할을 한다.

JobLauncherApplicationRunner 가 실행되고,  
SimpleJobLauncher 가 실행된다.

-- JobLauncherApplicationRunner
[  restartedMain][0;39m [36mo.s.b.a.b.JobLauncherApplicationRunner  [0;39m [2m:[0;39m Running default command line with: []


-- SimpleJobLauncher
[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0001]] launched with the following parameters: [{}]


[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [STEP_TASKLET_0001]
[  restartedMain][0;39m [36mc.c.s.s0007.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] BEGIN
[  restartedMain][0;39m [36mc.c.s.s0007.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[  restartedMain][0;39m [36mc.c.s.s0007.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [], stepExecutionContext={batch.taskletType=com.colamanlabs.springbootstudy.s0007.MySimpleTasklet0001, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={}]
[  restartedMain][0;39m [36mc.c.s.s0007.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] new java.util.Date():[Thu Feb 15 22:49:18 KST 2024]
[  restartedMain][0;39m [36mc.c.s.s0007.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] END
[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [STEP_TASKLET_0001] executed in 12ms
[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0001]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 24ms

-- @EventListener(ApplicationReadyEvent.class) 콜백
-- 잡이 다 끝나야 콜백된다.
[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0007Application  [0;39m [2m:[0;39m [SpringbootStudy0007Application/init] BEGIN
[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0007Application  [0;39m [2m:[0;39m [SpringbootStudy0007Application/init] END
[ionShutdownHook][0;39m [36mo.s.b.f.support.DisposableBeanAdapter   [0;39m [2m:[0;39m Invocation of destroy method failed on bean with name 'inMemoryDatabaseShutdownExecutor': org.h2.jdbc.JdbcSQLNonTransientConnectionException: Database is already closed (to disable automatic closing at VM shutdown, add ";DB_CLOSE_ON_EXIT=FALSE" to the db URL) [90121-214]
[ionShutdownHook][0;39m [36mcom.zaxxer.hikari.HikariDataSource      [0;39m [2m:[0;39m HikariPool-1 - Shutdown initiated...
[ionShutdownHook][0;39m [36mcom.zaxxer.hikari.HikariDataSource      [0;39m [2m:[0;39m HikariPool-1 - Shutdown completed.

 */
 
 
 
 
 
page 99 잡 파라미터 테스트
 
  
 C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0007\target>java -jar ./springboot_study_0007-0.0.1-SNAPSHOT.jar foo=bar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v2.7.18)

...
2024-02-15 23:34:37.417  INFO 9004 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: [foo=bar]
2024-02-15 23:34:37.483  INFO 9004 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=JOB_0001]] launched with the following parameters: [{foo=bar}]
...

C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0007\target>




C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0007\target>java -jar ./springboot_study_0007-0.0.1-SNAPSHOT.jar foo=bar name=basicJob requestDate=20240215 retryCount=1

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v2.7.18)

...
2024-02-15 23:35:37.201  INFO 12232 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: [foo=bar, name=basicJob, requestDate=20240215, retryCount=1]
2024-02-15 23:35:37.313  INFO 12232 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=JOB_0001]] launched with the following parameters: [{retryCount=1, foo=bar, name=basicJob, requestDate=20240215}]
...

C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0007\target>
 
 
 
page 100) 동일 파라미터로 2번이상 잡 실행


실행에 실패한다.

ex)
... 
Caused by: org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException: A job instance already exists and is complete for parameters={retryCount=1, foo=bar, name=basicJob, requestDate=20240215}.  If you want to run this job again, change the parameters.
...



:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0007\target>java -jar ./springboot_study_0007-0.0.1-SNAPSHOT.jar foo=bar name=basicJob requestDate=20240215 retryCount=1

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v2.7.18)

2024-02-15 23:37:10.154  INFO 2140 --- [           main] c.c.s.s.SpringbootStudy0007Application   : Starting SpringbootStudy0007Application v0.0.1-SNAPSHOT using Java 17 on DEFAULT3 with PID 2140 (C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0007\target\springboot_study_0007-0.0.1-SNAPSHOT.jar started by colaman in C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0007\target)
2024-02-15 23:37:10.157  INFO 2140 --- [           main] c.c.s.s.SpringbootStudy0007Application   : No active profile set, falling back to 1 default profile: "default"
2024-02-15 23:37:11.024  INFO 2140 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariCP TEST POOL - Starting...
2024-02-15 23:37:11.119  INFO 2140 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariCP TEST POOL - Start completed.
2024-02-15 23:37:11.138  WARN 2140 --- [           main] o.m.jdbc.message.server.ErrorPacket      : Error: 1050-42S01: Table 'batch_job_instance' already exists
2024-02-15 23:37:11.139  WARN 2140 --- [           main] o.m.jdbc.message.server.ErrorPacket      : Error: 1050-42S01: Table 'batch_job_execution' already exists
2024-02-15 23:37:11.140  WARN 2140 --- [           main] o.m.jdbc.message.server.ErrorPacket      : Error: 1050-42S01: Table 'batch_job_execution_params' already exists
2024-02-15 23:37:11.140  WARN 2140 --- [           main] o.m.jdbc.message.server.ErrorPacket      : Error: 1050-42S01: Table 'batch_step_execution' already exists
2024-02-15 23:37:11.140  WARN 2140 --- [           main] o.m.jdbc.message.server.ErrorPacket      : Error: 1050-42S01: Table 'batch_step_execution_context' already exists
2024-02-15 23:37:11.141  WARN 2140 --- [           main] o.m.jdbc.message.server.ErrorPacket      : Error: 1050-42S01: Table 'batch_job_execution_context' already exists
2024-02-15 23:37:11.141  WARN 2140 --- [           main] o.m.jdbc.message.server.ErrorPacket      : Error: 1050-42S01: Table 'batch_step_execution_seq' already exists
2024-02-15 23:37:11.141  WARN 2140 --- [           main] o.m.jdbc.message.server.ErrorPacket      : Error: 1050-42S01: Table 'batch_job_execution_seq' already exists
2024-02-15 23:37:11.142  WARN 2140 --- [           main] o.m.jdbc.message.server.ErrorPacket      : Error: 1050-42S01: Table 'batch_job_seq' already exists
2024-02-15 23:37:11.205  INFO 2140 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: MYSQL
2024-02-15 23:37:11.402  INFO 2140 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2024-02-15 23:37:11.501  INFO 2140 --- [           main] c.c.s.s.SpringbootStudy0007Application   : Started SpringbootStudy0007Application in 2.003 seconds (JVM running for 2.432)
2024-02-15 23:37:11.504  INFO 2140 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: [foo=bar, name=basicJob, requestDate=20240215, retryCount=1]
2024-02-15 23:37:11.634  INFO 2140 --- [           main] ConditionEvaluationReportLoggingListener :

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2024-02-15 23:37:11.654 ERROR 2140 --- [           main] o.s.boot.SpringApplication               : Application run failed

java.lang.IllegalStateException: Failed to execute ApplicationRunner
        at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:759) ~[spring-boot-2.7.18.jar!/:2.7.18]
        at org.springframework.boot.SpringApplication.lambda$callRunners$2(SpringApplication.java:746) ~[spring-boot-2.7.18.jar!/:2.7.18]
        at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183) ~[na:na]
        at java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357) ~[na:na]
        at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510) ~[na:na]
        at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) ~[na:na]
        at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150) ~[na:na]
        at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173) ~[na:na]
        at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) ~[na:na]
        at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596) ~[na:na]
        at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:744) ~[spring-boot-2.7.18.jar!/:2.7.18]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[spring-boot-2.7.18.jar!/:2.7.18]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1300) ~[spring-boot-2.7.18.jar!/:2.7.18]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1289) ~[spring-boot-2.7.18.jar!/:2.7.18]
        at com.colamanlabs.springbootstudy.s0007.SpringbootStudy0007Application.main(SpringbootStudy0007Application.java:25) ~[classes!/:0.0.1-SNAPSHOT]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49) ~[springboot_study_0007-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108) ~[springboot_study_0007-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58) ~[springboot_study_0007-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65) ~[springboot_study_0007-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
Caused by: org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException: A job instance already exists and is complete for parameters={retryCount=1, foo=bar, name=basicJob, requestDate=20240215}.  If you want to run this job again, change the parameters.
        at org.springframework.batch.core.repository.support.SimpleJobRepository.createJobExecution(SimpleJobRepository.java:139) ~[spring-batch-core-4.3.10.jar!/:4.3.10]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
        at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123) ~[spring-tx-5.3.31.jar!/:5.3.31]
        at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:388) ~[spring-tx-5.3.31.jar!/:5.3.31]
        at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119) ~[spring-tx-5.3.31.jar!/:5.3.31]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at org.springframework.batch.core.repository.support.AbstractJobRepositoryFactoryBean$1.invoke(AbstractJobRepositoryFactoryBean.java:181) ~[spring-batch-core-4.3.10.jar!/:4.3.10]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:241) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at jdk.proxy2/jdk.proxy2.$Proxy45.createJobExecution(Unknown Source) ~[na:na]
        at org.springframework.batch.core.launch.support.SimpleJobLauncher.run(SimpleJobLauncher.java:137) ~[spring-batch-core-4.3.10.jar!/:4.3.10]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
        at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$PassthruAdvice.invoke(SimpleBatchConfiguration.java:128) ~[spring-batch-core-4.3.10.jar!/:4.3.10]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:241) ~[spring-aop-5.3.31.jar!/:5.3.31]
        at jdk.proxy2/jdk.proxy2.$Proxy51.run(Unknown Source) ~[na:na]
        at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.execute(JobLauncherApplicationRunner.java:213) ~[spring-boot-autoconfigure-2.7.18.jar!/:2.7.18]
        at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.executeLocalJobs(JobLauncherApplicationRunner.java:193) ~[spring-boot-autoconfigure-2.7.18.jar!/:2.7.18]
        at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.launchJobFromProperties(JobLauncherApplicationRunner.java:172) ~[spring-boot-autoconfigure-2.7.18.jar!/:2.7.18]
        at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.run(JobLauncherApplicationRunner.java:167) ~[spring-boot-autoconfigure-2.7.18.jar!/:2.7.18]
        at org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner.run(JobLauncherApplicationRunner.java:162) ~[spring-boot-autoconfigure-2.7.18.jar!/:2.7.18]
        at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:756) ~[spring-boot-2.7.18.jar!/:2.7.18]
        ... 22 common frames omitted

2024-02-15 23:37:11.657  INFO 2140 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariCP TEST POOL - Shutdown initiated...
2024-02-15 23:37:11.660  INFO 2140 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariCP TEST POOL - Shutdown completed.

C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0007\target>
 
 
 
 
 
 
잡 러너의 기능중 하나가 바로 잡 실행에 필요한 JobParameters 객체를 생성해 JobInstance 에 전달하는 것이다.

JobLauncherCommandLineRunner 에 파라미터를 전달하는 것은 명령행으로 key=value 쌍을 전달했던 것처럼 간단하다.

JobParameters 인스턴스는 잡이 전달받는 모든 파라미터의 컨테이너 역할을 한다.

JobParameters 는 Map<String, JobParameter> 의 wrapper 에 불과하다.



batch_job_execution_params 테이블에서 파라미터 정보 확인을 할 수 있다.

"JOB_EXECUTION_ID"	"TYPE_CD"	"KEY_NAME"	"STRING_VAL"	"DATE_VAL"	"LONG_VAL"	"DOUBLE_VAL"	"IDENTIFYING"
"4"	"STRING"	"foo"	"bar"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"5"	"STRING"	"foo"	"bar"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"5"	"STRING"	"name"	"basicJob"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"6"	"STRING"	"foo"	"bar"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"6"	"STRING"	"name"	"basicJob"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"6"	"STRING"	"requestDate"	"20240215"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"7"	"STRING"	"retryCount"	"1"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"7"	"STRING"	"foo"	"bar"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"7"	"STRING"	"name"	"basicJob"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"7"	"STRING"	"requestDate"	"20240215"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"


cf)
DATE_VAL 이 현재시간이 아닌 1970-01-01 으로 고정된 이유는 모르겠다. 나중에 찾자.
batch_job_execution 의 시간은 현재시간으로 정상이다.





ItemReader, ItemProcessor, ItemWriter, Tasklet 인터페이스에서는 JobParameter 인스턴스를 파라미터로 받지 않는다.


 









 