package cn.chenzw.springboot.batch.basic.samples.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 异步处理
 *
 * @author chenzw
 */
//@Configuration
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
                .build();
    }
}
