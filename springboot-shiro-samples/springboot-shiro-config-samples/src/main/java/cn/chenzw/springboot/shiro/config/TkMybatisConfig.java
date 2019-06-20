package cn.chenzw.springboot.shiro.config;

import cn.chenzw.springboot.shiro.support.mybatis.TkMybatisRepository;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot.shiro"}, annotationClass = TkMybatisRepository.class)
public class TkMybatisConfig {


}
