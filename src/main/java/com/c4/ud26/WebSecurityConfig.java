package com.c4.ud26;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().httpBasic();
	}
}
