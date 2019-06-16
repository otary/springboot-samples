package cn.chenzw.springboot.scheduler.task;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerTask1 {

    /**
     * 指定时间执行（每隔6s执行一次）
     */
    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println("schedule task1 running, now time:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }
}
