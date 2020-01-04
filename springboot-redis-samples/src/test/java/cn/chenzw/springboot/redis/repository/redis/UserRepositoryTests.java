package cn.chenzw.springboot.redis.repository.redis;

import cn.chenzw.springboot.redis.RedisSamplesApp;
import cn.chenzw.springboot.redis.domain.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisSamplesApp.class)
@WebAppConfiguration
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;


    @Test
    public void testSave() {
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        user.setAge(20);
        user.setBirth(new Date());

        // 保存
        userRepository.save(user);

        // 读取
        User user2 = userRepository.findById("1");
        Assert.assertTrue(Objects.equals(user, user2));
    }

    @Resource(name = "redisTemplate")
    ValueOperations<String, String> valOps;

}
