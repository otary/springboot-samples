package cn.chenzw.springboot.mybatis.xml.repository;

import cn.chenzw.springboot.mybatis.xml.domain.entity.JavaTypesEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 默认不需要任何注解
 *
 * @author chenzw
 */
public interface JavaTypesMapper {

    List<JavaTypesEntity> listAll();

    /**
     * 批量插入示例
     *
     * @param javaTypesEntities
     * @return
     */
    int insertBatch(@Param("javaTypesEntities") List<JavaTypesEntity> javaTypesEntities);

}
