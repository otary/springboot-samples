package cn.chenzw.springboot.batch.basic.samples.item;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import org.springframework.batch.item.ItemProcessor;

/**
 * 处理器
 *
 * @author chenzw
 */
public class MyItemProcessor implements ItemProcessor<String, String> {

    /**
     * 字母转大写
     *
     * @param data
     * @return
     * @throws Exception
     */
    @Override
    public String process(String data) throws Exception {
        return data.toUpperCase();
    }


}