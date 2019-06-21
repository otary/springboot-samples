package cn.chenzw.springboot.tkmybatis.repository;

import cn.chenzw.springboot.tkmybatis.TkMybatisSamplesApp;
import cn.chenzw.springboot.tkmybatis.domain.entity.JavaTypesEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TkMybatisSamplesApp.class)
@WebAppConfiguration
public class JavaTypesMapperTests {

    @Autowired
    JavaTypesMapper javaTypesMapper;


    @Test
    public void testSelectAll(){
        List<JavaTypesEntity> javaTypesEntities = javaTypesMapper.selectAll();

        Assert.assertNotNull(javaTypesEntities);
    }



}
