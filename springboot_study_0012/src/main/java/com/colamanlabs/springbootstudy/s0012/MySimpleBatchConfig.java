package com.colamanlabs.springbootstudy.s0012;

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

@Configuration
@Slf4j
public class MySimpleBatchConfig {

	@Autowired
	private final StepBuilderFactory stepBuilderFactory = null;

	@Autowired
	private final JobBuilderFactory jobBuilderFactory = null;

	@Bean
	public Step step1() {
		Step step = this.stepBuilderFactory.get("step1").tasklet(new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				// TODO Auto-generated method stub
				log.info(String.format("Hello, World!", null));
				return RepeatStatus.FINISHED;
			}
		}).build();

		return step;
	}

	@Bean
	public Job job() {
		Job job = this.jobBuilderFactory.get("job").start(step1()).build();
		return job;
	}

}
