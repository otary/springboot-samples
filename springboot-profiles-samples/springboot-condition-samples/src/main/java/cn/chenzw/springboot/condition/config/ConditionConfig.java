package cn.chenzw.springboot.condition.config;

import cn.chenzw.springboot.condition.support.LinuxCondition;
import cn.chenzw.springboot.condition.support.WindowsCondition;
import cn.chenzw.springboot.condition.template.AbstractTemplate;
import cn.chenzw.springboot.condition.template.LinuxTemplate;
import cn.chenzw.springboot.condition.template.WindowsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    /**
     * 满足WindowsCondition条件，则实例化此bean
     * @return
     */
    @Bean
    @Conditional(WindowsCondition.class)
    public AbstractTemplate windowsTemplate() {
        return new WindowsTemplate();
    }

    /**
     * 满足LinuxCondition条件，则实例化此bean
     * @return
     */
    @Bean
    @Conditional(LinuxCondition.class)
    public AbstractTemplate linuxTemplate() {
        return new LinuxTemplate();
    }
}
