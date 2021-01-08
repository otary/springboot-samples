package cn.chenzw.springboot.ehcache.controllers;

import cn.chenzw.springboot.ehcache.domain.entity.SysUser;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserControllerTests {

    MockMvc mockMvc;
    @Autowired
    WebApplicationContext wac;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void test() throws Exception {
        testListCaches();

        testSaveUser();

        // 保存后，有了缓存
        testListCaches();

        testDelUser();

        // 删除后，无缓存
        testListCaches();
    }

    /**
     * 多次查询，数据库只会查询一次
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        // testListCaches();

        testFind();

        //   testListCaches();

        testFind();
    }

    @Test
    public void testListCaches() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/caches/list"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testSaveUser() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        sysUser.setName("张三");
        sysUser.setPassword("123456");
        sysUser.setUsername("zhangsan");
        sysUser.setSalt("##");
        sysUser.setState((byte) 1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(sysUser)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDelUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/user/del/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testFind() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
