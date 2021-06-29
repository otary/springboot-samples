package cn.chenzw.springboot.jpa.repository;

import cn.chenzw.springboot.jpa.domain.entity.SysRole;
import cn.chenzw.springboot.jpa.domain.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

/**
 * @author chenzw
 */

public interface SysRoleRepository extends JpaRepository<SysRole, Long> {

    @Query(nativeQuery = true, value = "SELECT " +
            " su.* " +
            " FROM " +
            " sys_user su " +
            " LEFT JOIN sys_user_role sur ON ( su.id = sur.sys_user_id ) " +
            " LEFT JOIN sys_role sr ON ( sur.sys_role_id = sr.id ) where sr.id = ?1")
    List<SysUser> findUser(Long id);

}
