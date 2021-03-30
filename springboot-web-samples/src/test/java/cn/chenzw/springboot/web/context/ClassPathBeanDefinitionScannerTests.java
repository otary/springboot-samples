package cn.chenzw.springboot.web.context;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassPathBeanDefinitionScannerTests {

    @Autowired
    ApplicationContext context;

    @Test
    public void testScan() {
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) ((ConfigurableApplicationContext) context)
                .getBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);

        Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents("cn.chenzw.springboot.web");
        log.info("扫描出{}个组件，列表 => {}", candidateComponents.size(), candidateComponents);

        for (BeanDefinition candidateComponent : candidateComponents) {
            log.info(" => {}", candidateComponent.getBeanClassName());
        }

        // 扫描并自动注册
        // int scan = scanner.scan("cn.chenzw.springboot.web");

    }

}
