package cn.chenzw.springboot.security.cust.oauth2.server.config;

import cn.chenzw.springboot.security.cust.oauth2.server.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

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


    @Autowired
    CustomUserService userService;

    /**
     * 授权服务配置（默认端点: /oauth/token）
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    /**
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        // 内存方式
        clients.inMemory()
                .withClient("abc") // 客户端ID
                .secret("123456") // 密码
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")   // 授权类型
                      .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                      .autoApprove(true) // 自动认证
                .scopes("read", "write", "trust") // 授权用户的操作权限
                .redirectUris("http://www.baidu.com", "http://localhost:8082/callback", "http://localhost:8082/**", "http://localhost:8222/itm-oauth2-code-callback")    // 认证成功重定向URL
                .accessTokenValiditySeconds(60*60) // token有效期为120秒
                .refreshTokenValiditySeconds(60*60); // 刷新token有效期为600秒
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler).userDetailsService(userService);
    }



}
