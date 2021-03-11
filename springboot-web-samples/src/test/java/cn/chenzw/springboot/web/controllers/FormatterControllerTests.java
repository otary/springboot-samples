package cn.chenzw.springboot.web.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
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
public class FormatterControllerTests {

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
    public void testUserFormatter() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/formatter//users/99"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("{\"id\":99,\"name\":\"王五\",\"age\":\"20\"}")));
    }
}
