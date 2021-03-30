package cn.chenzw.springboot.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectProviderTests {

    /**
     * 使用ObjectProvider提供弹性注入
     */
    @Autowired
    ObjectProvider<HandlerInterceptor> handlerInterceptors;

    @Test
    public void testGetFirst() {
        HandlerInterceptor handlerInterceptor = handlerInterceptors.orderedStream().findFirst().orElse(null);

        log.info("获取第一个拦截器 => {}", handlerInterceptor);
    }
}
