package cn.chenzw.springboot.profile.config;

import cn.chenzw.springboot.profile.template.AbstractTemplate;
import cn.chenzw.springboot.profile.template.DevTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevProfileConfig {

    @Bean
    public AbstractTemplate devTemplate() {
        return new DevTemplate();
    }

}
