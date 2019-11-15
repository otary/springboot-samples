package cn.chenzw.springboot.batch.basic.samples.config;

import cn.chenzw.springboot.batch.basic.samples.support.mybatis.TkMyBatisRepository;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = "cn.chenzw.springboot.batch.basic.samples.repository", annotationClass = TkMyBatisRepository.class)
public class MyBatisConfig {
}
