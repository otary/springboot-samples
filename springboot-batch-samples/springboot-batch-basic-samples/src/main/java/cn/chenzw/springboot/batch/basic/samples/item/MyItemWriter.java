package cn.chenzw.springboot.batch.basic.samples.item;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * 输出器
 *
 * @author chenzw
 */
public class MyItemWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> messages) throws Exception {
        for (String msg : messages) {
            System.out.println("写入：" + msg);
        }
    }
}
