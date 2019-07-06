package cn.chenzw.springboot.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(NotificationJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("定时发送通知:-----****------");
    }
}
