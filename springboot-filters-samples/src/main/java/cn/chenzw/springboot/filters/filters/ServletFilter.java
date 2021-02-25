package cn.chenzw.springboot.filters.filters;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 使用 @WebFilter 和 @ServletComponentScan
 * @author chenzw
 */
@Slf4j
@WebFilter(urlPatterns = {"/*"})
public class ServletFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ServletFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Filter init => {}", filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Filter doFilter before => {}", request);

        chain.doFilter(request, response);

        log.info("Filter doFilter after => {}", request);
    }
}
