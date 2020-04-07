package cn.chenzw.springboot.redis.repository.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HashOperationsTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        // 添加值
        redisTemplate.opsForHash().put("score", "张三@@math", 60);
        redisTemplate.opsForHash().put("score", "张三@@chinese", 50);
        redisTemplate.opsForHash().put("score", "李四@@math", 90);
        redisTemplate.opsForHash().put("score", "李四@@chinese", 80);
        printEntries("score");

        // 判断HashKey是否存在
        Boolean hashKeyExists = redisTemplate.opsForHash().hasKey("score", "张三@@math");
        Assert.assertTrue(hashKeyExists);

        // 获取指定hashKey值
        Object getValue = redisTemplate.opsForHash().get("score", "张三@@math");
        logger.info("【get】: {}", getValue);

        // 批量获取值
        List multiGetValues = redisTemplate.opsForHash().multiGet("score", Arrays.asList("张三@@math", "张三@@chinese"));
        logger.info("【multiGet】: {}", multiGetValues);

        // 获取所有值
        List values = redisTemplate.opsForHash().values("score");
        logger.info("【value】: {}", values);

        // 删除指定hashKey值
        redisTemplate.opsForHash().delete("score", "张三@math");

        cleanAll();
    }


    private void printEntries(String msgPrefix) {
        // 列举所有key值
        Map scores = redisTemplate.opsForHash().entries("score");
        for (Object entry : scores.entrySet()) {
            logger.info("【" + msgPrefix + "】: {}", entry);
        }
    }

    private void cleanAll() {
        redisTemplate.delete("score");
    }
}
