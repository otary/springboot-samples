package cn.chenzw.springboot.mybatis.service;

import cn.chenzw.springboot.mybatis.MybatisPluginSamplesApp;
import cn.chenzw.springboot.mybatis.config.MybatisConfig;
import cn.chenzw.springboot.mybatis.domain.entity.JavaTypesEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = MybatisPluginSamplesApp.class)
public class JavaTypesServiceTests {

    @Autowired
    JavaTypesService javaTypesService;

    @Test
    public void testListAll(){
        List<JavaTypesEntity> javaTypesEntities = javaTypesService.listAll();
        System.out.println(javaTypesEntities);
    }


}
