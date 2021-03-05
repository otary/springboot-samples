package cn.chenzw.springboot.filters.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用GenericFilterBean才会接受Spring容器的管理
 */
@Slf4j
// @Component
public class OnceFilter extends OncePerRequestFilter {

    /**
     * spring-test无法注入,其它可以
     * <p>
     * 初始化顺序: context-param -> listener -> filter -> servlet（Filter在DispatcherServlet之前初始化）
     */
    @Autowired
    WebApplicationContext wac;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("OnceFilter wac => {}", wac);

        // 可以获取到WebApplicationContext对象
        WebApplicationContext webApp = RequestContextUtils.findWebApplicationContext(request);
        Assert.notNull(webApp, "WebApplicationContext为空,注入失败!");


        log.info("OnceFilter before => {}", request);

        filterChain.doFilter(request, response);

        log.info("OnceFilter after => {}", request);
    }
}
