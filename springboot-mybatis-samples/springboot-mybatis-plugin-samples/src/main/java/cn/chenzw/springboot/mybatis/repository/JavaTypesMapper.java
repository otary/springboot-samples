package cn.chenzw.springboot.mybatis.repository;

import cn.chenzw.springboot.mybatis.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.support.mybatis.plugin.Pageable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenzw
 */
public interface JavaTypesMapper extends BaseMapper<JavaTypesEntity> {

    List<JavaTypesEntity> listAll();

    int insertBatch(@Param("javaTypesEntities") List<JavaTypesEntity> javaTypesEntities);

    int insertBatch2(@Param("javaTypesEntities") JavaTypesEntity[] javaTypesEntities);

    List<JavaTypesEntity> listById(@Param("id") Integer id, Pageable pageable);

}
