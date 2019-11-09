package cn.chenzw.springboot.batch.basic.samples.config;

import cn.chenzw.springboot.batch.basic.samples.item.MyItemProcessor;
import cn.chenzw.springboot.batch.basic.samples.item.MyItemReader;
import cn.chenzw.springboot.batch.basic.samples.item.MyItemWriter;
import cn.chenzw.springboot.batch.basic.samples.listener.JobCompletionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
                .incrementer(new RunIdIncrementer()).listener(jobExecutionListener())
                .flow(myStep1())
                .end()
                .build();
    }

    @Bean
    public Step myStep1() {
        return stepBuilderFactory.get("myStepName1")
                .<String, String>chunk(5)  // 每执行5次processor后write一次
                .reader(new MyItemReader())
                .processor(new MyItemProcessor())
                .writer(new MyItemWriter())
                .build();
    }

    @Bean
    public JobExecutionListener jobExecutionListener() {
        return new JobCompletionListener();
    }
}
