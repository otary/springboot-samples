package cn.chenzw.springboot.web01.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;



@Slf4j
@Component
@Data
public class ConfigBean implements InitializingBean {

    @Value("${app.name}")
    private String appName;

    @Value("${app.base01.name}")
    private String base01Name;

    @Value("${app.base02.name}")
    private String base02Name;

    @Value("${app.web01.name}")
    private String web01Name;

    @Value("${app.common.name}")
    private String commonName;


    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("configBean => {}", this);
    }
}
