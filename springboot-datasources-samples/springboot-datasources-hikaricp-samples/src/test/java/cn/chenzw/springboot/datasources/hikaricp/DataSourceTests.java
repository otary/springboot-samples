package cn.chenzw.springboot.datasources.hikaricp;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTests {


    @Test
    public void test() throws SQLException {
        HikariConfig configuration = new HikariConfig();

        HikariDataSource hikariDataSource = new HikariDataSource(configuration);

        hikariDataSource.getConnection();
    }
}
