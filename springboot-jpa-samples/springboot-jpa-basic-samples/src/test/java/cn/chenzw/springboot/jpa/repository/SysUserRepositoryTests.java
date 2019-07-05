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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Test
    public void testFindByName() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<SysUser> page = sysUserRepository.findByName("管理员", pageable, new Sort(Sort.Direction.ASC, "name"));

        Assert.assertTrue(page.getTotalPages() > 0);
        Assert.assertTrue(page.getTotalElements() > 0);
        Assert.assertNotNull(page.getContent());
    }


    @Test
    public void testDeleteById() {
        sysUserRepository.deleteById(1L);
    }

    @Test
    public void testModifyById() {
        sysUserRepository.modifyById("张三", 1L);

        SysUser sysUser = sysUserRepository.findById(1L).get();
        Assert.assertEquals(sysUser.getName(), "张三");

    }
}
