package cn.chenzw.springboot.ehcache.config;

import org.ehcache.jsr107.EhcacheCachingProvider;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@EnableCaching
public class EhCacheConfig {

 /*   @Bean
    public CacheManager cacheManager() throws URISyntaxException, FileNotFoundException {
        return new JCacheCacheManager(jCacheManager());
    }

    @Bean
    public javax.cache.CacheManager jCacheManager() throws URISyntaxException, FileNotFoundException {
        //ehcache实现了javax的CachingProvider接口的具体实现
        EhcacheCachingProvider ehcacheCachingProvider = new EhcacheCachingProvider();
        //根据配置文件获取cachemanager
        URI uri = ResourceUtils.getURL("classpath:cache/ehcache.xml").toURI();
        javax.cache.CacheManager cacheManager = ehcacheCachingProvider
                .getCacheManager(uri, this.getClass().getClassLoader());
        return cacheManager;
    }*/
}
