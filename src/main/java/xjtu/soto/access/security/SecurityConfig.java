package xjtu.soto.access.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 自定义配置
     * @param http
     * @throws Exception
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //都允许访问
        .antMatchers("/css/**","/js/**","/fonts/**","/index","/login")
        .permitAll()
                //需要相应的角色才能访问
        .antMatchers("/users/**").hasRole("ADMIN")
        .and()
        .formLogin()
                //自定义登陆界面
        .loginPage("/login")
        .failureUrl("/login-error");
    }

    /**
     * 认证信息管理
     * @param auth
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("sotowang").password("123456");

    }

}
