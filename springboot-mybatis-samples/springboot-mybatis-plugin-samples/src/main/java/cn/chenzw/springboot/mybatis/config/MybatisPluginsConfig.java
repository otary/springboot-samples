package cn.chenzw.springboot.mybatis.config;

import cn.chenzw.springboot.mybatis.plugin.AMyBatisPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPluginsConfig {

    @Bean
    public AMyBatisPlugin aMyBatisPlugin() {
        return new AMyBatisPlugin();
    }
}
