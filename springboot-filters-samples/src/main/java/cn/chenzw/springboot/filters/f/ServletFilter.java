package cn.chenzw.springboot.filters.f;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(urlPatterns = {"/*"})
public class ServletFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ServletFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("---------ServletFilter-------------");

        chain.doFilter(request, response);
    }
}
