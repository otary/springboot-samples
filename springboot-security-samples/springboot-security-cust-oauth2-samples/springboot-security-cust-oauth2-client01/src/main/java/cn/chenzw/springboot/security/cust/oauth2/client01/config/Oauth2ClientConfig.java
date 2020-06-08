package cn.chenzw.springboot.security.cust.oauth2.client01.config;


import cn.chenzw.springboot.security.cust.oauth2.client01.MyAuthorizationCodeResourceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@Configuration
@EnableOAuth2Client
public class Oauth2ClientConfig implements ApplicationRunner {

    @Autowired
    OAuth2ProtectedResourceDetails details;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(details.getClientId());

        if (details instanceof AuthorizationCodeResourceDetails) {
            AuthorizationCodeResourceDetails a = (AuthorizationCodeResourceDetails) details;
            System.out.println(a.getPreEstablishedRedirectUri());
        }

    }


    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext context, OAuth2ProtectedResourceDetails details) {

        System.out.println(details.getClientSecret());

        OAuth2RestTemplate template = new OAuth2RestTemplate(details, context);

        AuthorizationCodeAccessTokenProvider authCodeProvider = new AuthorizationCodeAccessTokenProvider();
        authCodeProvider.setStateMandatory(false);
        //  template.setRetryBadAccessTokens(false);

    /*    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new MyOauth2AccessTokenMessageConverter());
        //设置access token解析器
        tokenProvider.setMessageConverters(messageConverters);*/


        AccessTokenProviderChain provider = new AccessTokenProviderChain(
                Arrays.asList(authCodeProvider));
        template.setAccessTokenProvider(provider);
        return template;
    }


   /* @Bean(name="accessTokenRequest")
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    protected AccessTokenRequest accessTokenRequest(@Value("#{request.parameterMap}")
                                                            Map<String, String[]> parameters, @Value("#{request.getAttribute('currentUri')}")
                                                            String currentUri) {
        MyAccessTokenRequest request = new MyAccessTokenRequest(parameters);
        request.setCurrentUri(currentUri);
        //该处可以设置你自己的回调地址
        request.set("redirect_uri", "http://127.0.0.1:8080/login/oauth2");
        return request;
    }*/

    /**
     * 注册处理redirect uri的filter
     *
     * @param oauth2RestTemplate
     * @param tokenService
     * @return
     */
    @Bean
    public OAuth2ClientAuthenticationProcessingFilter oauth2ClientAuthenticationProcessingFilter(
            OAuth2RestTemplate oauth2RestTemplate,
            RemoteTokenServices tokenService,
            AuthorizationCodeResourceDetails authorizationCodeResourceDetails) {

      //  MyAuthorizationCodeResourceDetails authorizationCodeResourceDetails1 = (MyAuthorizationCodeResourceDetails) authorizationCodeResourceDetails;

     //   System.out.println(authorizationCodeResourceDetails1.getSuccessRedirectUri());

        String redirectUri = "/callback";
        OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(redirectUri);
        filter.setRestTemplate(oauth2RestTemplate);
        filter.setTokenServices(tokenService);

        //设置回调成功的页面
        filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler() {
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                this.setDefaultTargetUrl("/test");
                super.onAuthenticationSuccess(request, response, authentication);
            }
        });
        return filter;
    }

    /**
     * 注册check token服务
     *
     * @param details
     * @return
     */
    @Bean
    public RemoteTokenServices tokenService(OAuth2ProtectedResourceDetails details, ResourceServerProperties itemResource) {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(itemResource.getTokenInfoUri());
        tokenService.setClientId(details.getClientId());
        tokenService.setClientSecret(details.getClientSecret());
        return tokenService;
    }

    @Bean
    @ConfigurationProperties("itm.oauth2.client")
    public AuthorizationCodeResourceDetails itmAuthorizationCodeResourceDetails() {
        return new MyAuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("itm.oauth2.resource")
    public ResourceServerProperties itemResource() {
        return new ResourceServerProperties();
    }


}
