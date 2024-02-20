package com.colamanlabs.springbootstudy.s0014;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    
}
