package com.colamanlabs.springbootstudy.s0013;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;

import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;

import lombok.extern.slf4j.Slf4j;

/*
 * page 144) 에러난다.
 */


@EnableBatchProcessing
@Configuration
@Slf4j
public class MySimpleBatchConfig
{
    
    @Autowired
    private final StepBuilderFactory stepBuilderFactory = null;
    
    @Autowired
    private final JobBuilderFactory jobBuilderFactory = null;
    
    
    
    /* https://velog.io/@sa1341/JobScope%EC%99%80-StepScope
     * 
     * @JobScope와 @StepScope는 스프링의 기본 Scope인 싱글톤 방식과는 대치되는 역할입니다.
        Bean의 생성 시점이 스프링 애플리케이션이 실행되는 시점이 아닌 @JobScope, @StepScope가 명시된 메서드가 실행될 때까지 지연시키는 것을 의미합니다.
        이러한 행위를 Late Binding이라고도 합니다.
    
    Spring Batch에서 이렇게 Late Binding을 하면서 얻는 이점들은 아래와 같습니다.
    JobParameter 를 특정 메서드가 실행하는 시점까지 지연시켜 할당시킬 수 있습니다.

    즉, 애플리케이션이 구동되는 시점이 아니라 비즈니스 로직이 구현되는 어디든 JobParameter를 할당함으로 유연한 설계를 가능하게 합니다.
    병렬처리에 안전합니다.
     */
    @Bean
    @StepScope
    public ItemReader<String> itemReader(@Value("#{jobParameters['inputFile']}") Resource inputFile)
    {
        /*
         * Class PassThroughLineMapper
         * Pass through LineMapper useful for passing the original String back directly rather than a mapped object.
         * 
         * https://docs.spring.io/spring-batch/docs/current/api/org/springframework/batch/item/file/mapping/PassThroughLineMapper.html
         */
        
        FlatFileItemReaderBuilder<String> readerBuilder = new FlatFileItemReaderBuilder<String>();
        readerBuilder.name("itemReader");
        readerBuilder.resource(inputFile);
        readerBuilder.lineMapper(new PassThroughLineMapper());        
        FlatFileItemReader<String> reader = readerBuilder.build();        
        return reader;
    }

    @Bean
    @StepScope
    public ItemWriter<String> itemWriter(@Value("#{jobParameters['outputFile']}") Resource outputFile)
    {
        log.info(String.format("[MySimpleBatchConfig/itemWriter] outputFile:[%s]", outputFile));
        FlatFileItemWriterBuilder<String> writerBuilder = new FlatFileItemWriterBuilder<String>();
        writerBuilder.name("itemWriter");
        writerBuilder.resource(outputFile);
        
        /*
         * Class FlatFileItemWriterBuilder<T>
         * A builder implementation for the FlatFileItemWriter
         * https://docs.spring.io/spring-batch/docs/current/api/org/springframework/batch/item/file/builder/FlatFileItemWriterBuilder.html
         * 
         * lineAggregator
            public FlatFileItemWriterBuilder<T> lineAggregator(LineAggregator<T> lineAggregator)
            Line aggregator used to build the String version of each item.
            
            
            Class PassThroughLineAggregator<T>
            A LineAggregator implementation that simply calls Object.toString() on the given object
         */
        writerBuilder.lineAggregator(new PassThroughLineAggregator<>());
        FlatFileItemWriter<String> writer = writerBuilder.build();
        return writer;
    }
    
    
    @Bean
    public Step step1()
    {
        StepBuilder stepBuilder = stepBuilderFactory.get("step1");
        
        /*
         * StepBuilder 에는 reader(), writer() 메소드가 없다.
         * 서브 클래스 SimpleStepBuilder 에서 정의하고 있다.      
         */
        /*
         * chunk 메소드를 통해 청크 기반 스텝을 사용하도록 지정한다.
         * 커밋 간격을 10으로 지정했으므로, 10개 단위로 처리후 작업이 커밋된다.
         */
        SimpleStepBuilder<String, String> simpleStepBuilder = stepBuilder.chunk(10);
        simpleStepBuilder.reader(itemReader(null));
        simpleStepBuilder.writer(itemWriter(null));        
        Step step = simpleStepBuilder.build();
        return step;
    }
    
    
    @Bean
    public Job job()
    {
        JobBuilder jobBuilder = this.jobBuilderFactory.get("job");
        Job job = jobBuilder.start(step1()).build();
        return job;
    }
    
}
