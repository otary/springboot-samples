package cn.chenzw.springboot.mybatis.annotation.service;

import cn.chenzw.springboot.mybatis.annotation.MybatisAnnotationSamplesApp;
import cn.chenzw.springboot.mybatis.annotation.domain.entity.JavaTypesEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MybatisAnnotationSamplesApp.class})
@WebAppConfiguration
public class JavaTypesServiceTests {

    @Autowired
    JavaTypesService javaTypesService;

    @Test
    public void testListAll(){
        List<JavaTypesEntity> javaTypesEntities = javaTypesService.listAll();
        System.out.println(javaTypesEntities);
    }

    @Test
    public void testFindOne(){
        JavaTypesEntity javaTypesEntity = javaTypesService.findOne(1L);
        System.out.println(javaTypesEntity);
    }
}
