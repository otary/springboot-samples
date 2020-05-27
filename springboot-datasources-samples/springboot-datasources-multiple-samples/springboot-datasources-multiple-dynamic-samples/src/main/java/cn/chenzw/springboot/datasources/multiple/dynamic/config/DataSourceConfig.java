package cn.chenzw.springboot.datasources.multiple.dynamic.config;

import cn.chenzw.toolkit.mybatis.core.support.TkMyBatisRepository;
import cn.chenzw.toolkit.mybatis.dynamic.annotation.EnableDynamicDataSource;
import cn.chenzw.toolkit.mybatis.dynamic.support.DynamicDataSourceContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * 开启动态数据源
 */
@EnableDynamicDataSource
@Configuration
@MapperScan(basePackages = {
        "cn.chenzw.springboot.datasources.multiple.dynamic"}, annotationClass = TkMyBatisRepository.class)

public class DataSourceConfig implements InitializingBean {


    @Autowired
    DataSource dataSource;

    @Override
    public void afterPropertiesSet() {
        ResourceDatabasePopulator populator = new
                ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db/schema.sql"));
        populator.addScript(new ClassPathResource("db/data.sql"));
        DatabasePopulatorUtils.execute(populator, DynamicDataSourceContext.getInstance().get("h2"));
    }
}
