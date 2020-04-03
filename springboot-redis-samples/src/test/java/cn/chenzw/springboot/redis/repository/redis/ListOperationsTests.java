package cn.chenzw.springboot.redis.repository.redis;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListOperationsTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 可用作队列
     */
    @Test
    public void test() {
        // 左插入
        redisTemplate.opsForList().leftPush("product", "苹果");
        redisTemplate.opsForList().leftPush("product", "鸡蛋");
        printEntries("leftPush");

        // 左取出
        Object leftPop = redisTemplate.opsForList().leftPop("product");
        logger.info("【leftPop】: {}", leftPop);
        Object leftPop2 = redisTemplate.opsForList().leftPop("product");
        logger.info("【leftPop】: {}", leftPop2);

        // 右插入
        redisTemplate.opsForList().rightPush("product", "香蕉");
        redisTemplate.opsForList().rightPush("product", "波罗");
        printEntries("rightPush");

        // 右取出
        Object rightPop = redisTemplate.opsForList().rightPop("product");
        logger.info("【rightPop】: {}", rightPop);
        Object rightPop2 = redisTemplate.opsForList().rightPop("product");
        logger.info("【rightPop】: {}", rightPop2);

        // 批量左插入
        redisTemplate.opsForList().leftPushAll("product", Arrays.asList("可口可乐", "百事可乐"));
        printEntries("leftPushAll");

        // 获取指定位置的数据
        Object product = redisTemplate.opsForList().index("product", 0);
        logger.info("【index】: {}", product);

        // 设置指定位置的数值（值必须先存在）
        redisTemplate.opsForList().set("product", 0, "地瓜");

        //rightPopAndLeftPush

        cleanAll();
    }


    private void printEntries(String msgPrefix) {
        Long size = redisTemplate.opsForList().size("product");
        List products = redisTemplate.opsForList().range("product", 0, size);
        for (Object product : products) {
            logger.info("【" + msgPrefix + "】:" + product);
        }
    }

    private void cleanAll() {
        redisTemplate.delete("product");
    }

}
