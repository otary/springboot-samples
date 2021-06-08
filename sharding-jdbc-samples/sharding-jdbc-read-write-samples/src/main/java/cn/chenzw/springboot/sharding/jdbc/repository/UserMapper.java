package cn.chenzw.springboot.sharding.jdbc.repository;

import cn.chenzw.springboot.sharding.jdbc.domain.entity.User;
import tk.mybatis.mapper.common.BaseMapper;
import cn.chenzw.springboot.sharding.jdbc.support.mybatis.TkMybatisRepository;

@TkMybatisRepository
public interface UserMapper extends BaseMapper<User> {


}
