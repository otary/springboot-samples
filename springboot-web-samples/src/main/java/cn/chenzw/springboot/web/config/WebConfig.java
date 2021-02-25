package cn.chenzw.springboot.web.config;

import cn.chenzw.springboot.web.resolver.handler.ArrayHandlerMethodArgumentResolver;
import cn.chenzw.toolkit.spring.annotation.EnableToolkit;
import cn.chenzw.toolkit.spring.ratelimit.annotation.EnableRateLimit;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
//@EnableWebMvc
@EnableToolkit
@EnableRateLimit
public class WebConfig implements WebMvcConfigurer {


    /*@Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return  multipartResolver;
    }*/

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ArrayHandlerMethodArgumentResolver());
    }

}
