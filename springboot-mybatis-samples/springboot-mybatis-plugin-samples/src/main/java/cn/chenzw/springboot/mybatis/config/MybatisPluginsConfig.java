package cn.chenzw.springboot.mybatis.config;

import cn.chenzw.springboot.mybatis.plugin.MyExecutorPlugin;
import cn.chenzw.springboot.mybatis.plugin.MyParameterHandlerPlugin;
import cn.chenzw.springboot.mybatis.plugin.MyStatementHandlerPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPluginsConfig {

    /**
     * 注册插件
     *
     * @return
     */
    @Bean
    public MyStatementHandlerPlugin myStatementHandlerPlugin() {
        return new MyStatementHandlerPlugin();
    }


    @Bean
    public MyExecutorPlugin myExecutorPlugin() {
        return new MyExecutorPlugin();
    }


    @Bean
    public MyParameterHandlerPlugin myParameterHandlerPlugin() {
        return new MyParameterHandlerPlugin();
    }
}
