package cn.chenzw.springboot.mybatisplus.repository;

import cn.chenzw.springboot.mybatisplus.domain.entity.User;
import cn.chenzw.toolkit.mybatis.core.support.MyBatisRepository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@MyBatisRepository
public interface UserMapper extends BaseMapper<User> {


}
