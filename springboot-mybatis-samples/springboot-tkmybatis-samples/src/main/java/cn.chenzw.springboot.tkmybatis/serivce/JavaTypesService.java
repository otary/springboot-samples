package cn.chenzw.springboot.tkmybatis.serivce;

import cn.chenzw.springboot.tkmybatis.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.tkmybatis.repository.JavaTypesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class JavaTypesService {

    @Autowired
    JavaTypesMapper javaTypesMapper;


    public List<JavaTypesEntity> selectByExample() {
        Example example = new Example(JavaTypesEntity.class);
        // 排序
        example.setOrderByClause("long_type desc");
        // 大小范围
        example.createCriteria().andGreaterThan("integerType", "1000").andLessThan("integerType", "5000");
        return javaTypesMapper.selectByExample(example);
    }

}
