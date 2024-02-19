package com.colamanlabs.springbootstudy.s0009;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobLoggerListener2
{
    
    @BeforeJob
    public void beforeJob(JobExecution jobExecution)
    {
        // TODO Auto-generated method stub
        String jobName = jobExecution.getJobInstance().getJobName();
        String strLog = String.format("[%s] is beginning execution", jobName);
        log.info(String.format("[JobLoggerListener2/beforeJob] %s", strLog));
    }
    
    @AfterJob
    public void afterJob(JobExecution jobExecution)
    {
        // TODO Auto-generated method stub
        String jobName = jobExecution.getJobInstance().getJobName();
        BatchStatus jobStatus = jobExecution.getStatus();
        String strLog = String.format("[%s] is completed with the status [%s]", jobName, jobStatus);
        log.info(String.format("[JobLoggerListener2/afterJob] %s", strLog));
    }
    
}
