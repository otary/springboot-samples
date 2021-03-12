package cn.chenzw.springboot.profile;

import cn.chenzw.springboot.profile.template.AbstractTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class DevProfileSamplesApp {


    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(DevProfileSamplesApp.class, new String[]{"--spring.profiles.active=dev"});

        AbstractTemplate bean = cac.getBean(AbstractTemplate.class);

        // 获取当前profile
        String[] activeProfiles = cac.getEnvironment().getActiveProfiles();
        log.info("当前profile: => {}", Arrays.toString(activeProfiles));

        Assert.isTrue("dev-templates".endsWith(bean.getName()), "");
    }
}
