package cn.chenzw.springboot.batch.basic.samples.item.async;

import org.springframework.batch.item.ItemWriter;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public class MyAsyncItemWriter implements
        ItemWriter<Future<String>> {

    @Override
    public void write(List<? extends Future<String>> list) throws Exception {
        LinkedList<Future<String>> linklist = new LinkedList<Future<String>>(list);

        Future<String> future;

        // the head of this linklist
        while ((future = linklist.poll()) != null) {
            if (future.isDone()) {
                if (!future.isCancelled()) {
                    System.out.println("写入:" + future.get());
                }
            } else {
                linklist.addLast(future);
            }
        }

    }
}
