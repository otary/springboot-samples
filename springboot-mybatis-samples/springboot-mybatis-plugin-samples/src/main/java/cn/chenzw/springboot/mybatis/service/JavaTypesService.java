package cn.chenzw.springboot.mybatis.service;

import cn.chenzw.springboot.mybatis.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.repository.JavaTypesMapper;
import cn.chenzw.springboot.mybatis.support.mybatis.plugin.PageParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaTypesService {

    @Autowired
    JavaTypesMapper javaTypesMapper;

    public List<JavaTypesEntity> listAll() {
        return javaTypesMapper.listAll();
    }

    public int insertBatch(@Param("javaTypesEntities") List<JavaTypesEntity> javaTypesEntities) {
        return javaTypesMapper.insertBatch(javaTypesEntities);
    }

    public int insertBatch2(@Param("javaTypesEntities") JavaTypesEntity[] javaTypesEntities) {
        return javaTypesMapper.insertBatch2(javaTypesEntities);
    }


    public List<JavaTypesEntity> listById(Integer id) {
        return javaTypesMapper.listById(id, new PageParam(1, 25));
    }

}
