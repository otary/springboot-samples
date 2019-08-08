package cn.chenzw.springboot.mybatis.repository;

import cn.chenzw.springboot.mybatis.domain.entity.JavaTypesEntity;
import java.util.List;

/**
 * @author chenzw
 */
public interface JavaTypesMapper {

    List<JavaTypesEntity> listAll();

}
