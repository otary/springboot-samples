package cn.chenzw.springboot.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Redis版的布隆过滤器
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonTests {

    /**
     * 布隆过滤器
     */
    @Test
    public void testBloomFilter() {
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379");

       /*
        // 集群方式
       config.useClusterServers()
                .setScanInterval(2000)
                .addNodeAddress("redis://10.0.29.30:6379", "redis://10.0.29.95:6379")
                .addNodeAddress("redis://10.0.29.205:6379");
       */

        RedissonClient redissonClient = Redisson.create();
        RBloomFilter<Object> rBloomFilter =
                redissonClient.getBloomFilter("test");

        for (int i = 0; i < 10000000; i++) {
            rBloomFilter.add("张三_" + i);
        }

        List<String> mismatchs = new ArrayList<>();
        for (int i = 10000000; i < 20000000; i++) {
            boolean contains = rBloomFilter.contains("张三_" + i);
            if (contains) {
                mismatchs.add("张三_" + i);
            }
        }

        log.info("误差匹配统计: 误差数量 => {}, 误差率 => {}", mismatchs.size(), BigDecimal.valueOf((float) mismatchs.size() / 10000000).setScale(2, RoundingMode.HALF_DOWN));
    }


}
