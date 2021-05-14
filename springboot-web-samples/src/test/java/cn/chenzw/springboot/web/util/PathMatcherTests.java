package cn.chenzw.springboot.web.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PathMatcherTests {

    @Test
    public void testAntPathMatcher() {
        String requestUrl = "/users/login";
        PathMatcher pathMatcher = new AntPathMatcher();
        boolean matched = pathMatcher.match("/users/**", requestUrl);

        Assert.assertTrue(matched);
    }
}
