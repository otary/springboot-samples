package cn.chenzw.springboot.datasources.multiple.annotation.service;

import cn.chenzw.springboot.datasources.multiple.annotation.MultipleDatasourceAnnotationSamplesApp;
import cn.chenzw.springboot.datasources.multiple.annotation.domain.entity.SysUser;
import cn.chenzw.springboot.datasources.multiple.annotation.repository.SysUserH2Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MultipleDatasourceAnnotationSamplesApp.class)
@WebAppConfiguration
public class SysUserServiceTests {


    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysUserH2Mapper sysUserH2Mapper;

    @Test
    public void testListAll() {
        List<SysUser> sysUsers = sysUserH2Mapper.selectAll();
        Assert.assertTrue(sysUsers.size() > 0);

        System.out.println(sysUsers);
    }

    @Test
    public void testListH2All() {
        List<SysUser> sysUsers = sysUserService.listH2All();
        System.out.println(sysUsers);
    }

    @Test
    public void testListMySqlAll() {
        List<SysUser> sysUsers = sysUserService.listMySqlAll();
        System.out.println(sysUsers);
    }

    @Test
    public void testListMySqlAll2(){
        List<SysUser> sysUsers = sysUserService.listMySqlAll2();
        System.out.println(sysUsers);
    }


}
