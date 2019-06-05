package cn.chenzw.springboot.mybatis.xml.repository;

import cn.chenzw.springboot.mybatis.xml.domain.entity.JavaTypesEntity;

import java.util.List;

public interface JavaTypesMapper {

    List<JavaTypesEntity> listAll();

}
