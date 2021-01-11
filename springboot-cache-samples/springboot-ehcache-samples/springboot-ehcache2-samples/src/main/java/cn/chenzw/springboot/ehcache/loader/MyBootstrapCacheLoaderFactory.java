package cn.chenzw.springboot.ehcache.loader;


import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import net.sf.ehcache.bootstrap.BootstrapCacheLoaderFactory;

import java.util.List;
import java.util.Properties;

/**
 * 缓存预热加载（<bootstrapCacheLoaderFactory/>）
 */
@Slf4j
public class MyBootstrapCacheLoaderFactory extends BootstrapCacheLoaderFactory implements BootstrapCacheLoader {


    @Override
    public void load(Ehcache ehcache) throws CacheException {
        log.info("load cache....");

        List keys = ehcache.getKeys();
        for (int i = 0; i < keys.size(); i++) {
            log.info("keys => " + keys.get(i));
        }

        // 从数据库取数据
        // SysUserService sysUserService = SpringUtils.getBean(SysUserService.class);
        // ehcache.put(new Element(1L, sysUserService.findOne(1L, "张三")));
    }

    @Override
    public boolean isAsynchronous() {
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public BootstrapCacheLoader createBootstrapCacheLoader(Properties properties) {
        return this;
    }
}
