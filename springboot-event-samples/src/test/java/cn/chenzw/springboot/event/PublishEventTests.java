package cn.chenzw.springboot.event;

import cn.chenzw.springboot.event.entity.User;
import cn.chenzw.springboot.event.event.MyEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublishEventTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testPublish() {
        User user = new User();
        user.setUserId(1L);
        user.setUserName("admin");
        applicationContext.publishEvent(new MyEvent(user));
    }
}
