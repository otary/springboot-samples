package cn.chenzw.springboot.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 静态字段注入示例
 */
@Configuration
@PropertySource(value = {"classpath:sso.properties"}, ignoreResourceNotFound = true)
@ConfigurationProperties(prefix = "sso")
public class SSOConstants {

    private static String privateKey;

    private static String defaultUrl;

    /**
     * get使用静态方法，set使用普通方法
     *
     * @return
     */
    public static String getPrivateKey() {
        return privateKey;
    }

    // @Value("${sso.private-key}")
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public static String getDefaultUrl() {
        return defaultUrl;
    }

    // @Value("${sso.default-url}")
    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    @Override
    public String toString() {
        return "SSOConstants{" +
                "privateKey='" + privateKey + '\'' +
                ", defaultUrl='" + defaultUrl + '\'' +
                '}';
    }
}
