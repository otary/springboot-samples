package cn.chenzw.springboot.security.jwt.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String secretKey = "secret";

    // 1h
    private long validityInMs = 3600000;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public long getValidityInMs() {
        return validityInMs;
    }

    public void setValidityInMs(long validityInMs) {
        this.validityInMs = validityInMs;
    }

    @Override
    public String toString() {
        return "JwtProperties{" +
                "secretKey='" + secretKey + '\'' +
                ", validityInMs=" + validityInMs +
                '}';
    }
}
