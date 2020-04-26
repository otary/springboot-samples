package cn.chenzw.springboot.tkmybatis.repository;

import cn.chenzw.springboot.tkmybatis.TkMybatisSamplesApp;
import cn.chenzw.springboot.tkmybatis.domain.entity.JavaTypesEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public void testSelectAll() {
        List<JavaTypesEntity> javaTypesEntities = javaTypesMapper.selectAll();


        Assert.assertNotNull(javaTypesEntities);
    }

    /**
     * 分页查询示例
     */
    @Test
    public void testPageSelect() {
        PageHelper.startPage(1, 5);
        List<JavaTypesEntity> javaTypesEntities = javaTypesMapper.selectAll();
        Assert.assertEquals(5, javaTypesEntities.size());

        // 分页信息
        Page pageInfo = (Page)javaTypesEntities;
        Assert.assertEquals(12, pageInfo.getTotal());
        Assert.assertEquals(3, pageInfo.getPages());


        PageInfo<JavaTypesEntity> pageInfo2 = pageInfo.toPageInfo();
        System.out.println(pageInfo2);
    }


}
