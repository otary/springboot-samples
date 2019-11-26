package cn.chenzw.springboot.mybatis.xml.repository;

import cn.chenzw.springboot.mybatis.xml.MybatisXmlSamplesApp;
import cn.chenzw.springboot.mybatis.xml.domain.entity.JavaTypesEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MybatisXmlSamplesApp.class})
@WebAppConfiguration
public class JavaTypesMapperTests {

    @Autowired
    JavaTypesMapper typesMapper;

    @Test
    public void testListAll() {
        List<JavaTypesEntity> typesEntities = typesMapper.listAll();

        for (JavaTypesEntity typesEntiy : typesEntities) {
            Assert.assertNotNull(typesEntiy.getBooleanType());
        }

        Assert.assertFalse(typesEntities.isEmpty());
    }

    @Test
    public void testInsertBatch(){
        List<JavaTypesEntity> typesEntities = new ArrayList<>();

        /*for (int i = 0; i < 10 ; i++) {
            JavaTypesEntity javaTypesEntity = new JavaTypesEntity();
            javaTypesEntity.setByteType((byte) i);
            javaTypesEntity.setBooleanType(false);
            javaTypesEntity.setCharacterType((char)i);
            javaTypesEntity.setBigDecimalType(new BigDecimal(i));
            javaTypesEntity.setDoubleType(1.2);
            javaTypesEntity.setDateType(new Date());

            typesEntities.add(javaTypesEntity);
        }*/

        int count = typesMapper.insertBatch(typesEntities);
        Assert.assertEquals(0, count);

    }

    @Test
    public void testInsertBatch2(){
        JavaTypesEntity[] typesEntities = new JavaTypesEntity[0];

        int count = typesMapper.insertBatch2(typesEntities);
        Assert.assertEquals(0, count);
    }


}
