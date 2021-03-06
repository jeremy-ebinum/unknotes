package com.example.unknotes.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(HttpMethod.GET, "/api/notes").permitAll()
        .antMatchers(HttpMethod.GET, "/api/notes/{id}").permitAll()
        .anyRequest().authenticated()
        .and()
        .oauth2Login()
        .and()
        .oauth2ResourceServer().jwt();
  }
}
