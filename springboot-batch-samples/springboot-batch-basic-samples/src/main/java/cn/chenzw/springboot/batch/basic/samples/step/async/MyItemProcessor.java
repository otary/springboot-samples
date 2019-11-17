package cn.chenzw.springboot.batch.basic.samples.step.async;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * 处理器
 *
 * @author chenzw
 */
public class MyItemProcessor implements ItemProcessor<Person, Person> {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public Person process(Person item) throws Exception {
        logger.info("process[{}]: {}", Thread.currentThread().getId(), item);
        return item;
    }

}
