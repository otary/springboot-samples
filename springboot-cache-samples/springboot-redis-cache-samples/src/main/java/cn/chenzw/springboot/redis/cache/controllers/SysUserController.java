package cn.chenzw.springboot.redis.cache.controllers;


import cn.chenzw.springboot.redis.cache.domain.entity.SysUser;
import cn.chenzw.springboot.redis.cache.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/save")
    public void save(SysUser sysUser) {
        sysUserService.save(sysUser);
    }

    @GetMapping("/del/{id}")
    public void deleteOne(@PathVariable Long id) {
        sysUserService.deleteOne(id);
    }

    @GetMapping("/caches/list")
    public String listCaches() {
        StringBuilder buffer = new StringBuilder();
        cacheManager.getCache("userCache");
        /*String[] cacheNames = cacheManager.getCacheNames();
        for (String cacheName : cacheNames) {
            Cache cache = cacheManager.getCache(cacheName);
            buffer.append("Cache: " + cache.toString() + "<br/>");

            List keys = cache.getKeys();
            for (Object key : keys) {
                Element element = cache.get(key);
                buffer.append("Element: " + element.toString() + "<br/>");
            }
        }*/
        return buffer.toString();
    }
}
