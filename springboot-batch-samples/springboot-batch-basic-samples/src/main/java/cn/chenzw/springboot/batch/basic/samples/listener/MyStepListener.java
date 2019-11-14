package cn.chenzw.springboot.batch.basic.samples.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

/**
 * Step监听器
 *
 * @author chenzw
 */
public class MyStepListener implements StepExecutionListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void beforeStep(StepExecution stepExecution) {
        logger.info("before step..." + stepExecution);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("step执行之后");
        return null;
    }
}
