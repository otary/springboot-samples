package cn.chenzw.springboot.datasources.multiple.dynamic.config;

import cn.chenzw.toolkit.mybatis.core.support.TkMyBatisRepository;
import cn.chenzw.toolkit.mybatis.dynamic.annotation.EnableDynamicDataSource;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 开启动态数据源
 */
@EnableDynamicDataSource
@Configuration
@MapperScan(basePackages = {
        "cn.chenzw.springboot.datasources.multiple.dynamic"}, annotationClass = TkMyBatisRepository.class)
public class DataSourceConfig {


}
