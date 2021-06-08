package cn.chenzw.springboot.sharding.jdbc.service;

import cn.chenzw.springboot.sharding.jdbc.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testList() {
        List<User> users = userService.list();

        log.info("users => {}", users);
    }

    @Test
    public void testAdd() throws InterruptedException {
        User user = new User();
        user.setId(5L);
        user.setName("张三");
        userService.add(user);

        Thread.sleep(2000);

        List<User> users = userService.list();
        log.info("users => {}", users);
    }
}
