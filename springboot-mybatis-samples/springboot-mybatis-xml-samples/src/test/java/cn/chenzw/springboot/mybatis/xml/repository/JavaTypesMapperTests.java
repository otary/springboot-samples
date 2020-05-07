package cn.chenzw.springboot.mybatis.xml.repository;

import cn.chenzw.springboot.mybatis.xml.MybatisXmlSamplesApp;
import cn.chenzw.springboot.mybatis.xml.domain.dto.JavaTypesEntityQueryDto;
import cn.chenzw.springboot.mybatis.xml.domain.entity.JavaTypesEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    JavaTypesMapper typesMapper;

    @Test
    public void testListAll() {
        JavaTypesEntityQueryDto javaTypesEntityQueryDto = new JavaTypesEntityQueryDto();
        //javaTypesEntityQueryDto.setIntegerType(1441);
        javaTypesEntityQueryDto.setVarcharType("这是");
        List<JavaTypesEntity> typesEntities = typesMapper.listAll(javaTypesEntityQueryDto);

        System.out.println(typesEntities);
        for (JavaTypesEntity typesEntiy : typesEntities) {
            Assert.assertNotNull(typesEntiy.getBooleanType());
        }

        Assert.assertFalse(typesEntities.isEmpty());
    }

    @Test
    public void testInsertBatch() {
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
    public void testInsertBatchOfArrary() {
        JavaTypesEntity[] typesEntities = new JavaTypesEntity[10000];

        for (int i = 0; i < 10000; i++) {
            typesEntities[i] = new JavaTypesEntity();
            typesEntities[i].setBooleanType(true);
            typesEntities[i].setByteType((byte) 1);
            typesEntities[i].setDateType(new Date());
            typesEntities[i].setDoubleType(1.5);
            typesEntities[i].setCharacterType((char) 1);
            typesEntities[i].setBigDecimalType(new BigDecimal(i));
            typesEntities[i].setFloatType(new Float(i + "." + i));
        }

        long t1 = System.currentTimeMillis();
        int count = typesMapper.insertBatchOfArrary(typesEntities);
        Assert.assertEquals(10000, count);

        logger.info("插入{}条数据耗时:{}ms", count, System.currentTimeMillis() - t1);
    }

    @Test
    public void testInsertBatch2() {
        List<JavaTypesEntity> typesEntities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            JavaTypesEntity javaTypesEntity = new JavaTypesEntity();
            javaTypesEntity.setByteType((byte) i);
            javaTypesEntity.setBooleanType(false);
            javaTypesEntity.setCharacterType((char) i);
            javaTypesEntity.setBigDecimalType(new BigDecimal(i));
            javaTypesEntity.setDoubleType(1.2);
            javaTypesEntity.setDateType(new Date());

            typesEntities.add(javaTypesEntity);
        }
        int count = typesMapper.insertBatch2(typesEntities);
        Assert.assertEquals(0, count);
    }

    @Test
    public void testDeleteBatch(){
        List<JavaTypesEntity> typesEntities = new ArrayList<>();

        JavaTypesEntity typesEntity = new JavaTypesEntity();
        typesEntity.setIntegerType(1637);
        typesEntities.add(typesEntity);

        JavaTypesEntity typesEntity2 = new JavaTypesEntity();
        typesEntity2.setIntegerType(123);
        typesEntities.add(typesEntity2);

        int count = typesMapper.deleteBatch(typesEntities);
        Assert.assertEquals(2, count);
    }

    @Test
    public void testDeleteBatch2() {
        List<JavaTypesEntity> typesEntities = new ArrayList<>();

        JavaTypesEntity typesEntity = new JavaTypesEntity();
        typesEntity.setIntegerType(1637);
        typesEntity.setLongType(125679L);
        typesEntities.add(typesEntity);

        JavaTypesEntity typesEntity2 = new JavaTypesEntity();
        typesEntity2.setIntegerType(123);
        typesEntity2.setLongType(123456789L);
        typesEntities.add(typesEntity2);

        int count = typesMapper.deleteBatch2(typesEntities);
        Assert.assertEquals(2, count);
    }

}
