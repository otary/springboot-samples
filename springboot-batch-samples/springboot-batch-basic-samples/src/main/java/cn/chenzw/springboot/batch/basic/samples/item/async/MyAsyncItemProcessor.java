package cn.chenzw.springboot.batch.basic.samples.item.async;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MyAsyncItemProcessor implements
        ItemProcessor<String, Future<String>> {


    /**
     * SyncTaskExecutor会在当前线程执行完客户提交给它的任务，即它是以同步方式完成任务的执行的。
     */

    private SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor("batch-executor");

    public MyAsyncItemProcessor() {
        //ThreadFactory
        //taskExecutor.setThreadFactory();

        //  System.out.println(taskExecutor.isThrottleActive());
        taskExecutor.setConcurrencyLimit(5);
    }


    @Override
    public Future<String> process(String data) throws Exception {

        FutureTask<String> task = new FutureTask<String>(
                new Callable<String>() {
                    public String call() throws Exception {

                       /* SimpleRetryPolicy policy = new SimpleRetryPolicy(5);

                        RetryTemplate template = new RetryTemplate();

                        template.setRetryPolicy(policy);

                        try {
                            Object execute = template.execute(new RetryCallback<Object, Throwable>() {

                                int i =0;
                                @Override
                                public Object doWithRetry(RetryContext retryContext) throws Throwable {
                                    if(i < 3){
                                        i++;
                                        throw new RuntimeException("泡池");
                                    }
                                    return "结果";
                                }
                            });

                            System.out.println("execute:" + execute);
                        } catch (Throwable throwable) {
                            System.out.println("这是重试异常");
                        }*/

                        System.out.println("before process[" + Thread.currentThread().getId() + "]:" + data);

                        Thread.sleep(2000);

                        int i = Integer.parseInt(data);
                        if (i % 5 == 0) {
                            System.out.println("-----------异常:" + i);
                            throw new RuntimeException("异常！");
                        }

                       // System.out.println("after process[" + Thread.currentThread().getId() + "]:" + data);

                        return "";
                    }
                });
        this.taskExecutor.execute(task);
        return task;
    }


  /*  public TaskExecutor getTaskExecutor() {
        return this.taskExecutor;
    }*/

  /*  public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }*/
}
