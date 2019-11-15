package cn.chenzw.springboot.batch.basic.samples.item;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * 输出器
 *
 * @author chenzw
 */
public class MyItemWriter implements ItemWriter<Person> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void write(List<? extends Person> items) throws Exception {
        logger.info("写入:{}", items);
    }
}
