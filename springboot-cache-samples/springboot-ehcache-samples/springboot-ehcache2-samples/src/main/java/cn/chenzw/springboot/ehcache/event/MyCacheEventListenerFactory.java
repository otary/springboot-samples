package cn.chenzw.springboot.ehcache.event;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

import java.util.Properties;

/**
 * Cache事件监听器
 */
@Slf4j
public class MyCacheEventListenerFactory extends CacheEventListenerFactory implements CacheEventListener {

    @Override
    public void notifyElementRemoved(Ehcache ehcache, Element element) throws CacheException {
        log.info("notifyElementRemoved => {}, {}", ehcache, element);
    }

    @Override
    public void notifyElementPut(Ehcache ehcache, Element element) throws CacheException {
        log.info("notifyElementPut => {}, {}", ehcache, element);
    }

    @Override
    public void notifyElementUpdated(Ehcache ehcache, Element element) throws CacheException {
        log.info("notifyElementUpdated => {}, {}", ehcache, element);
    }

    @Override
    public void notifyElementExpired(Ehcache ehcache, Element element) {
        log.info("notifyElementExpired => {}, {}", ehcache, element);
    }

    @Override
    public void notifyElementEvicted(Ehcache ehcache, Element element) {
        log.info("notifyElementEvicted => {}, {}", ehcache, element);
    }

    @Override
    public void notifyRemoveAll(Ehcache ehcache) {
        log.info("notifyRemoveAll => {}, {}", ehcache);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void dispose() {

    }

    @Override
    public CacheEventListener createCacheEventListener(Properties properties) {
        return this;
    }
}
