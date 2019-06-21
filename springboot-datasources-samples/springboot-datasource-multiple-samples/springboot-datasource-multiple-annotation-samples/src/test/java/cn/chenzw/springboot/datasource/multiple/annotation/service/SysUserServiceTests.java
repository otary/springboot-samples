package cn.chenzw.springboot.datasource.multiple.annotation.service;

import cn.chenzw.springboot.datasource.multiple.annotation.MultipleDatasourceAnnotationSamplesApp;
import cn.chenzw.springboot.datasource.multiple.annotation.domain.entity.SysUser;
import cn.chenzw.springboot.datasource.multiple.annotation.repository.SysUserMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MultipleDatasourceAnnotationSamplesApp.class)
@WebAppConfiguration
public class SysUserServiceTests {

    @Autowired
    SysUserMapper sysUserMapper;


    @Test
    public void testListAll(){
        List<SysUser> sysUsers = sysUserMapper.selectAll();
        System.out.println(sysUsers);
    }

}
