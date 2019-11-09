package cn.chenzw.springboot.batch.basic.samples.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionListener extends JobExecutionListenerSupport {

    long startTime;
    long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.STARTED) {
            startTime = System.currentTimeMillis();

            System.out.println("批处理执行开始....");
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            endTime = System.currentTimeMillis();

            System.out.println("批处理执行结束...., cost: " + (endTime - startTime) + "ms");
        }
    }
}