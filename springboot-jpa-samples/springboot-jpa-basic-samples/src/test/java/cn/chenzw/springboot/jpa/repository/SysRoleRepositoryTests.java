package cn.chenzw.springboot.jpa.repository;

import cn.chenzw.springboot.jpa.JpaSamplesApp;
import cn.chenzw.springboot.jpa.domain.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaSamplesApp.class)
@WebAppConfiguration
public class SysRoleRepositoryTests {

    @Autowired
    SysRoleRepository sysRoleRepository;

    @Test
    public void testFindUser() {
        List<SysUser> sysUsers = sysRoleRepository.findUser(1L);

        System.out.println(sysUsers);

    }
}
