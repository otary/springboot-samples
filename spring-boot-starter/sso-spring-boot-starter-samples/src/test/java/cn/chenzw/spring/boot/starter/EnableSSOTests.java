package cn.chenzw.spring.boot.starter;

import cn.chenzw.spring.boot.annotation.EnableSSO;
import cn.chenzw.spring.boot.domain.entity.Person;
import cn.chenzw.spring.boot.domain.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * EnableSSO示例
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = SSOSamplesApp.class)
@EnableSSO(name = "xxx")
public class EnableSSOTests {

    /**
     * 通过ImportSelector进行Bean注册
     */
    @Autowired
    User user;

    /**
     * 通过ImportBeanDefinitionRegistrar进行Bean注册
     */
    @Autowired
    Person person;

    @Test
    public void test() {
        Assert.assertNotNull(user);

        Assert.assertNotNull(person);

    }

}
