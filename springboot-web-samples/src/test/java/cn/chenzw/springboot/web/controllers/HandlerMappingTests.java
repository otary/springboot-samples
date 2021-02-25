package cn.chenzw.springboot.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.HandlerMapping;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HandlerMappingTests {

    @Autowired
    List<HandlerMapping> handlerMappings;


    @Test
    public void testGetAllHandlerMappings() {
        log.info("handlerMappings => {}", handlerMappings);

        // => org.springframework.web.servlet.handler.SimpleUrlHandlerMapping
        // => springfox.documentation.spring.web.PropertySourcedRequestMappingHandlerMapping
        // => org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
        // => org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping
        // => org.springframework.web.servlet.handler.SimpleUrlHandlerMapping
        // => org.springframework.boot.autoconfigure.web.servlet.WelcomePageHandlerMapping

        for (HandlerMapping handlerMapping : handlerMappings) {
            log.info(" => {}", handlerMapping);
        }
    }
}
