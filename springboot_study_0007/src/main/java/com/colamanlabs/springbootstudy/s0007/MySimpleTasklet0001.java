package com.colamanlabs.springbootstudy.s0007;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySimpleTasklet0001 implements Tasklet
{
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
    {
        log.info(String.format("[MySimpleTasklet0001/execute] BEGIN"));
        log.info(String.format("[MySimpleTasklet0001/execute] contribution:[%s]", contribution));
        log.info(String.format("[MySimpleTasklet0001/execute] chunkContext:[%s]", chunkContext));
        // TODO Auto-generated method stub
        
        log.info(String.format("[MySimpleTasklet0001/execute] new java.util.Date():[%s]", new java.util.Date().toString()));
        
        log.info(String.format("[MySimpleTasklet0001/execute] END"));
        
        /*
         * 리턴타입이 RepeatStatus 이다.
         * 
         * https://docs.spring.io/spring-batch/docs/current/api/org/springframework/batch/repeat/RepeatStatus.html
         * 
         */
        return RepeatStatus.FINISHED;
    }
    
}
