package com.wchen.security.config;

import com.wchen.security.mapper.PermissionMapper;
import com.wchen.security.service.SimpleUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    SimpleUserDetailsService simpleUserDetailsService;
    /**
     * 配置认证方式，资源与权限之间的关联
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // .httpBasic  基本认证
//        http.csrf().disable() //跨站资源请求关闭
//                .cors().disable()  // 跨域资源请求关闭
//                .authorizeRequests()  // 授权配置
//                .antMatchers("/test/p1").hasAuthority("p1") // 只有权限p1才能访问
//                .antMatchers("/test/p2").hasAuthority("p2") // 只有权限p2才能访问
//                .anyRequest().authenticated() // 所有请求都需要认证
//                .and().formLogin()   // 登录表单
//                .and().logout();     // 登出表单
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http.authorizeRequests();
        permissionMapper.findAll().forEach(perm -> {
            authorizeRequests.antMatchers(perm.getUrl()).hasAuthority(perm.getCode());
        });
        // 放行login
        authorizeRequests.antMatchers("/login").permitAll()
                .antMatchers("/**").fullyAuthenticated()
                .and().formLogin()
                .and().csrf().disable()
                .logout();
    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        // 账户，可以与登录账户进行比对
//        manager.createUser(User.withUsername("admin1").password("123").authorities("p1").build());
//        manager.createUser(User.withUsername("admin2").password("123").authorities("p2").build());
//        manager.createUser(User.withUsername("admin3").password("123").authorities("p3").build());
//        manager.createUser(User.withUsername("admin4").password("123").authorities("p4").build());
//        return manager;
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(simpleUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 密码校验器， 设置密码的比对方式
     * @return
     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//         return BCryptPasswordEncoder()
//    }



}