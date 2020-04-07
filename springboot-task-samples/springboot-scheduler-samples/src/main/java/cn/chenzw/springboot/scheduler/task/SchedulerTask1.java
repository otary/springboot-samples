package cn.chenzw.springboot.scheduler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SchedulerTask1 {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 指定时间执行（每隔6s执行一次）
     */
    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        logger.info("Schedule task1 running");
    }
}
