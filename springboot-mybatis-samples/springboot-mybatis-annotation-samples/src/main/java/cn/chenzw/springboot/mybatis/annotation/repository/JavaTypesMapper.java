package cn.chenzw.springboot.mybatis.annotation.repository;


import cn.chenzw.springboot.mybatis.annotation.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.annotation.domain.enums.OSEnum;
import cn.chenzw.springboot.mybatis.annotation.repository.provider.JavaTypesProvider;
import cn.chenzw.springboot.mybatis.annotation.support.MyBatisRepository;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 默认不需要任何注解
 *
 * @author chenzw
 */
@MyBatisRepository
public interface JavaTypesMapper {

    @Select("select * from java_types_entity")
    @Results({
            @Result(property = "osEnum", column = "os_enum", javaType = OSEnum.class)
    })
    List<JavaTypesEntity> listAll();


    @SelectProvider(type = JavaTypesProvider.class, method = "findBy")
    JavaTypesEntity findBy(@Param("byteType") byte byteType);


    @Insert("INSERT INTO java_types_entity(byte_type, character_type, integer_type, float_type, long_type, double_type, bytes_type, bigdecimal_type, boolean_type, date_type, os_enum) VALUES(#{javaTypesEntity.byteType}, #{javaTypesEntity.characterType}, #{javaTypesEntity.integerType}, #{javaTypesEntity.floatType}, #{javaTypesEntity.longType}, #{javaTypesEntity.doubleType}, #{javaTypesEntity.bytesType}, #{javaTypesEntity.bigDecimalType}, #{javaTypesEntity.booleanType}, #{javaTypesEntity.dateType}, #{javaTypesEntity.osEnum})")
    void insert(@Param("javaTypesEntity") JavaTypesEntity javaTypesEntity);

    @Update("UPDATE java_types_entity SET character_type = #{javaTypesEntity.characterType} WHERE byte_type =#{javaTypesEntity.byteType}")
    void update(@Param("javaTypesEntity") JavaTypesEntity javaTypesEntity);

    @Delete("DELETE FROM java_types_entity WHERE byte_type =#{byteType}")
    void delete(@Param("byteType") byte byteType);

}
