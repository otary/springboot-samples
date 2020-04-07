package cn.chenzw.springboot.redis.repository.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueOperationsTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private CommonOperations commonOperations;


    @Test
    public void test() throws InterruptedException {
        redisTemplate.opsForValue().set("user@@name", "张三");
        commonOperations.printStringEntries("普通写入");

        // 带过期时间(1s后失效)
        redisTemplate.opsForValue().set("user@@name", "张三", 1, TimeUnit.SECONDS);
        Thread.sleep(1200);
        commonOperations.printStringEntries("写入带过期时间");

        // 不存在时写入
        redisTemplate.opsForValue().setIfAbsent("user@@name", "张三");
        commonOperations.printStringEntries("不存在时写入");

        // 存在时写入
        redisTemplate.opsForValue().setIfPresent("user@@name", "张三");
        commonOperations.printStringEntries("存在时写入");

        // 批量写入
        Map<String, String> map = new HashMap<String, String>() {{
            put("user@@id", "1");
            put("user@@name", "李四");
        }};
        redisTemplate.opsForValue().multiSet(map);
        commonOperations.printStringEntries("批量写入");

        // 写入新值并返回旧值
        Object oldValue = redisTemplate.opsForValue().getAndSet("user@@name", "王五");
        commonOperations.printStringEntries("getAndSet示例");
        logger.info("【旧值】:{}", oldValue);

        // 批量取值
        List list = redisTemplate.opsForValue().multiGet(Arrays.asList("user@@name", "user@@id"));
        logger.info("【multiGet】:{}", list);

        // 值尾部添加数据
        redisTemplate.opsForValue().append("user@@name", "赵六");
        commonOperations.printStringEntries("append示例");

        // 获取值长度
        Long size = redisTemplate.opsForValue().size("user@@name");
        logger.info("【user@@name size】: {}", size);

        // 获取值范围
        String rangeValue = redisTemplate.opsForValue().get("user@@name", 0, 14);
        logger.info("【user@@name randomValue】: {}", rangeValue);


        // 暂时出现解析出错
        /*redisTemplate.opsForValue().setBit("user", 0, true);
        Boolean b = redisTemplate.opsForValue().getBit("user", 0);
        logger.info("【getBit】" + b);*/


        commonOperations.cleanAll();

    }


}
