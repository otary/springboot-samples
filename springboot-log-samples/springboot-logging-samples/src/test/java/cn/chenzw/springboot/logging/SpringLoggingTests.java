package cn.chenzw.springboot.logging;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringLoggingTests {

    @Test
    public void test() {
        log.debug("debug => ");
        log.info("info => ");
        log.error("error => ");
    }
}
