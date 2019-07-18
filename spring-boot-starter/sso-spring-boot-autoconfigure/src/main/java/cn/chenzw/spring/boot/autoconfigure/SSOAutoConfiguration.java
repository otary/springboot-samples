package cn.chenzw.spring.boot.autoconfigure;

import cn.chenzw.spring.boot.autoconfigure.support.AbstractSSOTemplate;
import com.ffcs.itm.sso.support.DefaultSSOTemplate;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ConditionalOnClass
@EnableConfigurationProperties(SSOProperties.class)
// @AutoConfigureAfter
public class SSOAutoConfiguration {

    private SSOProperties properties;

    SSOAutoConfiguration(SSOProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public AbstractSSOTemplate defaultSSOTemplate() {
        System.out.println("---------------------------" + properties);
        return new DefaultSSOTemplate(properties);
    }

}
