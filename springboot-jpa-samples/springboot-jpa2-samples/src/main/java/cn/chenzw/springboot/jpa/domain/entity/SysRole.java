package cn.chenzw.springboot.jpa.domain.entity;

import javax.persistence.*;
import java.util.List;

/**
 * 角色表
 *
 * @author chenzw
 */
@Entity(name = "sys_role")
public class SysRole {

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色标识
     */
    private String name;

    /**
     * 角色描述（UI界面显示使用）
     */
    private String description;

    /**
     * 是否可用
     */
    private Boolean available = Boolean.FALSE;


    /**
     * 角色 - 权限（多对多）
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "sysRoleId")}, inverseJoinColumns = {@JoinColumn(name = "sysPermissionId")})
    private List<SysPermission> permissions;

    /**
     * 用户 - 角色（多对多）
     */
    @ManyToMany
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "sysRoleId")}, inverseJoinColumns = {@JoinColumn(name = "sysUserId")})
    private List<SysUser> users;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }


    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
