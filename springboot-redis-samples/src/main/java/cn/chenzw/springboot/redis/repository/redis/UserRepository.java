package cn.chenzw.springboot.redis.repository.redis;

import cn.chenzw.springboot.redis.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserRepository {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;


    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps;


    public void save(User user) {
        valOps.set(user.getId(), user);
    }

    public User findById(Long id) {
        return (User) valOps.get(id);
    }
    
}
