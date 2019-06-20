package cn.chenzw.springboot.tkmybatis.config;

import cn.chenzw.springboot.tkmybatis.support.mybatis.TkMybatisRepository;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author chenzw
 */
@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot.tkmybatis"}, annotationClass = TkMybatisRepository.class)
public class TkMybatisConfig {


}
