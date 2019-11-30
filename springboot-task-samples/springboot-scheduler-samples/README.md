# spring scheduler


## 常用功能配置

### 同步执行（同一任务）

> 下个任务将在上个任务执行后才会执行

``` java
@Scheduled(cron = "*/6 * * * * ?")
private void process() {
     System.out.println("schedule task1 running, now time:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
}
```
 
 ### 并行执行（同一任务）
 
 > 下个任务不等待上个任务执行完毕，只要时间到立即并行执行
 
 ``` java
@Async
@Scheduled(cron = "*/6 * * * * ?")
private void process() {
     System.out.println("schedule task1 running, now time:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
}
```

### 配置线程池

``` java
@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

    private final int POOL_SIZE = 10;

    /**
     * 默认所有@Scheduled任务都在Spring创建的大小为1的默认线程池中执行，可以在此处自定义线程池来执行任务
     *
     * @param scheduledTaskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

        threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix("my-scheduled-task-pool-");
        threadPoolTaskScheduler.initialize();

        scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
    }
}
```