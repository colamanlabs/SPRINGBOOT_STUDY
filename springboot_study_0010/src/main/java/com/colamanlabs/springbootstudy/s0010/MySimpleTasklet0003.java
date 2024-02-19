package com.colamanlabs.springbootstudy.s0010;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySimpleTasklet0003 implements Tasklet
{
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
    {
        log.info(String.format("[MySimpleTasklet0003/execute] BEGIN"));
        
        ExecutionContext jobContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
        String userName = (String) (jobContext.get("user.name"));
        
        log.info(String.format("[MySimpleTasklet0003/execute] userName:[%s]", userName));
        
        log.info(String.format("[MySimpleTasklet0003/execute] END"));
        
        return RepeatStatus.FINISHED;
    }
    
}
