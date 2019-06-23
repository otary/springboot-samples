package cn.chenzw.springboot.mybatis.annotation.service;

import cn.chenzw.springboot.mybatis.annotation.MybatisAnnotationSamplesApp;
import cn.chenzw.springboot.mybatis.annotation.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.annotation.domain.enums.OSEnum;
import org.junit.Assert;
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
    public void testInsert() {
        JavaTypesEntity javaTypesEntity = new JavaTypesEntity();
        javaTypesEntity.setByteType((byte) 6);
        javaTypesEntity.setBooleanType(false);
        javaTypesEntity.setOsEnum(OSEnum.MAC);
        javaTypesService.insert(javaTypesEntity);

        JavaTypesEntity javaTypesEntity2 = javaTypesService.findBy((byte) 6);
        Assert.assertEquals(javaTypesEntity2.getBooleanType(), false);
        Assert.assertEquals(javaTypesEntity2.getOsEnum(), OSEnum.MAC);
    }

    @Test
    public void testListAll() {
        List<JavaTypesEntity> javaTypesEntities = javaTypesService.listAll();
        Assert.assertNotNull(javaTypesEntities);
    }

    @Test
    public void testFindBy() {
        JavaTypesEntity javaTypesEntity = javaTypesService.findBy((byte) 1);
        Assert.assertNotNull(javaTypesEntity);
    }

    @Test
    public void testUpdate() {
        JavaTypesEntity javaTypesEntity = new JavaTypesEntity();
        javaTypesEntity.setByteType((byte) 1);
        javaTypesEntity.setCharacterType('k');
        javaTypesService.update(javaTypesEntity);

        JavaTypesEntity javaTypesEntity2 = javaTypesService.findBy((byte) 1);
        Assert.assertEquals((char) javaTypesEntity2.getCharacterType(), 'k');
    }
}
