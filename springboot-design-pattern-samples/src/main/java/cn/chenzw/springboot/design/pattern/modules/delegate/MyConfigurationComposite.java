package cn.chenzw.springboot.design.pattern.modules.delegate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 混合列表
 *
 * @author chenzw
 */
@Slf4j
public class MyConfigurationComposite implements MyConfiguration {

    private final List<MyConfiguration> delegates = new ArrayList<>();

    public void addConfiguration(List<MyConfiguration> myConfigurations) {
        if (!CollectionUtils.isEmpty(myConfigurations)) {
            delegates.addAll(myConfigurations);
        }
    }


    @Override
    public void doSomething() {
        for (MyConfiguration delegate : delegates) {
            delegate.doSomething();
        }
    }

    @Override
    public void doSomething2() {
        for (MyConfiguration delegate : delegates) {
            delegate.doSomething2();
        }
    }

}
