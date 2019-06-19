package com.example.smallshop.api.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity  //启用Web安全功能

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;



    protected void configure(HttpSecurity http) throws Exception {   //通过重载该方法，可配置如何通过拦截器保护请求。


        http
                .authorizeRequests().antMatchers("/js/**","/css/**","/images/*","/bootstrap/**","/style/**","/jquery-easyui-1.8.1/**","layui-v2.5.4","/","/index")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()//基于form表单登录验证
                .loginPage("/login")//自定义登录界面
                .permitAll()
                .and()
                .logout()
                .permitAll();    //无条件访问

    }


}
