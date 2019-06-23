package cn.chenzw.springboot.container.jetty.config;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ServerConfig {

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(){
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        factory.setPort(8888);
        return factory;
    }
}
