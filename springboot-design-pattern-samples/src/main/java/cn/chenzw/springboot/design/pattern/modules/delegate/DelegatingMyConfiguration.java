package cn.chenzw.springboot.design.pattern.modules.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 委托类，注入多个配置
 *
 * @author chenzw
 */
@Configuration
public class DelegatingMyConfiguration {

    /**
     * 集中存放处理
     */
    private MyConfigurationComposite myConfigurationComposite = new MyConfigurationComposite();

    /**
     * 注入多个配置
     *
     * @param myConfigurations
     */
    @Autowired(required = false)
    public void setConfigurations(List<MyConfiguration> myConfigurations) {
        myConfigurationComposite.addConfiguration(myConfigurations);
    }

    public void doSomething() {
        myConfigurationComposite.doSomething();
    }

    public void doSomething2() {
        myConfigurationComposite.doSomething2();
    }
}
