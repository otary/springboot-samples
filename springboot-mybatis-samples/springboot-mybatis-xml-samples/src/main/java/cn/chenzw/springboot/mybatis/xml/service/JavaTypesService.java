package cn.chenzw.springboot.mybatis.xml.service;

import cn.chenzw.springboot.mybatis.xml.domain.dto.JavaTypesEntityQueryDto;
import cn.chenzw.springboot.mybatis.xml.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.xml.repository.JavaTypesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaTypesService {

    @Autowired
    JavaTypesMapper javaTypesMapper;

    public List<JavaTypesEntity> listAll(JavaTypesEntityQueryDto javaTypesEntityQueryDto) {
        return javaTypesMapper.listAll(javaTypesEntityQueryDto);
    }

    public int insertBatch(List<JavaTypesEntity> javaTypesEntities){
        return javaTypesMapper.insertBatch(javaTypesEntities);
    }
}
