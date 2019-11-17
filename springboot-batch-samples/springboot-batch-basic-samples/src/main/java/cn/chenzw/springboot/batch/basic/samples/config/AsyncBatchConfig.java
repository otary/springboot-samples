package cn.chenzw.springboot.batch.basic.samples.config;

import cn.chenzw.springboot.batch.basic.samples.step.async.MyItemProcessor;
import cn.chenzw.springboot.batch.basic.samples.step.async.MyItemReader;
import cn.chenzw.springboot.batch.basic.samples.step.async.MyItemWriter;
import cn.chenzw.springboot.batch.basic.samples.step.async.listener.MyItemProcessListener;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.integration.async.AsyncItemWriter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * 异步处理
 *
 * @author chenzw
 */
@Configuration
public class AsyncBatchConfig {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job asyncJob() {
        return jobBuilderFactory.get("asyncJob").flow(asyncStep()).end().build();
    }


    @Bean
    public Step asyncStep() {
        return stepBuilderFactory.get("asyncStep")
                .chunk(10)
                .listener(myAsyncItemProcessListener())
                .reader(myItemReader())
                .processor(asyncItemProcessor())
                .writer(asyncItemWriter())
                .build();
    }

    @Bean
    public ItemReader myItemReader() {
        return new MyItemReader();
    }

    @Bean
    public ItemProcessor myItemProcessor() {
        return new MyItemProcessor();
    }

    @Bean
    public ItemWriter myItemWriter() {
        return new MyItemWriter();
    }

    @Bean
    public AsyncItemProcessor asyncItemProcessor() {
        AsyncItemProcessor asyncItemProcessor = new AsyncItemProcessor();
        asyncItemProcessor.setTaskExecutor(new SimpleAsyncTaskExecutor());
        asyncItemProcessor.setDelegate(myItemProcessor());
        return asyncItemProcessor;
    }

    @Bean
    public AsyncItemWriter asyncItemWriter() {
        AsyncItemWriter asyncItemWriter = new AsyncItemWriter();
        asyncItemWriter.setDelegate(myItemWriter());
        return asyncItemWriter;
    }

    @Bean
    public ItemProcessListener myAsyncItemProcessListener() {
        return new MyItemProcessListener();
    }
}
