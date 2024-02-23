/**
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.colamanlabs.springbootstudy.s0016;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Michael Minella
 */

@Configuration
@Slf4j
public class ConditionalJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Tasklet passTasklet()
    {
//        return (contribution, chunkContext) ->
//        {
//            // return RepeatStatus.FINISHED;
//            throw new RuntimeException("Causing a failure");
//        };
        
        
        Tasklet tasklet = new Tasklet()
        {
            
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
            {
                // TODO Auto-generated method stub
                throw new RuntimeException("Causing a failure");
            }
            
        };
        return tasklet;
    }
    
    @Bean
    public Tasklet successTasklet()
    {
        return (contribution, context) ->
        {
            System.out.println("Success!");
            return RepeatStatus.FINISHED;
        };
    }
    
    @Bean
    public Tasklet failTasklet()
    {
        return (contribution, context) ->
        {
            System.out.println("Failure!");
            return RepeatStatus.FINISHED;
        };
    }
    
    @Bean
    public Job job()
    {
        /*
         * Class FlowBuilder.TransitionBuilder<Q>
         * https://javadoc.io/doc/org.springframework.batch/spring-batch-core/4.2.8.RELEASE/org/springframework/batch/core/job/builder/FlowBuilder.TransitionBuilder.html
         * 

            start
            SimpleJobBuilder org.springframework.batch.core.job.builder.JobBuilder.start(Step step)
            
            on
            TransitionBuilder<FlowJobBuilder> org.springframework.batch.core.job.builder.SimpleJobBuilder.on(String pattern)
            
            stopAndRestart
            FlowBuilder<FlowJobBuilder> org.springframework.batch.core.job.builder.FlowBuilder.TransitionBuilder.stopAndRestart(Step restart)
            
            from
            FlowBuilder<FlowJobBuilder> org.springframework.batch.core.job.builder.FlowBuilder.from(Step step)
            
            end
            FlowJobBuilder org.springframework.batch.core.job.builder.FlowBuilder.end()
            
         */
        return this.jobBuilderFactory.get("conditionalJob")
                .start(firstStep())
                .on("FAILED").stopAndRestart(successStep())
                .from(firstStep()).on("*").to(successStep()).end().build();
    }
    
    @Bean
    public Step firstStep()
    {
        /*
         *  passTasklet() 에서 Exception 을 RuntimeException 을 throw 한다.
         *  throw new RuntimeException("Causing a failure"); 
         *  
         *  passTasklet() 에서 던질때 받는 메소드가 누구인지 모르겠다.
         *  
         *  stackTrace 결과에도 passTasklet 내용은 없다. 
         *  
         *      at com.colamanlabs.springbootstudy.s0016.ConditionalJob.lambda$0(ConditionalJob.java:45) ~[classes/:na]
         *      
         *      소스파일의 라인은 나온다.  ====> 람다식인경우 정확한 메소드명이 나오지 않는다.
         *      
         *      
         *  
         */
        return this.stepBuilderFactory.get("firstStep").tasklet(passTasklet()).build();
    }
    
    @Bean
    public Step successStep()
    {
        return this.stepBuilderFactory.get("successStep").tasklet(successTasklet()).build();
    }
    
    @Bean
    public Step failureStep()
    {
        return this.stepBuilderFactory.get("failureStep").tasklet(failTasklet()).build();
    }
//
//	@Bean
//	public JobExecutionDecider decider() {
//		return new RandomDecider();
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(ConditionalJob.class, args);
//	}
}
