package cn.chenzw.springboot.mybatis.xml.repository;

import cn.chenzw.springboot.mybatis.xml.domain.entity.JavaTypesEntity;

import java.util.List;

/**
 *
 * 默认不需要任何注解
 * @author chenzw
 */
public interface JavaTypesMapper {

    List<JavaTypesEntity> listAll();

}
