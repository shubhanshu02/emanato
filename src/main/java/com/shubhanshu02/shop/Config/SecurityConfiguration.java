package com.shubhanshu02.shop.Config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/")
        .permitAll();
        //.antMatchers("/admin/**").hasRole("ADMIN")
        //.antMatchers("/user/**").hasRole("USER").antMatchers("/h2-console/**").permitAll();
        // .and()
        // .formLogin()
        // .loginPage("/login")
        // .permitAll()
        // .and()
        // .logout()

    }

}
