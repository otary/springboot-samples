package cn.chenzw.springboot.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchedulerListener implements JobListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String getName() {
        return "MyQuartSchedulerListener";
    }

    /**
     * 任务调度前
     *
     * @param jobExecutionContext
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        String jobName = jobExecutionContext.getJobDetail().getKey().toString();
        logger.info("[jobToBeExecuted]:{}", jobName);
    }

    /**
     * 任务调度被拒绝
     *
     * @param jobExecutionContext
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        logger.info("[jobExecutionVetoed]:");
    }

    /**
     * 任务调度后
     *
     * @param jobExecutionContext
     * @param e
     */
    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        String jobName = jobExecutionContext.getJobDetail().getKey().toString();

        logger.info("[jobWasExecuted]:{}", jobName);

        if (e != null) {
            logger.info("job execution with exception:[{}]", e);
        }
    }
}
