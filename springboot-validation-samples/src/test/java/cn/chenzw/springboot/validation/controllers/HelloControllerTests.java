package cn.chenzw.springboot.validation.controllers;

import cn.chenzw.springboot.validation.ValidationSamplesApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import javax.validation.ConstraintViolationException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ValidationSamplesApp.class})
@WebAppConfiguration
public class HelloControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test(expected = NestedServletException.class)
    public void testSay() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello/say"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testSay2(){

    }
}
