package cn.chenzw.springboot.ehcache.event;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Status;
import net.sf.ehcache.event.CacheManagerEventListener;
import net.sf.ehcache.event.CacheManagerEventListenerFactory;

import java.util.Properties;

/**
 * CacheManager事件监听器
 */
@Slf4j
public class MyCacheManagerEventListenerFactory extends CacheManagerEventListenerFactory implements CacheManagerEventListener {

    @Override
    public void init() throws CacheException {
        log.info("ehcache init");
    }

    @Override
    public Status getStatus() {
        return null;
    }

    @Override
    public void dispose() throws CacheException {

    }

    @Override
    public void notifyCacheAdded(String s) {
        log.info("notifyCacheAdded => {}", s);
    }

    @Override
    public void notifyCacheRemoved(String s) {
        log.info("notifyCacheRemoved => {}", s);
    }

    @Override
    public CacheManagerEventListener createCacheManagerEventListener(CacheManager cacheManager, Properties properties) {
        return this;
    }
}
