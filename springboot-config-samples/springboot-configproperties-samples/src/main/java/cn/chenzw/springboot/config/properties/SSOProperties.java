package cn.chenzw.springboot.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 普通字段注入示例
 */
@Configuration
@PropertySource({"classpath:sso.properties"})
@ConfigurationProperties(prefix = "sso")
public class SSOProperties {

    private String privateKey;

    private String defaultUrl;

    /**
     * 设置默认值
     */
    @Value("${sso.default-value:默认值}")
    private String defaultValue;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return "SSOProperties{" +
                "privateKey='" + privateKey + '\'' +
                ", defaultUrl='" + defaultUrl + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                '}';
    }
}
