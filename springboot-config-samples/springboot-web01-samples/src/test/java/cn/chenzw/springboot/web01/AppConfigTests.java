package cn.chenzw.springboot.web01;

import cn.chenzw.springboot.web01.bean.ConfigBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Web01SamplesApp.class)
@WebAppConfiguration
public class AppConfigTests {

    @Autowired
    ConfigBean configBean;


    @Test
    public void testConfig() {
        Assert.assertEquals(configBean.getAppName(), "ext-app");
        Assert.assertEquals(configBean.getBase01Name(), "base01-app");
        Assert.assertEquals(configBean.getBase02Name(), "base02-app");
        Assert.assertEquals(configBean.getWeb01Name(), "web01");
    }

}
