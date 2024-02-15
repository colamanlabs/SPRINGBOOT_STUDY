package com.colamanlabs.springbootstudy.s0007;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;


@EnableBatchProcessing
@SpringBootApplication
@Slf4j
public class SpringbootStudy0007Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootStudy0007Application.class, args);
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void init()
    {
        log.info(String.format("[SpringbootStudy0007Application/init] BEGIN"));
        log.info(String.format("[SpringbootStudy0007Application/init] END"));
    }
    
    
    
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
}
