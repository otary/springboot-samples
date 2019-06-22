package cn.chenzw.springboot.jpa.repository;

import cn.chenzw.springboot.jpa.JpaSamplesApp;
import cn.chenzw.springboot.jpa.domain.entity.SysPermission;
import cn.chenzw.springboot.jpa.domain.entity.SysRole;
import cn.chenzw.springboot.jpa.domain.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaSamplesApp.class)
@WebAppConfiguration
public class SysUserRepositoryTests {

    @Autowired
    SysUserRepository sysUserRepository;

    @Autowired
    SysRoleRepository sysRoleRepository;

    @Test
    public void testFindByUserName() {
        SysUser sysUser = sysUserRepository.findByUsername("admin");
        Assert.assertNotNull(sysUser);

        List<SysRole> roles = sysUser.getRoles();
        Assert.assertNotNull(roles);
        for (SysRole role : roles) {
            List<SysPermission> permissions = role.getPermissions();
            Assert.assertNotNull(permissions);
        }
    }

    @Test
    public void testFindById() {
        Optional<SysUser> sysUser = sysUserRepository.findById(1L);
        Assert.assertNotNull(sysUser.get());
    }
}
