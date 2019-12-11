package cn.chenzw.springboot.quartz.service;

import cn.chenzw.springboot.quartz.job.NotificationJob;
import cn.chenzw.springboot.quartz.listener.SchedulerListener;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyQuartzService {

    @Autowired
    Scheduler scheduler;

    /**
     * 添加任务
     *
     * @throws Exception
     */
    public void addjob() throws Exception {
        // 启动调度器
        scheduler.start();
        JobDetail job = JobBuilder.newJob(NotificationJob.class).withIdentity("NotificationJob", "chenzw_group").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("NotificationJob", "chenzw_group").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1)
                .repeatForever()).build();
        // 添加监听器
        scheduler.getListenerManager().addJobListener(new SchedulerListener());

        if(!scheduler.checkExists(job.getKey())){
            scheduler.scheduleJob(job, trigger);
        }
    }


    /**
     * 暂停任务
     *
     * @throws Exception
     */
    public void pausejob() throws Exception {
        scheduler.pauseJob(JobKey.jobKey("HelloJob", "group1"));
    }

    public void resumejob() throws Exception {
        scheduler.resumeJob(JobKey.jobKey("HelloJob", "group1"));
    }

    /**
     * 删除任务
     *
     * @throws Exception
     */
    public void deletejob() throws Exception {
        scheduler.pauseTrigger(TriggerKey.triggerKey("HelloJob", "group1"));
        scheduler.unscheduleJob(TriggerKey.triggerKey("HelloJob", "group1"));
        scheduler.deleteJob(JobKey.jobKey("HelloJob", "group1"));
    }
}
