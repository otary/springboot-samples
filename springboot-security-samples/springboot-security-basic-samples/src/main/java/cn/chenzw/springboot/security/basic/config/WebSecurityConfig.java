package cn.chenzw.springboot.security.basic.config;


import cn.chenzw.springboot.security.basic.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    CustomUserService customUserService;

    /**
     * 用户认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 内存用户
        // auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("ROLE_ADMIN").and().withUser("guest").password("guest123").roles("ROLE_GUEST");

        // JDBC用户


        // 通用用户
        auth.userDetailsService(customUserService);
    }


    /**
     * 请求授权
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests()
        // 只有拥有ROLE_ADMIN的角色可以访问/admin/
        // .antMatchers("/admin/**").hasRole("ROLE_ADMIN")
        // 拥有ROLE_ADMIN或ROLE_GUEST的角色可以访问/user/
        // .antMatchers("/user/**").hasAnyRole("ROLE_ADMIN", "ROLE_GUEST")
        // .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login")  // 定制登录页的访问地址
                .defaultSuccessUrl("/index")  // 定制登录成功后跳转的地址
                .failureUrl("/login?error")  // 指定登录失败后跳转的地址
                .permitAll()
                .and()
                .rememberMe()  // 开启cookie存储用户信息
                .tokenValiditySeconds(1209600)  // 指定cookie的有效期(单位:秒)
                .key("myKey")   // 指定cookie中的私钥
                .and()
                .logout().logoutUrl("/custom-logout").logoutSuccessUrl("/logout-success")  // 定制注销逻辑
                .permitAll();

    }


    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}
