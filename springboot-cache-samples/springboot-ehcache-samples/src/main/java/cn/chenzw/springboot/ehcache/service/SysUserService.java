package cn.chenzw.springboot.ehcache.service;

import cn.chenzw.springboot.ehcache.domain.entity.SysUser;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class SysUserService {



    @Cacheable(value = "userCache")
    public SysUser findOne(Long id, String name) {
        System.out.println("--------------数据库查询-------------------------");

        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setName(name);
        return sysUser;
    }
}
