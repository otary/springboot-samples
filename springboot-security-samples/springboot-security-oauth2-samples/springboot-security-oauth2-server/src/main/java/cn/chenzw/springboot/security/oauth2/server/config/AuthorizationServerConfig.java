package cn.chenzw.springboot.security.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 认证服务器配置
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private static final String REALM = "MY_OAUTH_REALM";

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private UserApprovalHandler userApprovalHandler;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.realm(REALM + "/client");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        // 内存方式
        clients.inMemory()
                .withClient("MyClientId") // 客户端ID
                .secret("secret") // 密码
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")   // 授权类型
                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                .autoApprove(true) // 自动认证
                .scopes("read", "write", "trust") // 授权用户的操作权限
                .redirectUris("http://localhost:8882/login","http://localhost:8883/login")    // 认证成功重定向URL
                .accessTokenValiditySeconds(120) // token有效期为120秒
                .refreshTokenValiditySeconds(600); // 刷新token有效期为600秒
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler);
    }
}
