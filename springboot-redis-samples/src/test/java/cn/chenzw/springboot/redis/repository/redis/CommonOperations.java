package cn.chenzw.springboot.redis.repository.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CommonOperations {

    @Autowired
    private RedisTemplate redisTemplate;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 输出所有的key-value值
     */
    protected void printStringEntries(String msgPrefix) {
        Map<Object, Object> result = new HashMap<>();
        Set keys = redisTemplate.keys("*");
        for (Object key : keys) {
            result.put(key, redisTemplate.opsForValue().get(key));
        }
        logger.info("【" + msgPrefix + "】String Entries: {}", result);
    }

    protected void printZSetEntries(String msgPrefix){
        Map<Object, Object> result = new HashMap<>();
        Set keys = redisTemplate.keys("*");
        for (Object key : keys) {

           // System.out.println(redisTemplate.opsForZSet().scan());
            //result.put(key, );
        }
        logger.info("【" + msgPrefix + "】ZSet Entries: {}", result);
    }

    /**
     * 清空所有key-value值
     */
    protected void cleanAll() {
        Set keys = redisTemplate.keys("*");
        for (Object key : keys) {
            redisTemplate.delete(key);
        }
    }
}
