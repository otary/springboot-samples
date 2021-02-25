package cn.chenzw.springboot.filters.config;

import cn.chenzw.springboot.filters.interceptors.MyHandlerInterceptor;
import cn.chenzw.springboot.filters.interceptors.SecondHandlerInterceptor;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"cn.chenzw.springboot.filters"})
public class WebConfig implements WebMvcConfigurer {

    /**
     * 客户端真实IP
     *
     * @return
     */
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }


    /**
     * 用于监听HTTP请求事件
     *
     * @return
     */
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }


    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 默认添加的顺序就是拦截器的执行顺序
        // 可以使用order()参数来调整执行顺序
        registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new SecondHandlerInterceptor()).addPathPatterns("/**").order(Ordered.HIGHEST_PRECEDENCE);
    }
}
