package cn.chenzw.springboot.scheduler.task;


import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerTask2 {

    /**
     * 固定频率执行（间隔6s执行一次）
     */
    @Scheduled(fixedRate = 6000)
    private void process() {
        System.out.println("schedule task2 running, now time: " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }
}
