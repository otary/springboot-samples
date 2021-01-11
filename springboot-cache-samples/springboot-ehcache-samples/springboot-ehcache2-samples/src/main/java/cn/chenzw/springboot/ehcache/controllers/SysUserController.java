package cn.chenzw.springboot.ehcache.controllers;

import cn.chenzw.springboot.ehcache.domain.entity.SysUser;
import cn.chenzw.springboot.ehcache.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chenzw
 */
@Slf4j
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


    @PostMapping("/save")
    public void save(@RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);
    }

    @DeleteMapping("/del/{id}")
    public void deleteOne(@PathVariable Long id) {
        sysUserService.deleteOne(id);
    }

    @GetMapping("/caches/list")
    public String listCaches() {
        StringBuilder buffer = new StringBuilder();
        String[] cacheNames = cacheManager.getCacheNames();
        for (String cacheName : cacheNames) {
            Cache cache = cacheManager.getCache(cacheName);
            buffer.append("Cache: " + cache.toString() + "<br/>");
            buffer.append(" ");
            buffer.append("Element(元素):");
            List keys = cache.getKeys();
            for (Object key : keys) {
                Element element = cache.get(key);
                buffer.append(element.toString() + "<br/>");
            }
        }
        return buffer.toString();
    }
}
