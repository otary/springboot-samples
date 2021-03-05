package cn.chenzw.springboot.filters.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 使用 @WebFilter 和 @ServletComponentScan
 *
 * @author chenzw
 */
@Slf4j
@WebFilter(urlPatterns = {"/*"})
public class ServletFilter implements Filter {

    /**
     * spring-test无法注入，其它可以
     * <p>
     * 初始化顺序: context-param -> listener -> filter -> servlet
     */
    @Autowired
    WebApplicationContext wac;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Filter init => {}", filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("ServletFilter wac => {}", wac);

        // 可以获取到WebApplicationContext对象
        WebApplicationContext webApp = RequestContextUtils.findWebApplicationContext((HttpServletRequest) request);
        Assert.notNull(webApp, "WebApplicationContext为空,注入失败!");

        log.info("Filter doFilter before => {}", request);

        chain.doFilter(request, response);

        log.info("Filter doFilter after => {}", request);
    }
}
