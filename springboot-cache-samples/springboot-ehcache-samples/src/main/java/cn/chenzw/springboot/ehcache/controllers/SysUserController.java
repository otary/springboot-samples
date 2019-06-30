package cn.chenzw.springboot.ehcache.controllers;

import cn.chenzw.springboot.ehcache.domain.entity.SysUser;
import cn.chenzw.springboot.ehcache.service.SysUserService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.dozer.DozerBeanMapper;
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
    public String listCaches() {
        StringBuilder buffer = new StringBuilder();
        String[] cacheNames = cacheManager.getCacheNames();
        for (String cacheName : cacheNames) {
            Cache cache = cacheManager.getCache(cacheName);
            buffer.append("Cache: " + cache.toString() + "<br/>");

            List keys = cache.getKeys();
            for (Object key : keys) {
                Element element = cache.get(key);
                buffer.append("Element: " + element.toString() + "<br/>");
            }
        }
        return buffer.toString();
    }
}
