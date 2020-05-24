package cn.chenzw.springboot.security.basic.json.config;

import cn.chenzw.springboot.security.basic.json.entrypoint.LoginUrl2JsonAuthenticationEntryPoint;
import cn.chenzw.springboot.security.basic.json.handler.AuthenticationAccessDeniedHandler;
import cn.chenzw.springboot.security.basic.json.handler.LoginFailureHandler;
import cn.chenzw.springboot.security.basic.json.handler.LoginSuccessHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder() {
        // @TODO
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin123")
                .roles("ADMIN")
                .and()
                .withUser("guest")
                .password("guest123")
                .roles("GUEST");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .exceptionHandling()
                //  未登录
                .authenticationEntryPoint(new LoginUrl2JsonAuthenticationEntryPoint(""))
                // 无权访问
                .accessDeniedHandler(new AuthenticationAccessDeniedHandler())
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(new LoginSuccessHandler())
                .failureHandler(new LoginFailureHandler())
                .permitAll()
                .and()
                .rememberMe()
                .tokenValiditySeconds(60 * 60 * 24 * 7)  // 单位:秒
                .and()
                .logout()
                .logoutUrl("/logout")
                // .logoutSuccessHandler()
                .permitAll()
                .and()
                // 关闭跨域
                .csrf().disable();

    }

}
