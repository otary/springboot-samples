package cn.chenzw.springboot.web.beans;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BindTests {


    @Autowired
    WebApplicationContext wac;

    @Test
    public void test() {
        Environment environment = wac.getEnvironment();
        Binder binder = Binder.get(environment);

        Map map = binder.bind("", Map.class).get();
        log.info(" => {}", map);
    }
}
