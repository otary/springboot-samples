package cn.chenzw.springboot.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot.mybatis"})
public class MybatisConfig {


}
