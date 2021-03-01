package cn.chenzw.springboot.web.util;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestContextUtilsTests {


    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .build();
    }


    @Test
    public void testFindWebApplicationContext() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/context/findWebApplicationContext"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetLocaleResolver() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/context/getLocaleResolver"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetLocale() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/context/getLocale"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTimeZone() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/context/getTimeZone"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetThemeResolver() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/context/getThemeResolver"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTheme() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/context/getTheme"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetRequestAttributes() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/context/getRequestAttributes"))
                .andExpect(status().isOk());
    }

}
