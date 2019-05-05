package xjtu.soto.access.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import xjtu.soto.access.service.CustomUserService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String KEY = "xjtuse";

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    /**
     * 自定义配置
     * @param http
     * @throws Exception
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //都允许访问
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index", "/module/login","/department/**")
                .permitAll()
                //需要相应的角色才能访问
//                .antMatchers("/users/**").hasRole(UserPermissionEnum.ADMIN.getCode().toString())
                .antMatchers("h2-console/**").permitAll()
                .and()
                .formLogin()
                //自定义登陆界面
                .loginPage("/module/login")
                .failureUrl("/module/login")
                //启用remember me
                .and().rememberMe().key(KEY)

//                处理异常，拒绝访问就重定向到403
                .and().exceptionHandling().accessDeniedPage("/403")
        ;

        //禁用H2控制台的CSRF防护
        http.csrf().ignoringAntMatchers("/h2-console/**");

        //允许来自同一来源的H2控制台请求
        http.headers().frameOptions().sameOrigin();
    }


}
