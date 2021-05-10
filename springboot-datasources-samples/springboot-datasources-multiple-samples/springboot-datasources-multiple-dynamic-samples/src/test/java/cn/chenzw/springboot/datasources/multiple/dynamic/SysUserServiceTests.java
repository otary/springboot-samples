package cn.chenzw.springboot.datasources.multiple.dynamic;


import cn.chenzw.springboot.datasources.multiple.dynamic.domain.entity.SysUser;
import cn.chenzw.springboot.datasources.multiple.dynamic.repository.SysUserH2Mapper;
import cn.chenzw.springboot.datasources.multiple.dynamic.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTests {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysUserH2Mapper sysUserH2Mapper;

    @Test
    public void testListAll() {
        List<SysUser> sysUsers = sysUserH2Mapper.selectAll();
        Assert.assertTrue(sysUsers.size() > 0);
    }

    @Test
    public void testListH2All() {
        List<SysUser> sysUsers = sysUserService.listH2All();

        log.info("sysUsers => {}", sysUsers);
    }

    @Test
    public void testListMySqlAll() {
        List<SysUser> sysUsers = sysUserService.listMySqlAll();

        log.info("sysUsers => {}", sysUsers);
    }

    @Test
    public void testListMySqlAll2() {
        List<SysUser> sysUsers = sysUserService.listMySqlAll2();

        log.info("sysUsers => {}", sysUsers);
    }


}
