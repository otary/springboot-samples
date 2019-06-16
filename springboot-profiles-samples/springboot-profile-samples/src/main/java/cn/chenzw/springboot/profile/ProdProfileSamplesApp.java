package cn.chenzw.springboot.profile;

import cn.chenzw.springboot.profile.template.AbstractTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

@SpringBootApplication
public class ProdProfileSamplesApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(ProdProfileSamplesApp.class, new String[]{"--spring.profiles.active=prod"});

        AbstractTemplate bean = cac.getBean(AbstractTemplate.class);
        System.out.println(bean);  // => ProdTemplate

        Assert.isTrue("prod-templates".endsWith(bean.getName()), "");
    }
}
