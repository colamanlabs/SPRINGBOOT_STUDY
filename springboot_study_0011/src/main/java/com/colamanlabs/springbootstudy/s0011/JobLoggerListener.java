package com.colamanlabs.springbootstudy.s0011;


import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobLoggerListener implements JobExecutionListener
{
    
    @Override
    public void beforeJob(JobExecution jobExecution)
    {
        // TODO Auto-generated method stub
        String jobName = jobExecution.getJobInstance().getJobName();
        String strLog = String.format("[%s] is beginning execution", jobName);
        log.info(String.format("[JobLoggerListener/beforeJob] %s", strLog));
    }
    
    @Override
    public void afterJob(JobExecution jobExecution)
    {
        // TODO Auto-generated method stub
        String jobName = jobExecution.getJobInstance().getJobName();
        BatchStatus jobStatus = jobExecution.getStatus();
        String strLog = String.format("[%s] is completed with the status [%s]", jobName, jobStatus);
        log.info(String.format("[JobLoggerListener/afterJob] %s", strLog));
    }
    
}
