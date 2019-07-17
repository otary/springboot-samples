package cn.chenzw.spring.boot.starter;

import cn.chenzw.spring.boot.autoconfigure.SSOProperties;
import cn.chenzw.spring.boot.autoconfigure.support.AbstractSSOTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = SSOSamplesApp.class)
public class SSOTests {


    @Autowired
    AbstractSSOTemplate abstractSSOTemplate;

    @Test
    public void test(){
        SSOProperties properties = abstractSSOTemplate.getProperties();
        System.out.println(properties);
    }
}
