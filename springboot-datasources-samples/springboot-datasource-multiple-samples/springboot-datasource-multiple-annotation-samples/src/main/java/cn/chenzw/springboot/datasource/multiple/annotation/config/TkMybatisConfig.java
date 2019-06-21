package cn.chenzw.springboot.datasource.multiple.annotation.config;

import cn.chenzw.springboot.datasource.multiple.annotation.support.mybatis.TkMybatisRepository;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = {
        "cn.chenzw.springboot.datasource.multiple.annotation"}, annotationClass = TkMybatisRepository.class)
public class TkMybatisConfig {


}
