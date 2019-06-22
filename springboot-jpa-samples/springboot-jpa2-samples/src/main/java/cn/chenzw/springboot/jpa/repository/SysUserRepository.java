package cn.chenzw.springboot.jpa.repository;

import cn.chenzw.springboot.jpa.domain.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);
}
