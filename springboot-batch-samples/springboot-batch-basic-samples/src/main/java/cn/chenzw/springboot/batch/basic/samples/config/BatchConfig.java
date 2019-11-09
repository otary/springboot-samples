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
                .incrementer(new RunIdIncrementer())
                .listener(jobExecutionListener())
                // .start(myStep1()).next(myStep1()).next(myStep1())
                .flow(myStep1())
                .end()
                .build();
    }

    @Bean
    public Step myStep1() {
        return stepBuilderFactory.get("myStepName1")
                .<String, String>chunk(10)  // 每执行10次processor后write一次
                .faultTolerant().retryLimit(3).retry(Exception.class).skipLimit(100).skip(Exception.class)  // 捕捉到异常就重试,重试100次还是异常,JOB就停止并标志失败
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
