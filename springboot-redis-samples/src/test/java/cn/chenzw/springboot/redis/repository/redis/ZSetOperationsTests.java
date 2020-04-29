package cn.chenzw.springboot.redis.repository.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZSetOperationsTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RedisTemplate redisTemplate;


    @Test
    public void test() {
        redisTemplate.opsForZSet().add("class_score", "张三", 60);
        redisTemplate.opsForZSet().add("class_score", "李四", 80);
        printEntries("add");

        // 张三的排行
        Long rank = redisTemplate.opsForZSet().rank("class_score", "张三");
        logger.info("【张三 - rank】: {}", rank);
        // 李四的排行
        Long rank2 = redisTemplate.opsForZSet().rank("class_score", "李四");
        logger.info("【李四 - rank】: {}", rank2);

        // 获取张三的分数
        Double score = redisTemplate.opsForZSet().score("class_score", "张三");
        logger.info("【score】: {}", score);

        // 分数调整
        redisTemplate.opsForZSet().incrementScore("class_score", "张三", 2);
        printEntries("incrementScore");


        // 扫描
        Cursor<ZSetOperations.TypedTuple> classScoreCursor = null;
        try {
            classScoreCursor = redisTemplate.opsForZSet().scan("class_score", ScanOptions.scanOptions().match("*李*").count(1000).build());
            if (classScoreCursor.hasNext()) {
                ZSetOperations.TypedTuple entry = classScoreCursor.next();
                logger.info("【scan】: {} - {}", entry.getValue(), entry.getScore());
            }
        } finally {
            try {
                // 记得关闭,否则容易出错
                classScoreCursor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 分数区间
        Set<ZSetOperations.TypedTuple> classScoreRange = redisTemplate.opsForZSet().rangeByScoreWithScores("class_score", 50, 70);
        for (ZSetOperations.TypedTuple entity : classScoreRange) {
            logger.info("【rangeByScoreWithScores】: {} - {}", entity.getValue(), entity.getScore());
        }

        // 统计0~100分之间的个数
        Long count = redisTemplate.opsForZSet().count("class_score", 0, 100);
        logger.info("【count】: {}", count);



    }


    private void printEntries(String msgPrefix) {
        Long size = redisTemplate.opsForZSet().size("class_score");
        // 获取带分数的值
        Set<ZSetOperations.TypedTuple> classScores = redisTemplate.opsForZSet().rangeWithScores("class_score", 0, size);
        for (ZSetOperations.TypedTuple classScore : classScores) {
            logger.info("【" + msgPrefix + "】: {} - {}", classScore.getValue(), classScore.getScore());
        }
    }
}
