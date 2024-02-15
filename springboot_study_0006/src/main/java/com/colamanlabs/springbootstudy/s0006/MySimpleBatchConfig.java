package com.colamanlabs.springbootstudy.s0006;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MySimpleBatchConfig
{
    /*
     * 1. Step 을 만들고
     * 
     * 2. Job 을 만든다.
     * 
     * Step 은 StepBuilder 로 생성하고, StepBuilder 는 StepBuilderFactory 로 얻는다. StepBuilderFactory 는 @Autowired 로 주입한다.
     * 
     * Job 은 JobBuilder 로 생성하고, JobBuilder 는 JobBuilderFactory 로 얻는다. JobBuilderFactory 는 @Autowired 로 주입한다.
     * 
     * 
     * Step 은 Tasklet 형태와 청크 처리 형태로 구분 할 수 있다.
     * 
     * Job 과 Step 은 @Bean 으로 선언해야 한다.
     */
    
    @Autowired
    private final StepBuilderFactory stepBuilderFactory = null;
    
    @Autowired
    private final JobBuilderFactory jobBuilderFactory = null;
    
    public static final String STEP_TASKLET_0001 = "STEP_TASKLET_0001";
    
    @Bean
    public Step createStep0001()
    {
        MySimpleTasklet0001 tasklet0001 = new MySimpleTasklet0001();
        StepBuilder stepBuilder = stepBuilderFactory.get(STEP_TASKLET_0001);
        Step step = stepBuilder.tasklet(tasklet0001).build();
        return step;
    }
    
    public static final String STEP_TASKLET_0002 = "STEP_TASKLET_0002";
    
    @Bean
    public Step createStep0002()
    {
        MySimpleTasklet0002 tasklet0002 = new MySimpleTasklet0002();
        StepBuilder stepBuilder = stepBuilderFactory.get(STEP_TASKLET_0002);
        Step step = stepBuilder.tasklet(tasklet0002).build();
        return step;
    }
    
    public static final String STEP_TASKLET_0003 = "STEP_TASKLET_0003";
    
    @Bean
    public Step createStep0003()
    {
        MySimpleTasklet0003 tasklet0003 = new MySimpleTasklet0003();
        StepBuilder stepBuilder = stepBuilderFactory.get(STEP_TASKLET_0003);
        Step step = stepBuilder.tasklet(tasklet0003).build();
        return step;
    }
    
//    public static final String JOB_0001 = "JOB_0001";
//    
//    @Bean
//    public Job createJob0001()
//    {
//        Step step0001 = createStep0001();
//        JobBuilder jobBuilder = jobBuilderFactory.get(JOB_0001);
//        Job job = jobBuilder.start(step0001).build();
//        return job;
//    }
    
    public static final String JOB_0002 = "JOB_0002";
    
    @Bean
    public Job createJob0002()
    {
        Step step0001 = createStep0001();
        Step step0002 = createStep0002();
        Step step0003 = createStep0003();
        JobBuilder jobBuilder = jobBuilderFactory.get(JOB_0002);
        Job job = jobBuilder.start(step0001).next(step0002).next(step0003).build();
        return job;
    }
    
    
    public static final String JOB_0001 = "JOB_0001";
    
    @Bean
    public Job createJob0001()
    {
        Step step0001 = createStep0001();
        JobBuilder jobBuilder = jobBuilderFactory.get(JOB_0001);
        Job job = jobBuilder.start(step0001).build();
        return job;
    }
    
    
    
/*
 선언된 Job 은 순서대로 실행된다.
 createJob0001() 이 소스상 위에 있어 먼저 실행되고,  
 createJob0002() 이 소스상 아래에 있어 나중에 실행된다.
  
[2m2024-02-15 22:14:56.328[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.a.b.JobLauncherApplicationRunner  [0;39m [2m:[0;39m Running default command line with: []
[2m2024-02-15 22:14:56.362[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0001]] launched with the following parameters: [{}]
[2m2024-02-15 22:14:56.385[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [STEP_TASKLET_0001]
[2m2024-02-15 22:14:56.392[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] BEGIN
[2m2024-02-15 22:14:56.392[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[2m2024-02-15 22:14:56.392[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [], stepExecutionContext={batch.taskletType=com.colamanlabs.springbootstudy.s0006.MySimpleTasklet0001, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={}]
[2m2024-02-15 22:14:56.396[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] new java.util.Date():[Thu Feb 15 22:14:56 KST 2024]
[2m2024-02-15 22:14:56.396[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] END
[2m2024-02-15 22:14:56.399[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [STEP_TASKLET_0001] executed in 12ms
[2m2024-02-15 22:14:56.401[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0001]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 25ms
[2m2024-02-15 22:14:56.403[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0002]] launched with the following parameters: [{}]
[2m2024-02-15 22:14:56.406[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [STEP_TASKLET_0001]
[2m2024-02-15 22:14:56.407[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] BEGIN
[2m2024-02-15 22:14:56.407[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[2m2024-02-15 22:14:56.407[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [], stepExecutionContext={batch.taskletType=com.colamanlabs.springbootstudy.s0006.MySimpleTasklet0001, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={}]
[2m2024-02-15 22:14:56.407[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] new java.util.Date():[Thu Feb 15 22:14:56 KST 2024]
[2m2024-02-15 22:14:56.407[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] END
[2m2024-02-15 22:14:56.408[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [STEP_TASKLET_0001] executed in 2ms
[2m2024-02-15 22:14:56.410[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [STEP_TASKLET_0002]
[2m2024-02-15 22:14:56.411[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0002         [0;39m [2m:[0;39m [MySimpleTasklet0002/execute] BEGIN
[2m2024-02-15 22:14:56.411[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0002         [0;39m [2m:[0;39m [MySimpleTasklet0002/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[2m2024-02-15 22:14:56.411[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0002         [0;39m [2m:[0;39m [MySimpleTasklet0002/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [], stepExecutionContext={batch.taskletType=com.colamanlabs.springbootstudy.s0006.MySimpleTasklet0002, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={}]
[2m2024-02-15 22:14:56.411[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0002         [0;39m [2m:[0;39m [MySimpleTasklet0002/execute] new java.util.Date():[Thu Feb 15 22:14:56 KST 2024]
[2m2024-02-15 22:14:56.411[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0002         [0;39m [2m:[0;39m [MySimpleTasklet0002/execute] END
[2m2024-02-15 22:14:56.413[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [STEP_TASKLET_0002] executed in 3ms
[2m2024-02-15 22:14:56.415[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [STEP_TASKLET_0003]
[2m2024-02-15 22:14:56.416[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0003         [0;39m [2m:[0;39m [MySimpleTasklet0003/execute] BEGIN
[2m2024-02-15 22:14:56.416[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0003         [0;39m [2m:[0;39m [MySimpleTasklet0003/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[2m2024-02-15 22:14:56.416[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0003         [0;39m [2m:[0;39m [MySimpleTasklet0003/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [], stepExecutionContext={batch.taskletType=com.colamanlabs.springbootstudy.s0006.MySimpleTasklet0003, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={}]
[2m2024-02-15 22:14:56.416[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0003         [0;39m [2m:[0;39m [MySimpleTasklet0003/execute] new java.util.Date():[Thu Feb 15 22:14:56 KST 2024]
[2m2024-02-15 22:14:56.416[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0003         [0;39m [2m:[0;39m [MySimpleTasklet0003/execute] END
[2m2024-02-15 22:14:56.417[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [STEP_TASKLET_0003] executed in 1ms
[2m2024-02-15 22:14:56.418[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0002]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 15ms
[2m2024-02-15 22:14:56.421[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0006Application  [0;39m [2m:[0;39m [SpringbootStudy0006Application/init] BEGIN
[2m2024-02-15 22:14:56.421[0;39m [32m INFO[0;39m [35m19572[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0006Application  [0;39m [2m:[0;39m [SpringbootStudy0006Application/init] END

     
     
 만약 소스상 순서를 뒤집으면
 createJob0002() 이 소스상 위에 있어 먼저 실행되고,  
 createJob0001() 이 소스상 아래에 있어 나중에 실행된다. 
 
 
 [2m2024-02-15 22:17:50.398[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.a.b.JobLauncherApplicationRunner  [0;39m [2m:[0;39m Running default command line with: []
[2m2024-02-15 22:17:50.432[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0002]] launched with the following parameters: [{}]
[2m2024-02-15 22:17:50.456[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [STEP_TASKLET_0001]
[2m2024-02-15 22:17:50.462[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] BEGIN
[2m2024-02-15 22:17:50.462[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[2m2024-02-15 22:17:50.462[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [], stepExecutionContext={batch.taskletType=com.colamanlabs.springbootstudy.s0006.MySimpleTasklet0001, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={}]
[2m2024-02-15 22:17:50.466[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] new java.util.Date():[Thu Feb 15 22:17:50 KST 2024]
[2m2024-02-15 22:17:50.466[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] END
[2m2024-02-15 22:17:50.469[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [STEP_TASKLET_0001] executed in 13ms
[2m2024-02-15 22:17:50.471[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [STEP_TASKLET_0002]
[2m2024-02-15 22:17:50.472[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0002         [0;39m [2m:[0;39m [MySimpleTasklet0002/execute] BEGIN
[2m2024-02-15 22:17:50.472[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0002         [0;39m [2m:[0;39m [MySimpleTasklet0002/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[2m2024-02-15 22:17:50.472[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0002         [0;39m [2m:[0;39m [MySimpleTasklet0002/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [], stepExecutionContext={batch.taskletType=com.colamanlabs.springbootstudy.s0006.MySimpleTasklet0002, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={}]
[2m2024-02-15 22:17:50.472[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0002         [0;39m [2m:[0;39m [MySimpleTasklet0002/execute] new java.util.Date():[Thu Feb 15 22:17:50 KST 2024]
[2m2024-02-15 22:17:50.472[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0002         [0;39m [2m:[0;39m [MySimpleTasklet0002/execute] END
[2m2024-02-15 22:17:50.473[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [STEP_TASKLET_0002] executed in 2ms
[2m2024-02-15 22:17:50.475[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [STEP_TASKLET_0003]
[2m2024-02-15 22:17:50.476[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0003         [0;39m [2m:[0;39m [MySimpleTasklet0003/execute] BEGIN
[2m2024-02-15 22:17:50.476[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0003         [0;39m [2m:[0;39m [MySimpleTasklet0003/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[2m2024-02-15 22:17:50.476[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0003         [0;39m [2m:[0;39m [MySimpleTasklet0003/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [], stepExecutionContext={batch.taskletType=com.colamanlabs.springbootstudy.s0006.MySimpleTasklet0003, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={}]
[2m2024-02-15 22:17:50.476[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0003         [0;39m [2m:[0;39m [MySimpleTasklet0003/execute] new java.util.Date():[Thu Feb 15 22:17:50 KST 2024]
[2m2024-02-15 22:17:50.476[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0003         [0;39m [2m:[0;39m [MySimpleTasklet0003/execute] END
[2m2024-02-15 22:17:50.478[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [STEP_TASKLET_0003] executed in 3ms
[2m2024-02-15 22:17:50.481[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0002]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 35ms
[2m2024-02-15 22:17:50.483[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0001]] launched with the following parameters: [{}]
[2m2024-02-15 22:17:50.486[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.job.SimpleStepHandler    [0;39m [2m:[0;39m Executing step: [STEP_TASKLET_0001]
[2m2024-02-15 22:17:50.487[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] BEGIN
[2m2024-02-15 22:17:50.487[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[2m2024-02-15 22:17:50.487[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [], stepExecutionContext={batch.taskletType=com.colamanlabs.springbootstudy.s0006.MySimpleTasklet0001, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={}]
[2m2024-02-15 22:17:50.487[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] new java.util.Date():[Thu Feb 15 22:17:50 KST 2024]
[2m2024-02-15 22:17:50.487[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s0006.MySimpleTasklet0001         [0;39m [2m:[0;39m [MySimpleTasklet0001/execute] END
[2m2024-02-15 22:17:50.488[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.batch.core.step.AbstractStep        [0;39m [2m:[0;39m Step: [STEP_TASKLET_0001] executed in 2ms
[2m2024-02-15 22:17:50.489[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.b.c.l.support.SimpleJobLauncher     [0;39m [2m:[0;39m Job: [SimpleJob: [name=JOB_0001]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 6ms
[2m2024-02-15 22:17:50.492[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0006Application  [0;39m [2m:[0;39m [SpringbootStudy0006Application/init] BEGIN
[2m2024-02-15 22:17:50.492[0;39m [32m INFO[0;39m [35m18032[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mc.c.s.s.SpringbootStudy0006Application  [0;39m [2m:[0;39m [SpringbootStudy0006Application/init] END

  
  @Bean 으로 등록된 모든 Job 이 실행됨을 알 수 있다. 
  
 */
    
}
