package cn.chenzw.springboot.web.beans;

import cn.chenzw.springboot.web.domain.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanDefinitionTests {

    @Autowired
    ApplicationContext context;

    @Test
    public void testCreateBean() {
        // 创建Bean
        UserDto bean = context.getAutowireCapableBeanFactory().createBean(UserDto.class);

        log.info("bean => {}", bean);
    }

    @Test
    public void test() {
        // 注册Bean
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context;

        // 构建BeanDefinition
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(UserDto.class);

        // 传入构建函数参数
        ConstructorArgumentValues constructorArgumentValues = rootBeanDefinition.getConstructorArgumentValues();
        constructorArgumentValues.addGenericArgumentValue("1");
        constructorArgumentValues.addGenericArgumentValue("张三");
        constructorArgumentValues.addGenericArgumentValue("20");
        registry.registerBeanDefinition("userDto", rootBeanDefinition);

        log.info("userDto => {}", context.getBean("userDto"));
    }
}
