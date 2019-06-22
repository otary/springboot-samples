package cn.chenzw.springboot.jpa.domain.entity;

import javax.persistence.*;
import java.util.List;

/**
 * 权限表
 *
 * @author chenzw
 */
@Entity(name = "sys_permission")
public class SysPermission {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 资源类型，[menu|button]
     */
    @Column(columnDefinition = "enum('menu','button')")
    private String type;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串
     */
    private String permission;

    /**
     * 父编号
     */
    private Long parentId;

    /**
     * 父编号列表
     */
    private String parentIds;


    /**
     * 是否可用, 1：可用, 0: 不可用
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 排序
     */
    private Integer sortId;


    /**
     * 权限所属的角色
     */
    @ManyToMany
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "sysPermissionId")}, inverseJoinColumns = {@JoinColumn(name = "sysRoleId")})
    private List<SysRole> roles;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", available=" + available +
                ", sortId=" + sortId +
                '}';
    }
}
