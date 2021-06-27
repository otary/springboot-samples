package cn.chenzw.springboot.web.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String ex = request.getParameter("ex");
        if ("test".equals(ex)) {
           throw new IllegalArgumentException("抛出异常!");
        }
        filterChain.doFilter(request, response);
    }
}
