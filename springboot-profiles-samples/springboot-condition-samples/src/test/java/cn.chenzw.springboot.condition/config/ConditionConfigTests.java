package cn.chenzw.springboot.condition.config;

import cn.chenzw.springboot.condition.ConditionSamplesApp;
import cn.chenzw.springboot.condition.template.AbstractTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = ConditionSamplesApp.class)
public class ConditionConfigTests {


    @Autowired
    AbstractTemplate abstractTemplate;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testOs() {
        log.info("OS系统:[ " + applicationContext.getEnvironment().getProperty("os.name") + " ], templates:[ " + abstractTemplate.getName() + " ]");

        Assert.assertEquals(abstractTemplate.getName(), "windows-templates");
    }

    @Test
    public void testMyBean(){
        Assert.assertTrue(applicationContext.containsBean("myBean"));

        Assert.assertTrue(applicationContext.containsBean("myBean2"));

        Assert.assertTrue(applicationContext.containsBean("myBean4"));

        Assert.assertTrue(applicationContext.containsBean("myBean5"));
    }
}
