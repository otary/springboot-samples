package cn.chenzw.springboot.tkmybatis.repository;

import cn.chenzw.springboot.tkmybatis.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.tkmybatis.support.mybatis.TkMybatisRepository;
import tk.mybatis.mapper.common.BaseMapper;

@TkMybatisRepository
public interface JavaTypesMapper extends BaseMapper<JavaTypesEntity> {
}
