package cn.chenzw.springboot.datasources.mysql;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlTests {


    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSource() {
        Assert.assertNotNull(dataSource);
    }
}
