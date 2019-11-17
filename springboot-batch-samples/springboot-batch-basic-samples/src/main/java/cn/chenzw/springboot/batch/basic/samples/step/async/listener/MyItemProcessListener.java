package cn.chenzw.springboot.batch.basic.samples.step.async.listener;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;

public class MyItemProcessListener implements ItemProcessListener<Person, Person> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void beforeProcess(Person item) {

    }

    @Override
    public void afterProcess(Person item, Person result) {

    }

    @Override
    public void onProcessError(Person item, Exception e) {
        logger.error("process with error! exception: [{}]", e.getLocalizedMessage());
    }
}
