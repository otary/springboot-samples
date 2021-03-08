package cn.chenzw.springboot.web.controllers;

import cn.chenzw.springboot.web.domain.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Base64;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HandlerMethodArgumentResolverTests {

    private ObjectMapper objectMapper = new ObjectMapper();

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
        /*Field field = DispatcherServlet.class.getDeclaredField("handlerAdapters");
        field.setAccessible(true);
        Object handlerAdapters = field.get(dispatcherServlet);

        System.out.println(handlerAdapters);*/
        //log.info("获取所有HandlerMethodArgumentResolver => {}", handlerMethodArgumentResolvers);
    }

    /**
     * 自定义数组参数解析器
     *
     * @throws Exception
     */
    @Test
    public void testArrayArgResolver() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/method-argument-resolver/array-parameter?ids=1&ids=2"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testBase64ArgResolver() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setAge("10");
        userDto.setName("张三");

        String base64Str = Base64.getEncoder().encodeToString(objectMapper.writeValueAsString(userDto).getBytes());

        log.info("Base64 => {}", base64Str);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/method-argument-resolver/base64-body")
                .content(base64Str)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print());

    }


}
