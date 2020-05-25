package cn.chenzw.springboot.resource.message.controllers;

import cn.chenzw.springboot.resource.message.config.ResourceMessageSamplesApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ResourceMessageSamplesApp.class)
public class UserControllerTests {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetName() throws Exception {
        // 默认lang=zh_CN
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/name"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 返回张三
                .andExpect(MockMvcResultMatchers.content().string("张三"))
                .andReturn();
    }

    @Test
    public void testGetNameWithEn() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/name?lang=en_US"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 注入cookie
                .andExpect(MockMvcResultMatchers.cookie().value("lang", "en-US"))
                // 返回zhangsan
                .andExpect(MockMvcResultMatchers.content().string("zhangsan"))
                .andReturn();
    }

    @Test
    public void testGetNameWithZh() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/name?lang=zh_CN"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("张三"));
    }


    /**
     * cookie参数示例
     *
     * @throws Exception
     */
    @Test
    public void testGetNameWithCookieEn() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/name").cookie(new Cookie("lang", "en_US")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("zhangsan"));
    }


}
