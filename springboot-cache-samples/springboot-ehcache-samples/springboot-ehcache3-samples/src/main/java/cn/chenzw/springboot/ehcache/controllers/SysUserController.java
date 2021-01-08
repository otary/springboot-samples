package cn.chenzw.springboot.ehcache.controllers;

import cn.chenzw.springboot.ehcache.domain.entity.SysUser;
import cn.chenzw.springboot.ehcache.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

   // @Autowired
    //  CacheManager cacheManager;

    @GetMapping("/{id}")
    public SysUser findOne(@PathVariable Long id, String name) {
        return sysUserService.findOne(id, name);
    }


    @PostMapping("/save")
    public void save(@RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);
    }

    @GetMapping("/del/{id}")
    public void deleteOne(@PathVariable Long id) {
        sysUserService.deleteOne(id);
    }

    @GetMapping("/caches/list")
    public String listCaches() {
        StringBuilder buffer = new StringBuilder();

     /*   Collection<String> cacheNames = cacheManager.getCacheNames();
        System.out.println(cacheNames);*/

        /*String[] cacheNames = ((EhcacheManager)cacheManager).getCacheNames();
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
