package cn.chenzw.springboot.web.controllers;

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

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RateLimitControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testInfo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/ratelimit/info"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello")));


        // 抛出RateLimitException异常
        this.mockMvc.perform(MockMvcRequestBuilders.get("/ratelimit/info"))
                .andExpect(status().is5xxServerError())
                .andReturn();

    }

    @Test
    public void testInfo10() throws Exception {
        for (int i = 0; i < 20; i++) {
            long t1 = System.currentTimeMillis();
            this.mockMvc.perform(MockMvcRequestBuilders.get("/ratelimit/info-10"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(equalTo("hello")));
            Thread.sleep(200);

            System.out.println(System.currentTimeMillis() - t1);
        }

    }
}
