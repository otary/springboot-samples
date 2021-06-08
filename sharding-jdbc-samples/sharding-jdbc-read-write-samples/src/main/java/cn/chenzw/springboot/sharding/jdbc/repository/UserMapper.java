package cn.chenzw.springboot.sharding.jdbc.repository;

import cn.chenzw.springboot.sharding.jdbc.domain.entity.User;
import cn.chenzw.toolkit.mybatis.core.support.TkMyBatisRepository;
import tk.mybatis.mapper.common.BaseMapper;

@TkMyBatisRepository
public interface UserMapper extends BaseMapper<User> {


}
