package com.xxxx.springsecuritydemo.config;

import com.xxxx.springsecuritydemo.handle.MyAuthenticationFailureHandler;
import com.xxxx.springsecuritydemo.handle.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity 配置类
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单提交
        http.formLogin()
                //更改登录表单的参数别名，转换Security的入参数名称
                .usernameParameter("username1")
                .passwordParameter("password1")
                //当发现/login时认为登录，必须与表单地址一址
                .loginProcessingUrl("/login")
                //自定义登录页面
                .loginPage("/login.html")
                //登录成功后必须是post请求
//                .successForwardUrl("/toMain")
                //登录成功后处理器，不能与successForwardUrl 共存（目的：解决前后端分离）
                .successHandler(new MyAuthenticationSuccessHandler("https://www.baidu.com"))
                //登录失败后必须是post请求
//                .failureForwardUrl("/toError")
                //登录失败后的处理器，不能与failureForwardUrl 共存(目的：解决前后端分离）
                .failureHandler(new MyAuthenticationFailureHandler("/error.html"));

        //授权认证
        http.authorizeRequests()
                //登录页不用认证
                .antMatchers("/login.html").permitAll()
                //错误页不用认证
                .antMatchers("/error.html").permitAll()
                //静态资源文件放行
                .antMatchers("/js/**","/css/**","/images/*").permitAll()
                //任何目录下png后缀的文件都会被放行（正则表达式）
//                .regexMatchers(".+[.]png").permitAll()
                //所有请求都必须被认证
                .anyRequest().authenticated();

        //关闭csrf防火墙
        http.csrf().disable();

    }

    @Bean
    public PasswordEncoder getPw(){
        return  new BCryptPasswordEncoder();
    }
}
