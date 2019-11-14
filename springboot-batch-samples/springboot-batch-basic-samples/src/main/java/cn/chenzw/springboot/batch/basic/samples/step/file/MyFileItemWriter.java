package cn.chenzw.springboot.batch.basic.samples.step.file;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * 文件写操作
 *
 * @author chenzw
 */
public class MyFileItemWriter implements ItemWriter<Person> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void write(List<? extends Person> list) throws Exception {

        if(true){
            throw new RuntimeException("异常!");
        }
        logger.info("文件写入:" + list);
    }
}
