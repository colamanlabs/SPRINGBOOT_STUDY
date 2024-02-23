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
package com.colamanlabs.springbootstudy.s0017;

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
public class ConditionalJob1 {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Tasklet passTasklet()
    {

        MyPassTasklet myPassTasklet = new MyPassTasklet();
        return myPassTasklet;
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
         *  [핵심키워드]
         *  flow 
         *  

            1. JobBuilderFactory.get(String name) 
            - name 잡 이름 
            - name 의 JobBuilder 를 만든다.
            
            2. JobBuilder.start(Step step)
            - step 이나 step 시퀀스 를 실행하는 잡을 만든다.
            - 리턴타입이 SimpleJobBuilder 이다.
            
            3. SimpleJobBuilder.on(String pattern)
            - 지정한 패턴의 Step 에 대해, 분기처리로 변경한다.
            - 리턴타입이 FlowBuilder.TransitionBuilder<FlowJobBuilder> 이다.
            
            4. Class FlowBuilder.TransitionBuilder<Q>.stopAndRestart(Step restart)
            - flow 를 중단하고, restart 할 FlowBuilder<Q> 를 리턴한다. public FlowBuilder<Q> stopAndRestart(Step restart)
            - .on("FAILED").stopAndRestart(successStep()) 
                - FAILED 상태이면 FlowBuilder<Q> 구현체로 응답
                - https://docs.spring.io/spring-batch/docs/current/api/org/springframework/batch/core/job/builder/FlowBuilder.html
                
            5. FlowBuilder<Q> 를 리턴받았으므로 
            - start(Step step) 로 flow 를 시작할 것인지 
            - from(Step step) 로 이전에 등록된 step 으로 돌아가서, 새로 시작할 것인지 
            - next(Step step) 로 다음 step 으로 진행 할 것인지
            결정해야 한다.
            
            6. 앞에서 이미 stopAndRestart 하기위한 on 조건은 모두 필터링 되었으므로,
            on("*") 은 모든 조건이 되고,
            FlowBuilder<Q> to(Step step) 를 통해 다음 step 을 지정한다.
            
            7. end() 
            build() 의 synonym 이지만, 서브 클래스에서 오버라이딩 할 수 있다.

         * 
         */
        return this.jobBuilderFactory.get("conditionalJob1")
                .start(firstStep())
                .on("FAILED").stopAndRestart(successStep())
                .from(firstStep()).on("*").to(successStep()).end().build();
        
        
    }
    
    @Bean
    public Step firstStep()
    {
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
////
////	@Bean
////	public JobExecutionDecider decider() {
////		return new RandomDecider();
////	}
////
////	public static void main(String[] args) {
////		SpringApplication.run(ConditionalJob.class, args);
////	}
}
