package cn.chenzw.springboot.mybatis.xml.repository;

import cn.chenzw.springboot.mybatis.xml.domain.dto.JavaTypesEntityQueryDto;
import cn.chenzw.springboot.mybatis.xml.domain.entity.JavaTypesEntity;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 默认不需要任何注解
 *
 * @author chenzw
 */
public interface JavaTypesMapper {

    List<JavaTypesEntity> listAll(@Param("javaTypesEntityQueryDto") JavaTypesEntityQueryDto javaTypesEntityQueryDto);

    /**
     * 批量插入示例（列表）
     * mysql
     *
     * @param javaTypesEntities
     * @return
     */
    int insertBatch(@Param("javaTypesEntities") List<JavaTypesEntity> javaTypesEntities);


    /**
     * 批量插入（数组）
     *
     * @param javaTypesEntities
     * @return
     */
    int insertBatchOfArrary(@Param("javaTypesEntities") JavaTypesEntity[] javaTypesEntities);


    /**
     * 批量插入（insert into ... select ）
     * oracle
     *
     * @param javaTypesEntities
     * @return
     */
    int insertBatch2(@Param("javaTypesEntities") List<JavaTypesEntity> javaTypesEntities);


    /**
     * 灵活的字段插入
     *
     * @param javaTypesEntity
     * @return
     */
    int insert3(@Param("javaTypesEntity") JavaTypesEntity javaTypesEntity);


    /**
     * 批量删除（单字段）
     *
     * @param javaTypesEntities
     * @return
     */
    int deleteBatch(@Param("javaTypesEntity") List<JavaTypesEntity> javaTypesEntities);

    /**
     * 批量删除（多字段）
     *
     * @param javaTypesEntities
     */
    int deleteBatch2(@Param("javaTypesEntity") List<JavaTypesEntity> javaTypesEntities);

    /**
     * 返回Map示例(相同的值会被覆盖)
     *
     * @return
     */
    @MapKey("varcharType")
    Map<String, JavaTypesEntity> getMap();

    /**
     * 返回Map List示例
     *
     * @return
     */
    @MapKey("varcharType")
    Map<String, List<JavaTypesEntity>> getMapList();
}
