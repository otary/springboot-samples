package cn.chenzw.springboot.condition;

import cn.chenzw.springboot.condition.template.AbstractTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConditionSamplesApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(ConditionSamplesApp.class, args);
        AbstractTemplate bean = cac.getBean(AbstractTemplate.class);

        System.out.println("OS系统:[ " + cac.getEnvironment().getProperty("os.name") + " ], templates:[ " + bean.getName() + " ]");
    }
}
