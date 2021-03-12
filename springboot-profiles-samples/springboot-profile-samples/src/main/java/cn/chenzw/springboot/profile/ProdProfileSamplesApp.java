package cn.chenzw.springboot.profile;

import cn.chenzw.springboot.profile.template.AbstractTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

@Slf4j
@SpringBootApplication
public class ProdProfileSamplesApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(ProdProfileSamplesApp.class, new String[]{"--spring.profiles.active=prod"});

        AbstractTemplate bean = cac.getBean(AbstractTemplate.class);
        log.info("Template => {}", bean.getName()); // => ProdTemplate

        Assert.isTrue("prod-templates".endsWith(bean.getName()), "");
    }
}
