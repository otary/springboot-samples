package cn.chenzw.springboot.web.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebUtilsTests {

    @Autowired
    WebApplicationContext wac;


    /**
     * 获取临时目录
     */
    @Test
    public void testGetTempDir() {
        File tempDir = WebUtils.getTempDir(wac.getServletContext());

        log.info("TempDir => {}", tempDir);
    }

    /**
     * 相对于ServeltContext的路径
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testGetRealPath() throws FileNotFoundException {
        String realPath = WebUtils.getRealPath(wac.getServletContext(), "/test/xxx");

        log.info("RealPath => {}", realPath);
    }

    /**
     * 获取指定的cookie
     */
    @Test
    public void testGetCookie() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(
                new Cookie("uid", "12345"),
                new Cookie("uname", "zhangsan")
        );

        Cookie cookie = WebUtils.getCookie(request, "uid");
        log.info("Get uid cookie => {}", cookie);
    }

    /**
     * 判断是否可用的来源
     */
    @Test
    public void testIsVaildOrigin() {
        // 模拟一个请求
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Origin", "https://www.bqrdh.com");

        ServletServerHttpRequest servletServerHttpRequest = new ServletServerHttpRequest(request);

        // 指定可用来源列表
        boolean isValidOrigin = WebUtils.isValidOrigin(servletServerHttpRequest, Arrays.asList(
                "https://www.baidu.com",
                "https://www.bqrdh.com",
                "https://www.google.com"
        ));

        log.info("isValidOrigin => {}", isValidOrigin);
    }
}
