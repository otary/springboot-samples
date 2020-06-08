package cn.chenzw.springboot.security.cust.oauth2.server.config;

import cn.chenzw.springboot.security.cust.oauth2.server.support.mybatis.TkMybatisRepository;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot.security.cust.oauth2"}, annotationClass = TkMybatisRepository.class)
public class TkMybatisConfig {
    
}
