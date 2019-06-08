package cn.chenzw.springboot.mybatis.annotation.service;

import cn.chenzw.springboot.mybatis.annotation.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.annotation.repository.JavaTypesMapper;
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

    public JavaTypesEntity findOne(Long id) {
        return javaTypesMapper.findOne(id);
    }
}
