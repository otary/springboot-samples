package cn.chenzw.springboot.web.repository;

import cn.chenzw.springboot.web.domain.dto.UserDto;

public interface UserMapper {

    UserDto queryById(Long id);
}
