package cn.chenzw.springboot.redis.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonTests {

    @Test
    public void test() {
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379");

        RedissonClient redissonClient = Redisson.create();

        redissonClient.
    }
}
