package com.colamanlabs.springbootstudy.s0015;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.CompositeJobParametersValidator;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobListenerFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MySimpleBatchConfig
{
    
    @Autowired
    private final StepBuilderFactory stepBuilderFactory = null;
    
    @Autowired
    private final JobBuilderFactory jobBuilderFactory = null;
    
    @Bean
    public Tasklet createTasklet0001()
    {
        MySimpleTasklet0001 tasklet0001 = new MySimpleTasklet0001();
        return tasklet0001;
    }
    
    public static final String STEP_TASKLET_0001 = "STEP_TASKLET_0001";
    
    @Bean
    public Step createStep0001()
    {
        Tasklet tasklet0001 = createTasklet0001();
        StepBuilder stepBuilder = stepBuilderFactory.get(STEP_TASKLET_0001);
        Step step = stepBuilder.tasklet(tasklet0001).listener(new LoggingStepStartStopListener()).build();
        return step;
    }
    
    public static final String STEP_TASKLET_0002 = "STEP_TASKLET_0002";
    
    @Bean
    public Step createStep0002()
    {
        MySimpleTasklet0002 tasklet0002 = new MySimpleTasklet0002();
        StepBuilder stepBuilder = stepBuilderFactory.get(STEP_TASKLET_0002);
        Step step = stepBuilder.tasklet(tasklet0002).listener(new LoggingStepStartStopListener()).build();
        return step;
    }
    
    public static final String STEP_TASKLET_0003 = "STEP_TASKLET_0003";
    
    @Bean
    public Step createStep0003()
    {
        MySimpleTasklet0003 tasklet0003 = new MySimpleTasklet0003();
        StepBuilder stepBuilder = stepBuilderFactory.get(STEP_TASKLET_0003);
        Step step = stepBuilder.tasklet(tasklet0003).listener(new LoggingStepStartStopListener()).build();
        return step;
    }
    

    public static final String JOB_0001 = "JOB_0001";
    
    @Bean
    public Job createJob0001()
    {
        Step step0001 = createStep0001();
        Step step0002 = createStep0002();
        Step step0003 = createStep0003();
        
        JobBuilder jobBuilder = jobBuilderFactory.get(JOB_0001);                
        Job job = jobBuilder.start(step0001).next(step0001).next(step0002).next(step0003).listener(new JobLoggerListener()).build();
        return job;
    }
    
}

