package cn.chenzw.springboot.batch.basic.samples.step.async.listener;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author chenzw
 */
public class MyAsyncItemProcessListener implements ItemProcessListener<Person, FutureTask<Person>> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void beforeProcess(Person item) {

    }

    ConcurrentLinkedQueue<FutureTask<Person>> queue = new ConcurrentLinkedQueue();

    /**
     * 异步处理
     *
     * @param person
     * @param result
     */
    @Override
    public void afterProcess(Person person, FutureTask<Person> result) {
       /* FutureTask<Person> item;

        if (result.isDone()) {
            if (!result.isCancelled()) {
                System.out.println("----------done---------------");
            }
        } else {
            queue.add(result);
            System.out.println("-------未done----------");
        }

        while ((item = queue.poll()) != null) {
            if (item.isDone()) {
                if (!item.isCancelled()) {
                    System.out.println("----------done2---------------");
                }
            } else {
                queue.add(item);
                System.out.println("-------未done2----------");
            }
        }*/

       /* */

        /*try {
            result.get();
        } catch (InterruptedException e) {
            logger.error("process with error! data: [{}], exception: [{}]", person, e.getLocalizedMessage());
        } catch (ExecutionException e) {
            logger.error("process with error! data: [{}], exception: [{}]", person, e.getLocalizedMessage());
        }*/
    }

    @Override
    public void onProcessError(Person item, Exception e) {

        System.out.println("-----------------------------");
    }

}
