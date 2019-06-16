package cn.chenzw.springboot.profile;

import cn.chenzw.springboot.profile.template.AbstractTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

@SpringBootApplication
public class DevProfileSamplesApp {


    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(DevProfileSamplesApp.class, new String[]{"--spring.profiles.active=dev"});

        AbstractTemplate bean = cac.getBean(AbstractTemplate.class);
        System.out.println(bean);  // => DevTemplate

        Assert.isTrue("dev-templates".endsWith(bean.getName()), "");

    }
}
