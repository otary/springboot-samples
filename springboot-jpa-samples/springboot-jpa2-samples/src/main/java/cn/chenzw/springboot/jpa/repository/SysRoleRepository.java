package cn.chenzw.springboot.jpa.repository;

import cn.chenzw.springboot.jpa.domain.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
}
