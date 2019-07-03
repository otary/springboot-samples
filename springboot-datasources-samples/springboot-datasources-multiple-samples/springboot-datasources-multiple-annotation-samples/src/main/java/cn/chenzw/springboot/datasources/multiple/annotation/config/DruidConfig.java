package cn.chenzw.springboot.datasources.multiple.annotation.config;

import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DynamicDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    public static final String H2_DATASOURCE_NAME = "h2";
    public static final String MYSQL_DATASOURCE_NAME = "mysql";


    @Bean
    @ConfigurationProperties("spring.datasource.druid.h2")
    public DataSource h2DataSource() {
        DataSource ds = DruidDataSourceBuilder.create().build();

        ResourceDatabasePopulator populator = new
                ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("classpath:/data.sql"));
        populator.addScript(new ClassPathResource("classpath:/schema.sql"));

        DatabasePopulatorUtils.execute(populator, ds);
        return  ds;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(h2DataSource());

        // 多数据源列表
        Map<Object, Object> dsMap = new HashMap<>(5);
        dsMap.put(H2_DATASOURCE_NAME, h2DataSource());
        dsMap.put(MYSQL_DATASOURCE_NAME, mysqlDataSource());
        dynamicDataSource.setTargetDataSources(dsMap);


        return dynamicDataSource;
    }


    /**
     * 配置事务管理器
     * @return
     */
    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * 配置session工厂
     * @return
     * @throws Exception
     */
    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/**/*.xml"));
        return bean.getObject();
    }


}
