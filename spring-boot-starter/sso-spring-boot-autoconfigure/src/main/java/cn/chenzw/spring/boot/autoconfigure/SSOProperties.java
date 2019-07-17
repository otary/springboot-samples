package cn.chenzw.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = SSOProperties.SSO_PREFIX)
public class SSOProperties {

    public static final String SSO_PREFIX = "sso";

    /**
     * 来源系统-标识符
     */
    private String sourceIdentifier;

    /**
     * 一次性密钥-标识符
     */
    private String keyIdentifier;


    /**
     * 用户帐号-标识符
     */
    private String usernameIdentifier;

    /**
     * 跳转url
     */
    private String redirectUrlIdentifier;

    /**
     * 密钥
     */
    private String privateKey;

    /**
     * 时效性（默认:30分钟）
     */
    private int limitMilliSecond;

    /**
     * 默认的跳转主页
     */
    private String defaultRedirectUrl;


    public String getSourceIdentifier() {
        return sourceIdentifier;
    }

    public void setSourceIdentifier(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    public String getKeyIdentifier() {
        return keyIdentifier;
    }

    public void setKeyIdentifier(String keyIdentifier) {
        this.keyIdentifier = keyIdentifier;
    }

    public String getUsernameIdentifier() {
        return usernameIdentifier;
    }

    public void setUsernameIdentifier(String usernameIdentifier) {
        this.usernameIdentifier = usernameIdentifier;
    }

    public String getRedirectUrlIdentifier() {
        return redirectUrlIdentifier;
    }

    public void setRedirectUrlIdentifier(String redirectUrlIdentifier) {
        this.redirectUrlIdentifier = redirectUrlIdentifier;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public int getLimitMilliSecond() {
        return limitMilliSecond;
    }

    public void setLimitMilliSecond(int limitMilliSecond) {
        this.limitMilliSecond = limitMilliSecond;
    }

    public String getDefaultRedirectUrl() {
        return defaultRedirectUrl;
    }

    public void setDefaultRedirectUrl(String defaultRedirectUrl) {
        this.defaultRedirectUrl = defaultRedirectUrl;
    }

    @Override
    public String toString() {
        return "SSOProperties{" +
                "sourceIdentifier='" + sourceIdentifier + '\'' +
                ", keyIdentifier='" + keyIdentifier + '\'' +
                ", usernameIdentifier='" + usernameIdentifier + '\'' +
                ", redirectUrlIdentifier='" + redirectUrlIdentifier + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", limitMilliSecond=" + limitMilliSecond +
                ", defaultRedirectUrl='" + defaultRedirectUrl + '\'' +
                '}';
    }
}
