package cn.chenzw.springboot.jpa.repository;

import cn.chenzw.springboot.jpa.domain.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);

    /**
     * or条件查询
     *
     * @param id
     * @param username
     * @return
     */
    SysUser findByUsernameOrId(String id, String username);

    /**
     * 分页查询 & 自定义查询示例
     *
     * @param name
     * @param pageable
     * @return
     */
    @Query("select su from sys_user su where su.name = ?1")
    Page<SysUser> findByName(String name, Pageable pageable);


    @Transactional
    @Modifying
    @Query("delete from sys_user su where su.id = ?1")
    void deleteById(Long id);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update sys_user su set su.name = ?1 where su.id = ?2")
    int modifyById(String name, Long id);


}
