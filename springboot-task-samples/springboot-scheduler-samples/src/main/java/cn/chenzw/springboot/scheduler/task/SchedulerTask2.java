package cn.chenzw.springboot.scheduler.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask2 implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    /**
     * 固定频率执行（间隔1s执行一次）
     * <p>
     * 同步执行方式（下个任务必须等上一个任务执行完成后才执行）
     * </p>
     */
    @Scheduled(fixedRate = 1000)
    private void process() throws InterruptedException {
        logger.info("[1] Schedule task2 start running");

        Thread.sleep(5000);

        logger.info("[1] Schedule task2 end running");
    }

   // @Scheduled(cron = "0/1 * * * * ?")
    private void process2() {
        logger.info("[2] Schedule task2-2  start running");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("[2] Schedule task2-2 end running");
    }

    /**
     * 异步执行
     */
    @Async
    @Scheduled(fixedRate = 1000)
    public void asyncProcess() throws InterruptedException {
        logger.info("[3] Schedule aysnc task2 start running");

        Thread.sleep(3000);

        logger.info("[3] Schedule aysnc task2 end running");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        threadPoolTaskScheduler.schedule(() -> process2(), triggerContext -> new CronTrigger("0/1 * * * * ?").nextExecutionTime(triggerContext));
    }
}
