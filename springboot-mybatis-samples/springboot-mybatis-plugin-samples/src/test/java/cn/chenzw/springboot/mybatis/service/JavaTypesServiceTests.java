package cn.chenzw.springboot.mybatis.service;

import cn.chenzw.springboot.mybatis.MybatisPluginSamplesApp;
import cn.chenzw.springboot.mybatis.domain.entity.JavaTypesEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.page.PageParams;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = MybatisPluginSamplesApp.class)
public class JavaTypesServiceTests {

    @Autowired
    JavaTypesService javaTypesService;

    @Test
    public void testListAll() {
        List<JavaTypesEntity> javaTypesEntities = javaTypesService.listAll();
        System.out.println(javaTypesEntities);
    }

    @Test
    public void testListAllByPage() {
        PageHelper.startPage(0, 1);
        List<JavaTypesEntity> javaTypesEntities = javaTypesService.listAll();
        Assert.assertTrue(javaTypesEntities.size() == 1);

        Page page2 = (Page) javaTypesEntities;
        Assert.assertEquals(page2.getTotal(), 4);
        Assert.assertEquals(page2.getPages(), 4);

        List<JavaTypesEntity> javaTypesEntities2 = page2.getResult();
        Assert.assertTrue(javaTypesEntities2.size() == 1);
    }


    @Test
    public void testInsertBatch() {
        List<JavaTypesEntity> javaTypesEntities = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            JavaTypesEntity javaTypesEntity = new JavaTypesEntity();
            javaTypesEntity.setByteType((byte) i);
            javaTypesEntity.setBooleanType(false);
            javaTypesEntity.setCharacterType((char) i);
            javaTypesEntity.setBigDecimalType(new BigDecimal(i));
            javaTypesEntity.setDoubleType(1.2);
            javaTypesEntity.setDateType(new Date());

            javaTypesEntities.add(javaTypesEntity);
        }

        javaTypesService.insertBatch(javaTypesEntities);
    }

    @Test
    public void testListById() {
        List<JavaTypesEntity> javaTypesEntities = javaTypesService.listById(1);
        System.out.println(javaTypesEntities);
    }


}
