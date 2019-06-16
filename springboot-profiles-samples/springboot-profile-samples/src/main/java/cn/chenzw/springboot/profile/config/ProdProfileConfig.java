package cn.chenzw.springboot.profile.config;

import cn.chenzw.springboot.profile.template.AbstractTemplate;
import cn.chenzw.springboot.profile.template.ProdTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ProdProfileConfig {

    @Bean
    public AbstractTemplate prodTemplate() {
        return new ProdTemplate();
    }

}
