package cn.chenzw.springboot.batch.basic.samples.item.async;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MyAsyncItemProcessor implements
        ItemProcessor<String, Future<String>> {


    /**
     * SyncTaskExecutor会在当前线程执行完客户提交给它的任务，即它是以同步方式完成任务的执行的。
     */

    private SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor("batch-executor");

    public MyAsyncItemProcessor(){
        //ThreadFactory
        //taskExecutor.setThreadFactory();

        System.out.println(taskExecutor.isThrottleActive());
        //taskExecutor.setConcurrencyLimit(2);
    }

    @Override
    public Future<String> process(String data) throws Exception {

        FutureTask<String> task = new FutureTask<String>(
                new Callable<String>() {
                    public String call() throws Exception {

                        System.out.println("before process[" + Thread.currentThread().getId() + "]:" + data);

                        Thread.sleep(2000);

                        /*if(true){
                            throw new IllegalArgumentException("异常！");
                        }*/

                        System.out.println("after process[" + Thread.currentThread().getId() + "]:" + data);

                        return data.toUpperCase();
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
