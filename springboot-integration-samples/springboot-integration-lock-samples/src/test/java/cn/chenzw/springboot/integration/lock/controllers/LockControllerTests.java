package cn.chenzw.springboot.integration.lock.controllers;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import redis.embedded.RedisServer;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LockControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private static RedisServer redisServer;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        redisServer = RedisServer.builder().port(6379).build();
        redisServer.start();
    }


    @Test
    public void getLock() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/lock/get"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
    }

    @AfterClass
    public static void afterClass() {
        redisServer.stop();
    }
}
