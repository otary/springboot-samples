package cn.chenzw.springboot.security.basic.config;

import cn.chenzw.springboot.security.basic.support.mybatis.TkMybatisRepository;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot.security.basic"}, annotationClass = TkMybatisRepository.class)
public class TkMybatisConfig {
    
}
