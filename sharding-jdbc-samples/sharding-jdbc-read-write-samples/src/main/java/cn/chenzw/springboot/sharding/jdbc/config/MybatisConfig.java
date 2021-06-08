package cn.chenzw.springboot.sharding.jdbc.config;

import cn.chenzw.springboot.sharding.jdbc.support.mybatis.TkMybatisRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @author chenzw
 */
@Configuration
@MapperScan(basePackages = {"cn.chenzw.springboot.sharding.jdbc"}, annotationClass = TkMybatisRepository.class)
public class MybatisConfig implements InitializingBean {

    @Autowired
    ApplicationContext context;

    @Override
    public void afterPropertiesSet() throws Exception {
        HikariDataSource ds1Ds = new HikariDataSource();
        ds1Ds.setJdbcUrl("jdbc:h2:mem:ds1");

        ResourceDatabasePopulator ds1DsPopulator = new
                ResourceDatabasePopulator(context.getResource("classpath:db/h2/data.sql"));
        DatabasePopulatorUtils.execute(ds1DsPopulator, ds1Ds);
    }
}
