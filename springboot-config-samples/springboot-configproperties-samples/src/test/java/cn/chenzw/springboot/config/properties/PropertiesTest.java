package cn.chenzw.springboot.config.properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PropertiesTest {

    @Autowired
    SSOProperties ssoProperties;

    @Test
    public void testSSOProperties() {
        Assert.assertEquals("1234567", ssoProperties.getPrivateKey());
        Assert.assertEquals("http://www.baidu.com", ssoProperties.getDefaultUrl());
    }

    @Test
    public void testSSOConstants() {
        Assert.assertEquals("1234567", SSOConstants.getPrivateKey());
        Assert.assertEquals("http://www.baidu.com", SSOConstants.getDefaultUrl());
    }
}
