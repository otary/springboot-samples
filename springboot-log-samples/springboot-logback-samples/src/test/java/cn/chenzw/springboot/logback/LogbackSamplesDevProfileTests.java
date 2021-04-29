package cn.chenzw.springboot.logback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 开发环境日志
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"dev"})
public class LogbackSamplesDevProfileTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test() {
        logger.debug("debug => ...");
        logger.info("info => ...");
    }

}
