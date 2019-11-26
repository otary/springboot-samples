package cn.chenzw.springboot.batch.basic.samples.step.async.listener;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import cn.chenzw.toolkit.commons.ListExtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 写操作监听器
 *
 * @author chenzw
 */
public class MyAsyncItemWriteListener implements ItemWriteListener<FutureTask<Person>> {

    private final Logger logger = LoggerFactory.getLogger(MyAsyncItemWriteListener.class);

    @Override
    public void beforeWrite(List<? extends FutureTask<Person>> items) {
        //logger.info("before write, target: {} ", items);
    }

    @Override
    public void afterWrite(List<? extends FutureTask<Person>> items) {
        //logger.info("after write, target: {} ", items);
    }

    @Override
    public void onWriteError(Exception exception, List<? extends FutureTask<Person>> items) {

        List<Person> persons = new ArrayList<>();
        /*for (FutureTask<Person> item : items) {
            Person person = null;
            try {
                person = item.get();

                System.out.println("------------person:" + person);
                persons.add(person);

            } catch (InterruptedException e) {
                //    e.printStackTrace();
                System.out.println("-----------------------" + e.getLocalizedMessage());
            } catch (ExecutionException e) {
                //a   e.printStackTrace();
                System.out.println("-----------222------------" + person + "@@" + e.getLocalizedMessage());
            }
        }*/
        Person person = null;
        try {

            for (FutureTask<Person> item : items) {
                System.out.println("--------before------" + item);
                 person = item.get();
                System.out.println("--------after------" + item);
            }

         //   System.out.println("------------person:" + person);
            persons.add(person);

        } catch (InterruptedException e) {
            //    e.printStackTrace();
            System.out.println("-----------------------" + e.getLocalizedMessage());
        } catch (ExecutionException e) {
            //a   e.printStackTrace();
            System.out.println("-----------222------------" + person + "@@" + e.getLocalizedMessage());
        }


        logger.error("write with error! data:[{}], exception:[{} - {}]", persons, exception.getClass().getSimpleName(), exception.getLocalizedMessage());
    }

    private void print() {

    }

}
