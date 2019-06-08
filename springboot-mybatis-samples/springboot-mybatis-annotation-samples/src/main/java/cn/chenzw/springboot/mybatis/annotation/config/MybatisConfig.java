package cn.chenzw.springboot.mybatis.annotation.config;

import cn.chenzw.springboot.mybatis.annotation.support.MyBatisRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot.mybatis.annotation"}, annotationClass = MyBatisRepository.class)
public class MybatisConfig {
}
