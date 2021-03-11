package cn.chenzw.springboot.web.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestWebControllerTests {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Autowired
    List<ApplicationContext> contextList;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .build();
    }

    @Test
    public void testHello() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello!")));
    }

    @Test
    public void testArrayQuery() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/arrayQuery?ids=1&ids=2"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    /**
     * POST 数组参数
     *
     * @throws Exception
     */
    @Test
    public void testPostArrayPojoQuery() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/rest/postArrayPojoQuery")
                .content("[{\"name\":\"zhangsan\",\"age\":12},{\"name\":\"lisi\",\"age\":23}]")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

    /**
     * POST Map参数
     *
     * @throws Exception
     */
    @Test
    public void testPostMapQuery() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/rest/postMapQuery")
                .content("{\"xxx\":\"111\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testPostHello() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/rest/hello")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"userName\":\"张三\",\"age\":20}"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello, 张三")));
    }

    @Test
    public void testPostHelloXml() throws Exception {
        // 需要再添加一个支持XML的解析器HttpMessageConverter
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/arrayQuery?ids=1&ids=2&name=xxx")
                .header("Accept", "application/xml"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    /**
     * UrlPathUtils工具类
     *
     * @throws Exception
     */
    @Test
    public void testUrlPathUtils() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/url-path-utils?a=1&b=2"))
                .andExpect(status().isOk())
                .andDo(print());
    }


    /**
     * 抛出异常
     *
     * @throws Exception
     */
    @Test
    public void testThrowException() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest/throw-exception"))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void testGetUserInfo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/rest//users/99"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("{\"id\":99,\"name\":\"王五\",\"age\":\"20\"}")));
    }
}
