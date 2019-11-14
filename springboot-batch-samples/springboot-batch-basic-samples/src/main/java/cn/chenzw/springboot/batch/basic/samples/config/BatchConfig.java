package cn.chenzw.springboot.batch.basic.samples.config;

import cn.chenzw.springboot.batch.basic.samples.item.MyItemReader;
import cn.chenzw.springboot.batch.basic.samples.item.async.MyAsyncItemProcessor;
import cn.chenzw.springboot.batch.basic.samples.item.async.MyAsyncItemWriter;
import cn.chenzw.springboot.batch.basic.samples.listener.*;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;

import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.skip.AlwaysSkipItemSkipPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.policy.NeverRetryPolicy;


@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job myJob() {
        return jobBuilderFactory.get("myJobName")
                .incrementer(new RunIdIncrementer())
                .listener(myJobExecutionListener())
                // .start(myStep1()).next(myStep1()).next(myStep1())
                .flow(myStep1())
                .end()
                .build();
    }

    @Bean
    public Step myStep1() {
        return stepBuilderFactory.get("myStepName1")
                .<String, String>chunk(5)  // 每执行10次processor后write一次
                .faultTolerant()
                //.retryLimit(0).retry(IllegalArgumentException.class)
                //.skipLimit(1).skip(Exception.class)  // 捕捉到异常就重试,重试100次还是异常,JOB就停止并标志失败
                .skipPolicy(new AlwaysSkipItemSkipPolicy())
                .retryPolicy(new NeverRetryPolicy())
                .listener(myChunkListener())
                .listener(mySkipListener())
                .listener(myStepListener())
                .reader(new MyItemReader())
                // .processor(new MyItemProcessor())
                .processor(new MyAsyncItemProcessor())
                //.writer(new MyItemWriter())
                .writer(new MyAsyncItemWriter())
                // .taskExecutor(myTaskExecutor())
                //.throttleLimit(100)
                .build();
    }

  /*  @Bean
    public TaskExecutor myTaskExecutor() {
        return new SimpleAsyncTaskExecutor("spring_batch");
    }*/

    @Bean
    public JobExecutionListener myJobExecutionListener() {
        return new MyJobExecutionListener();
    }

    @Bean
    public ChunkListener myChunkListener() {
        return new MyChunkListener();
    }

    @Bean
    public SkipListener mySkipListener() {
        return new MySkipListener();
    }

    @Bean
    public StepListener myStepListener() {
        return new MyStepListener();
    }

    @Bean
    public ItemReadListener myItemReadListener() {
        return  new MyItemReaderListener();
    }
}
