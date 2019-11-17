package cn.chenzw.springboot.batch.basic.samples.support.batch.core;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 异步处理
 *
 * @param <I>
 * @param <O>
 * @author chenzw
 */
public abstract class AbstractAsyncItemProcessor<I, O> implements ItemProcessor<I, Future<O>> {

    protected SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor("batch-executor");

    public AbstractAsyncItemProcessor() {

    }

    public AbstractAsyncItemProcessor(String threadNamePrefix, int concurrencyLimit) {
        taskExecutor.setThreadNamePrefix(threadNamePrefix);
        taskExecutor.setConcurrencyLimit(concurrencyLimit);
    }


    /**
     * 实际处理过程
     *
     * @param inData
     * @return
     */
    public abstract O doProcess(I inData) throws Exception;


    @Override
    public Future<O> process(I inData) throws Exception {
        FutureTask<O> task = null;
        try {
           task = new FutureTask<O>(() -> doProcess(inData));
            taskExecutor.execute(task);
        }catch (Exception e){
            System.out.println(e);
        }
        return task;
    }
}
