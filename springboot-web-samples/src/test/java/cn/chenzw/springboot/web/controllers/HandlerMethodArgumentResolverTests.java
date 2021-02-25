package cn.chenzw.springboot.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HandlerMethodArgumentResolverTests {

    @Autowired
    List<HandlerMethodArgumentResolver> handlerMethodArgumentResolvers;

    @Test
    public void testGetAllHandlerMethodArgumentResolver() {
        log.info("获取所有HandlerMethodArgumentResolver => {}", handlerMethodArgumentResolvers);
    }
}
