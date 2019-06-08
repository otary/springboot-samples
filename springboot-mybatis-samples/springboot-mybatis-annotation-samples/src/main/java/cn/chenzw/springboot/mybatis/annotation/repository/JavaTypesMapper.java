package cn.chenzw.springboot.mybatis.annotation.repository;


import cn.chenzw.springboot.mybatis.annotation.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.annotation.repository.provider.JavaTypesProvider;
import cn.chenzw.springboot.mybatis.annotation.support.MyBatisRepository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 *
 * 默认不需要任何注解
 * @author chenzw
 */
@MyBatisRepository
public interface JavaTypesMapper {

    @Select("select * from java_types_entity")
    List<JavaTypesEntity> listAll();


    @SelectProvider(type = JavaTypesProvider.class, method = "findById")
    JavaTypesEntity findOne(@Param("id") Long id);

}
