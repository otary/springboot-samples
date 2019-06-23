package cn.chenzw.springboot.ehcache.config;


import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class EhCacheConfig {

    /*@Bean
    public EhCacheCacheManager cacheManager(CacheManager ehCacheCacheManager){
        return new EhCacheCacheManager(ehCacheCacheManager);
    }*/
}
