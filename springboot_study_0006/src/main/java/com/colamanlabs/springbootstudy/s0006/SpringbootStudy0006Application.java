package com.colamanlabs.springbootstudy.s0006;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

/*
 * 스프링배치로 동작하도록 @EnableBatchProcessing 어노테이션을 추가한다.
 */
@EnableBatchProcessing
@SpringBootApplication
@Slf4j
public class SpringbootStudy0006Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootStudy0006Application.class, args);
    }
    

    
/*
[2m2024-02-15 22:09:23.552[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.a.b.JobLauncherApplicationRunner  [0;39m [2m:[0;39m Running default command line with: []
[2m2024-02-15 22:09:23.587[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0001]] launched with the following parameters: [{}]
[2m2024-02-15 22:09:23.611[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [STEP_TASKLET_0001]
[2m2024-02-15 22:09:23.616[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] BEGIN
[2m2024-02-15 22:09:23.616[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[2m2024-02-15 22:09:23.616[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [], stepExecutionContext={batch.taskletType=com.colamanlabs.springbootstudy.s0006.MySimpleTasklet0001, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={}]
[2m2024-02-15 22:09:23.620[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] new java.util.Date():[Thu Feb 15 22:09:23 KST 2024]
[2m2024-02-15 22:09:23.620[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] END
[2m2024-02-15 22:09:23.623[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [STEP_TASKLET_0001] executed in 12ms
[2m2024-02-15 22:09:23.625[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0001]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 24ms
[2m2024-02-15 22:09:23.626[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0006Application  [0;39m [2m:[0;39m [SpringbootStudy0006Application/init] BEGIN
[2m2024-02-15 22:09:23.626[0;39m [32m INFO[0;39m [35m8380[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0006Application  [0;39m [2m:[0;39m [SpringbootStudy0006Application/init] END



Job 이 먼저 실행되고 나서, @EventListener(ApplicationReadyEvent.class) 이 콜백된다.



 */
    @EventListener(ApplicationReadyEvent.class)
    public void init()
    {
        log.info(String.format("[SpringbootStudy0006Application/init] BEGIN"));
        log.info(String.format("[SpringbootStudy0006Application/init] END"));
    }
}
