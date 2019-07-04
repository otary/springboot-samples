package cn.chenzw.springboot.security.basic.config;


import cn.chenzw.springboot.security.basic.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 启用方法安全设置
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    CustomUserService customUserService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


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

        http.authorizeRequests()
                .antMatchers("/assets/**", "/h2-console/**").permitAll()
                .antMatchers("/users/**").hasRole("USER")
                .antMatchers("/admins/**").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/login")  // 定制登录页的访问地址
                .defaultSuccessUrl("/index")  // 定制登录成功后跳转的地址
                .failureUrl("/login?error")  // 指定登录失败后跳转的地址
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403") // 处理异常，拒绝访问就重定向到 403 页面
                .and()
                .rememberMe()  // 开启cookie存储用户信息
                .tokenValiditySeconds(1209600)  // 指定cookie的有效期(单位:秒)
                .key("myKey")   // 指定cookie中的私钥
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")  // 定制注销逻辑
                .permitAll();

        http.csrf().ignoringAntMatchers("/h2-console/**"); // 禁用 H2 控制台的 CSRF 防护
        http.headers().frameOptions().sameOrigin(); // 允许来自同一来源的H2 控制台的请求

    }


    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123456");
        System.out.println(password);
    }
}
