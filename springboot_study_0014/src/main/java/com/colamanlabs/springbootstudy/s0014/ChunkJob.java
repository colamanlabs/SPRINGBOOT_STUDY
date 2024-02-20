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
package com.colamanlabs.springbootstudy.s0014;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Michael Minella
 */

/*
 * page 152 예제를 수정함
 */
@EnableBatchProcessing
@SpringBootApplication
public class ChunkJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job chunkBasedJob() {
		return this.jobBuilderFactory.get("chunkBasedJob")
				.start(chunkStep())
				.build();
	}

	@Bean
	public Step chunkStep() {
		return this.stepBuilderFactory.get("chunkStep")
				.<String, String>chunk(1000)
				.reader(itemReader())
				.writer(itemWriter())
				.build();
	}

	
	/*
	 * Class ListItemReader<T>
	 * 
	 * https://docs.spring.io/spring-batch/docs/current/api/org/springframework/batch/item/support/ListItemReader.html
	 * 
	 * An ItemReader that pulls data from a list. Useful for testing. This reader is not thread-safe.
	 * 
	 *  List 를 생성자 인자로 받는다.
        Constructor Description ListItemReader(List<T> list)
	 */
	@Bean
    public ListItemReader<String> itemReader()
    {
        List<String> items = new ArrayList<>(100000);
        
        for (int i = 0; i < 100000; i++)
        {
            items.add(UUID.randomUUID().toString());
        }
        
        return new ListItemReader<>(items);
    }

	@Bean
    public ItemWriter<String> itemWriter()
    {
        
        ItemWriter<String> writer = new ItemWriter<String>()
        {
            @Override
            public void write(List<? extends String> items) throws Exception
            {
                // TODO Auto-generated method stub
                for (int i = 0; i < items.size(); ++i)
                {
                    System.out.println(String.format("i:[%d]\titem:[%s]", i, items.get(i)));
                }
                
            }
            
        };
        
        return writer;
    }
		
}
	

