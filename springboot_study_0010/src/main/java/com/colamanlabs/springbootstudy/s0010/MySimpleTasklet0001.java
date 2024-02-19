package com.colamanlabs.springbootstudy.s0010;

import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySimpleTasklet0001 implements Tasklet
{
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
    {
        log.info(String.format("[MySimpleTasklet0001/execute] BEGIN"));
        
        String name = (String) (chunkContext.getStepContext().getJobParameters().get("name"));
        ExecutionContext jobContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
        jobContext.put("user.name", name);
        
        log.info(String.format("[MySimpleTasklet0001/execute] END"));
        return RepeatStatus.FINISHED;
    }
    
}
