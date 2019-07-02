package cn.chenzw.springboot.web01.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigBean {

    @Value("${app.name}")
    private String appName;

    @Value("${app.base01.name}")
    private String base01Name;

    @Value("${app.base02.name}")
    private String base02Name;

    @Value("${app.web01.name}")
    private String web01Name;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getBase01Name() {
        return base01Name;
    }

    public void setBase01Name(String base01Name) {
        this.base01Name = base01Name;
    }

    public String getBase02Name() {
        return base02Name;
    }

    public void setBase02Name(String base02Name) {
        this.base02Name = base02Name;
    }

    public String getWeb01Name() {
        return web01Name;
    }

    public void setWeb01Name(String web01Name) {
        this.web01Name = web01Name;
    }

    @Override
    public String toString() {
        return "ConfigBean{" +
                "appName='" + appName + '\'' +
                ", base01Name='" + base01Name + '\'' +
                ", base02Name='" + base02Name + '\'' +
                ", web01Name='" + web01Name + '\'' +
                '}';
    }
}
