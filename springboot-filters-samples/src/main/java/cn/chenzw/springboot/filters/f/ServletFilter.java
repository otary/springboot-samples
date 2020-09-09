package cn.chenzw.springboot.filters.f;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 使用 @WebFilter 和 @ServletComponentScan
 * @author chenzw
 */
@WebFilter(urlPatterns = {"/*"})
public class ServletFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ServletFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-------init--------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("---------ServletFilter-------------");

        chain.doFilter(request, response);
    }
}
