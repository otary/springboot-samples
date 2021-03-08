package cn.chenzw.springboot.web.util;

import cn.chenzw.toolkit.spring.annotation.EnableToolkit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanFactoryUtilsTests {

    @Autowired
    WebApplicationContext wac;

    @Test
    public void testBeanNamesForTypeIncludingAncestors() {
        // 获取指定类型的Bean（实现某个接口的Bean）
        String[] allBeanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(wac, Object.class);
        log.info("所有Bean名称 => {}", Arrays.toString(allBeanNames));

        String[] beanDefinitionNames = wac.getBeanDefinitionNames();
        log.info("所有Bean名称 => {}", Arrays.toString(beanDefinitionNames));

        String[] webMvcConfigurerBean = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(wac, WebMvcConfigurer.class);
        log.info("获取所有实现WebMvcConfigurer接口的Bean => {}", Arrays.toString(webMvcConfigurerBean));

        // webMvcConfigurerBean上带有@EnableToolkit的Bean名称
        List<String> list = Arrays.stream(webMvcConfigurerBean)
                .filter(name -> wac.findAnnotationOnBean(name, EnableToolkit.class) != null)
                .collect(Collectors.toList());

        log.info("webMvcConfigurerBean上带有@EnableToolkit的Bean名称 => {}", list);
    }
}
