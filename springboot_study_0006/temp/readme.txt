
SpringBoot v3 에서는 SpringBatch v4 가 호환되지 않는 것 같다.

SpringBatch v5 로 해야 하는데, 책에는 v4 이전 버전으로 되어 있어, 안된다.

SpringBatch v2 로 강제로 내려야 한다. 

	
	변경전	
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.2.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	
	
	변경후
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.7.18</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	
	
	
	
적용하면 아래처럼 2.7.18 로 동작하게 된다.

21:42:08.895 [Thread-0] DEBUG org.springframework.boot.devtools.restart.classloader.RestartClassLoader - Created RestartClassLoader org.springframework.boot.devtools.restart.classloader.RestartClassLoader@6ce66ae6

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m             [2m (v2.7.18)[0;39m

[2m2024-02-15 21:42:09.147[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0006Application  [0;39m [2m:[0;39m Starting SpringbootStudy0006Application using Java 17 on DEFAULT3 with PID 16832 (C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0006\target\classes started by colaman in C:\WORKS\WORKS_STS4_GITHUB\WORKS_STS4_GITHUB_SPRINGBOOT_STUDY\springboot_study_0006)
[2m2024-02-15 21:42:09.148[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0006Application  [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2024-02-15 21:42:09.182[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36m.e.DevToolsPropertyDefaultsPostProcessor[0;39m [2m:[0;39m Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
[2m2024-02-15 21:42:09.635[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mcom.zaxxer.hikari.HikariDataSource      [0;39m [2m:[0;39m HikariPool-1 - Starting...
[2m2024-02-15 21:42:09.767[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mcom.zaxxer.hikari.HikariDataSource      [0;39m [2m:[0;39m HikariPool-1 - Start completed.
[2m2024-02-15 21:42:09.867[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.r.s.JobRepositoryFactoryBean    [0;39m [2m:[0;39m No database type set, using meta data indicating: H2
[2m2024-02-15 21:42:09.972[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m No TaskExecutor has been set, defaulting to synchronous executor.
[2m2024-02-15 21:42:10.033[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.d.a.OptionalLiveReloadServer      [0;39m [2m:[0;39m LiveReload server is running on port 35729
[2m2024-02-15 21:42:10.047[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0006Application  [0;39m [2m:[0;39m Started SpringbootStudy0006Application in 1.142 seconds (JVM running for 1.638)
[2m2024-02-15 21:42:10.048[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.a.b.JobLauncherApplicationRunner  [0;39m [2m:[0;39m Running default command line with: []
[2m2024-02-15 21:42:10.082[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
[2m2024-02-15 21:42:10.107[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [step1]
Hello, World!
[2m2024-02-15 21:42:10.115[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [step1] executed in 8ms
[2m2024-02-15 21:42:10.117[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 21ms
[2m2024-02-15 21:42:10.325[0;39m [33m WARN[0;39m [35m16832[0;39m [2m---[0;39m [2m[ionShutdownHook][0;39m [36mo.s.b.f.support.DisposableBeanAdapter   [0;39m [2m:[0;39m Invocation of destroy method failed on bean with name 'inMemoryDatabaseShutdownExecutor': org.h2.jdbc.JdbcSQLNonTransientConnectionException: Database is already closed (to disable automatic closing at VM shutdown, add ";DB_CLOSE_ON_EXIT=FALSE" to the db URL) [90121-214]
[2m2024-02-15 21:42:10.326[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[ionShutdownHook][0;39m [36mcom.zaxxer.hikari.HikariDataSource      [0;39m [2m:[0;39m HikariPool-1 - Shutdown initiated...
[2m2024-02-15 21:42:10.328[0;39m [32m INFO[0;39m [35m16832[0;39m [2m---[0;39m [2m[ionShutdownHook][0;39m [36mcom.zaxxer.hikari.HikariDataSource      [0;39m [2m:[0;39m HikariPool-1 - Shutdown completed.
	
	
	
2024.02.15 기준으로 2.7.18 이 최신이다.

https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter







https://docs.spring.io/spring-batch/reference/domain.html

주요 키워드
JobRepository, JobLauncher, Job, Step, ItemReader, ItemProcesor, ItemWriter 

Job, JobInstance, JobExecution



스프링배치 완벽가이드 2장 까지 확인함 (p 70)


 






