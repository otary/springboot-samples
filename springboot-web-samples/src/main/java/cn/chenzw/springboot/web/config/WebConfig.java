package cn.chenzw.springboot.web.config;

import cn.chenzw.toolkit.spring.annotation.EnableToolkit;
import cn.chenzw.toolkit.spring.ratelimit.annotation.EnableRateLimit;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cn.chenzw.springboot.web"})
@EnableToolkit
@EnableRateLimit
public class WebConfig   {


    /*@Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return  multipartResolver;
    }*/
}
