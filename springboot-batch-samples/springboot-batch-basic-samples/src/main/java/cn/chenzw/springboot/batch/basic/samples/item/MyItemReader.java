package cn.chenzw.springboot.batch.basic.samples.item;

import org.springframework.batch.item.ItemReader;

/**
 * 读取器
 *
 * @author chenzw
 */
public class MyItemReader implements ItemReader<String> {

    private String[] messages = {"hello world",
            "zhangsan",
            "lisi"};

    private int count = 0;

    @Override
    public String read() {
        System.out.println("读取:" + count);
        if (count < messages.length) {
            return messages[count++];
        } else {
            count = 0;
        }
        return null;
    }
}
