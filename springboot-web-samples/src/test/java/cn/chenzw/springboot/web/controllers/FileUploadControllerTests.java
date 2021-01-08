package cn.chenzw.springboot.web.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileUploadControllerTests {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testUpload() throws Exception {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("a.txt");

        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "a.txt", "multipart/form-data", is);

        this.mockMvc.perform(multipart("/upload")
                .file(mockMultipartFile)
                .param("userName", "admin")
        ).andExpect(status().isOk());
    }


    @Test
    public void testMultipleUpload() throws Exception {
        InputStream is1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("a.txt");
        InputStream is2 = Thread.currentThread().getContextClassLoader().getResourceAsStream("b.txt");

        MockMultipartFile mockMultipartFile1 = new MockMultipartFile("file", "a.txt", "multipart/form-data", is1);
        MockMultipartFile mockMultipartFile2 = new MockMultipartFile("file", "b.txt", "multipart/form-data", is2);

        this.mockMvc.perform(multipart("/upload")
                .file(mockMultipartFile1)
                .file(mockMultipartFile2)
                .param("userName", "admin")
        ).andExpect(status().isOk());
    }
}
