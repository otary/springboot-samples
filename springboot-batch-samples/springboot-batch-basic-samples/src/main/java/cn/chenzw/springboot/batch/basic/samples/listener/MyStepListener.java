package cn.chenzw.springboot.batch.basic.samples.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class MyStepListener implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("step执行之前");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("step执行之后");
        return null;
    }
}
