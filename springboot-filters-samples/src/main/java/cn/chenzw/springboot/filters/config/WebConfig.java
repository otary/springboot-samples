package cn.chenzw.springboot.filters.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
@ComponentScan(basePackages = {"cn.chenzw.springboot.filters"})
public class WebConfig {

    /**
     * 客户端真实IP
     * @return
     */
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }


    /**
     * 用于监听HTTP请求事件
     * @return
     */
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

}
