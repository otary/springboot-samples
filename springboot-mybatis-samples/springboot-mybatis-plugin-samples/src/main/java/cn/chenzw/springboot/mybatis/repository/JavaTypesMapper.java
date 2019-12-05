package cn.chenzw.springboot.mybatis.repository;

import cn.chenzw.springboot.mybatis.domain.entity.JavaTypesEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenzw
 */
public interface JavaTypesMapper {

    List<JavaTypesEntity> listAll();

    int insertBatch(@Param("javaTypesEntities") List<JavaTypesEntity> javaTypesEntities);

    int insertBatch2(@Param("javaTypesEntities") JavaTypesEntity[] javaTypesEntities);

    List<JavaTypesEntity> listById(@Param("id") Integer id);

}
