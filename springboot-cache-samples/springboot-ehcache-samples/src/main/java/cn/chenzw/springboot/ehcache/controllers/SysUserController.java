package cn.chenzw.springboot.ehcache.controllers;

import cn.chenzw.springboot.ehcache.domain.entity.SysUser;
import cn.chenzw.springboot.ehcache.service.SysUserService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    CacheManager cacheManager;

    @GetMapping("/{id}")
    public SysUser findOne(@PathVariable Long id, String name) {
        return sysUserService.findOne(id, name);
    }


    @GetMapping("/caches/list")
    public List<Object> listCaches() {
        List<Object> elements = new ArrayList<>();
        String[] cacheNames = cacheManager.getCacheNames();
        for (String cacheName : cacheNames) {
            Cache cache = cacheManager.getCache(cacheName);


            List keys = cache.getKeys();
            elements.addAll(keys);
            for (Object key : keys) {
                System.out.println(key);
            }

        }
        return elements;
        //System.out.println(caches);

    }
}
