package cn.chenzw.springboot.mybatis.service;

import cn.chenzw.springboot.mybatis.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.repository.JavaTypesMapper;
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


}
