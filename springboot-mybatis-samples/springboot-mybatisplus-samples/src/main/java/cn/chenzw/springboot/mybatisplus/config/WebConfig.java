package cn.chenzw.springboot.mybatisplus.config;

import cn.chenzw.springboot.mybatisplus.support.CustIdGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    /**
     * 自定义ID生成器
     *
     * @return
     */
    @Bean
    public IdentifierGenerator custIdGenerator() {
        return new CustIdGenerator();
    }
}
