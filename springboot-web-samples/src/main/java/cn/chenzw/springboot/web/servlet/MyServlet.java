package cn.chenzw.springboot.web.servlet;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * DispatchServlet请求演示
 */
@Slf4j
@WebServlet(urlPatterns = {"/my-servlet"})
public class MyServlet extends HttpServlet {

    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    List<HandlerAdapter> handlerAdapters;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        HandlerExecutionChain handlerExecutionChain =
                requestMappingHandlerMapping.getHandler(request);

        log.info("拦截器列表 => {}", Arrays.toString(handlerExecutionChain.getInterceptors()));

        HandlerAdapter handlerAdapter = getHandlerAdapter(handlerExecutionChain.getHandler());

        log.info("获取到HandlerAdapter => {}", handlerAdapter);

        ModelAndView modelAndView = handlerAdapter.handle(request, response, handlerExecutionChain.getHandler());

        log.info("获取到ModelAndView => {}", modelAndView);
    }


    private HandlerAdapter getHandlerAdapter(Object handler) {
        for (HandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.supports(handler)) {
                return handlerAdapter;
            }
        }
        return null;
    }
}
