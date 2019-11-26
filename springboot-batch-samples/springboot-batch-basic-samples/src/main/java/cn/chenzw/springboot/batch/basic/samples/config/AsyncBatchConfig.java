package cn.chenzw.springboot.batch.basic.samples.config;

import cn.chenzw.springboot.batch.basic.samples.listener.MyItemWriteListener;
import cn.chenzw.springboot.batch.basic.samples.step.async.MyItemProcessor;
import cn.chenzw.springboot.batch.basic.samples.step.async.MyItemReader;
import cn.chenzw.springboot.batch.basic.samples.step.async.MyItemWriter;
import cn.chenzw.springboot.batch.basic.samples.step.async.listener.MyAsyncItemProcessListener;
import cn.chenzw.springboot.batch.basic.samples.step.async.listener.MyAsyncItemWriteListener;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.skip.AlwaysSkipItemSkipPolicy;
import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.integration.async.AsyncItemWriter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.retry.policy.NeverRetryPolicy;

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
                .faultTolerant()
                .skipPolicy(new AlwaysSkipItemSkipPolicy())
                .retryPolicy(new NeverRetryPolicy())
                .listener(myAsyncItemProcessListener())
                .listener(myAsyncItemWriteListener())
                .reader(myItemReader())
                .processor(asyncItemProcessor())
                //.processor(myItemProcessor())
                .writer(asyncItemWriter())
                .build();
    }

    @Bean
    public ItemReader myItemReader() {
        return new MyItemReader();
    }

    @Bean
    @StepScope
    public ItemProcessor myItemProcessor() {
        return new MyItemProcessor();
    }

    @Bean
    public ItemWriter myItemWriter() {
        return new MyItemWriter();
    }

    @Bean
    public TaskExecutor simpleTaskExecutor(){
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        simpleAsyncTaskExecutor.setConcurrencyLimit(20);
        simpleAsyncTaskExecutor.setThreadNamePrefix("async-task");
        return simpleAsyncTaskExecutor;
    }

    @Bean
    public AsyncItemProcessor asyncItemProcessor() {
        AsyncItemProcessor asyncItemProcessor = new AsyncItemProcessor();
        asyncItemProcessor.setTaskExecutor(simpleTaskExecutor());
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
        return new MyAsyncItemProcessListener();
    }

    @Bean
    public ItemWriteListener myAsyncItemWriteListener(){
        return new MyAsyncItemWriteListener();
    }
}
