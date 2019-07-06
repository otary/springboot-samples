package cn.chenzw.springboot.quartz;

import cn.chenzw.springboot.quartz.service.MyQuartzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = QuartzSamplesApp.class)
@WebAppConfiguration
public class QuartzTests {

    @Autowired
    MyQuartzService myQuartzService;


    @Test
    public void test() throws Exception {
        myQuartzService.addjob();

        TimeUnit.SECONDS.sleep(5);
    }

}
