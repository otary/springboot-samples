package cn.chenzw.springboot.batch.basic.samples.step.mybatis;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import cn.chenzw.springboot.batch.basic.samples.repository.PersonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 文件写操作
 *
 * @author chenzw
 */
public class MyFileItemWriter implements ItemWriter<Person> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PersonMapper personMapper;

    @Override
    public void write(List<? extends Person> list) throws Exception {

        personMapper.insertBatch((List<Person>) list);

        logger.info("文件写入:" + list);
    }
}
