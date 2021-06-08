package cn.chenzw.springboot.sharding.jdbc.config;

import cn.chenzw.springboot.sharding.jdbc.support.mybatis.TkMybatisRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import tk.mybatis.spring.annotation.MapperScan;


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
        // 初始化主数据源
        HikariDataSource ds1Ds = new HikariDataSource();
        ds1Ds.setJdbcUrl("jdbc:h2:mem:ds1");
        ds1Ds.setUsername("sa");
        ds1Ds.setPassword("");
        ResourceDatabasePopulator ds1DsPopulator = new
                ResourceDatabasePopulator(context.getResource("classpath:db/h2/ds1/schema.sql"),
                context.getResource("classpath:db/h2/ds1/data.sql"));
        DatabasePopulatorUtils.execute(ds1DsPopulator, ds1Ds);

        // 初始化从数据源
        HikariDataSource ds1slaveDs = new HikariDataSource();
        ds1slaveDs.setJdbcUrl("jdbc:h2:mem:ds1slave");
        ds1slaveDs.setUsername("sa");
        ds1slaveDs.setPassword("");
        ResourceDatabasePopulator ds1slaveDsPopulator = new
                ResourceDatabasePopulator(context.getResource("classpath:db/h2/ds1slave/schema.sql"));
        DatabasePopulatorUtils.execute(ds1slaveDsPopulator, ds1slaveDs);
    }


}
