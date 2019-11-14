package cn.chenzw.springboot.batch.basic.samples.config;

import cn.chenzw.springboot.batch.basic.samples.listener.MyItemReaderListener;
import cn.chenzw.springboot.batch.basic.samples.listener.MyItemWriteListener;
import cn.chenzw.springboot.batch.basic.samples.listener.MyStepListener;
import cn.chenzw.springboot.batch.basic.samples.step.file.MyFileItemReader;
import cn.chenzw.springboot.batch.basic.samples.step.file.MyFileItemWriter;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.skip.AlwaysSkipItemSkipPolicy;
import org.springframework.batch.core.step.skip.NeverSkipItemSkipPolicy;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.PassThroughItemProcessor;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 文件批处理
 *
 * @author chenzw
 */
@Configuration
public class FileBatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job fileProcessJob() {
        return jobBuilderFactory.get("fileProcessJob")
                .incrementer(new RunIdIncrementer())
                .flow(fileProcessStep()).next(fileMoveStep())
                .end()
                .build();
    }

    /**
     * 文件处理步骤
     *
     * @return
     */
    @Bean
    public Step fileProcessStep() {
        return stepBuilderFactory.get("fileProcessStep")
                .chunk(10)
                .faultTolerant().skipPolicy(new AlwaysSkipItemSkipPolicy())
                .listener(myFileStepListener())
                .listener(myFileItemReadListener())
                .listener(myFileItemWriteListener())
                .reader(myFileItemReader())
                .processor(new PassThroughItemProcessor())
                .writer(myFileItemWriter())
                .build();

    }

    @Bean
    public Step fileMoveStep() {
        return stepBuilderFactory.get("fileMoveStep")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public ItemReader myFileItemReader() {
        return new MyFileItemReader();
    }

    @Bean
    public ItemWriter myFileItemWriter() {
        return new MyFileItemWriter();
    }

    @Bean
    public StepListener myFileStepListener() {
        return new MyStepListener();
    }

    @Bean
    public ItemReadListener myFileItemReadListener() {
        return new MyItemReaderListener();
    }

    @Bean
    public ItemWriteListener myFileItemWriteListener() {
        return new MyItemWriteListener();
    }
}
