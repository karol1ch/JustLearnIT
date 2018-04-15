package com.brainstormers.justlearnit.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("szymon").password("szymon").roles("ADMIN"))
                .withUser(users.username("dawid").password("dawid").roles("ADMIN"))
                .withUser(users.username("tosia").password("tosia").roles("ADMIN"))
                .withUser(users.username("karol").password("karol").roles("ADMIN"))
                .withUser(users.username("marcin").password("marcin").roles("ADMIN"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/authTheUser")
                .permitAll()
                .and()
                .logout().permitAll();
    }
}
