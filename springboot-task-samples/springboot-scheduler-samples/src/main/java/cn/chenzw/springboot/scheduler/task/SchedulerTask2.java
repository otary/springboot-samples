package cn.chenzw.springboot.scheduler.task;


import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerTask2 {

    /**
     * 固定频率执行（间隔1s执行一次）
     * <p>
     * 同步执行方式（下个任务必须等上一个任务执行完成后才执行）
     * </p>
     */
    @Scheduled(fixedRate = 1000)
    private void process() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("schedule task2 running, now time: " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 异步执行
     */
    @Async
    @Scheduled(fixedRate = 1000)
    public void asyncProcess() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("schedule aysnc task2 running, now time: " + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }
}
