package cn.chenzw.springboot.security.jwt.config;

import cn.chenzw.springboot.security.jwt.support.mybatis.TkMybatisRepository;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot.security.jwt"}, annotationClass = TkMybatisRepository.class)
public class TkMybatisConfig {


}
