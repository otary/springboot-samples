package cn.chenzw.springboot.scope.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalControllerTests {


    MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testPrint() throws Exception {
        for (int i = 0; i < 10; i++) {
            mockMvc.perform(get("/portal/print"))
                    .andExpect(status().isOk());
        }
    }

    @Test
    public void testPrint2() throws Exception {
        for (int i = 0; i < 10; i++) {
            mockMvc.perform(get("/portal/print2"))
                    .andExpect(status().isOk());
        }
    }

}
