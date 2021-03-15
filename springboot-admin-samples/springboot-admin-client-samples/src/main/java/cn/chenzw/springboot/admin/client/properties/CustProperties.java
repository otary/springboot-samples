package cn.chenzw.springboot.admin.client.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 使用/actuator/configprops查看属性值
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "cust")
public class CustProperties {

    private String name;
}
