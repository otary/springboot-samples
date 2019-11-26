package cn.chenzw.spring.boot.registrar;

import cn.chenzw.spring.boot.annotation.EnableSSO;
import cn.chenzw.spring.boot.domain.entity.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class SSORegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, BeanFactoryAware {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        // 获取注解属性
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableSSO.class.getName());


        // 动态注册bean
        if(!registry.containsBeanDefinition("person")){
            BeanDefinitionBuilder beanDefinitionBuilder =
                    BeanDefinitionBuilder.genericBeanDefinition(Person.class);
            registry.registerBeanDefinition("person", beanDefinitionBuilder.getBeanDefinition());
        }

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }
}
