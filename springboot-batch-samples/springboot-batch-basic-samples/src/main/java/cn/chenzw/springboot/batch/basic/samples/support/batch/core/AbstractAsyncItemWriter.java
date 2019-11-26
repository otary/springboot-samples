package cn.chenzw.springboot.batch.basic.samples.support.batch.core;

import org.springframework.batch.item.ItemWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

/**
 * @author chenzw
 */
public abstract class AbstractAsyncItemWriter<I> implements ItemWriter<Future<I>> {


    public abstract void doWrite(List<I> list);

    @Override
    public void write(List<? extends Future<I>> list) throws Exception {
        ConcurrentLinkedQueue<Future<I>> queue = new ConcurrentLinkedQueue<>(list);
        List<I> results = new ArrayList<>();

        Future<I> item;
        while ((item = queue.poll()) != null) {
            if (item.isDone()) {
                if (!item.isCancelled()) {
                    results.add(item.get());
                }
            } else {
                queue.add(item);
            }
        }
        doWrite(results);
    }
}
