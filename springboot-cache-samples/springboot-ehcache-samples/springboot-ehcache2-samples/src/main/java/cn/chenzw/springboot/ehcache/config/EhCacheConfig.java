package cn.chenzw.springboot.ehcache.config;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class EhCacheConfig {

    /*@Bean
    public EhCacheCacheManager cacheManager(CacheManager ehCacheCacheManager){
        return new EhCacheCacheManager(ehCacheCacheManager);
    }*/
}
