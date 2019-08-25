package cn.chenzw.springboot.datasources.oracle;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OracleSamplesApp.class)
@WebAppConfiguration
public class OracleSamplesTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSource() {
        Assert.assertNotNull(dataSource);
    }
}
