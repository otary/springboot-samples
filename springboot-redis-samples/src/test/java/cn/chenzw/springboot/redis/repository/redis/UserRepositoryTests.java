package cn.chenzw.springboot.redis.repository.redis;

import cn.chenzw.springboot.redis.RedisSamplesApp;
import cn.chenzw.springboot.redis.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

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

        userRepository.save(user);

        User user2 = userRepository.findById(1L);
        System.out.println(user2);
    }
}
