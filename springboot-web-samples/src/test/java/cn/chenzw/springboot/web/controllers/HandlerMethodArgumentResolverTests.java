package cn.chenzw.springboot.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.lang.reflect.Field;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HandlerMethodArgumentResolverTests {

    @Autowired
    DispatcherServlet dispatcherServlet;


    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .build();
    }

    @Test
    public void testGetAllHandlerMethodArgumentResolver() throws NoSuchFieldException, IllegalAccessException {
        Field field = DispatcherServlet.class.getDeclaredField("handlerAdapters");
        field.setAccessible(true);
        Object handlerAdapters = field.get(dispatcherServlet);

        System.out.println(handlerAdapters);
        //log.info("获取所有HandlerMethodArgumentResolver => {}", handlerMethodArgumentResolvers);
    }

    /**
     * 自定义参数解析器测试
     *
     * @throws Exception
     */
    @Test
    public void testCustArgResolver() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/cust-arg-resolver?ids=1&ids=2"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
