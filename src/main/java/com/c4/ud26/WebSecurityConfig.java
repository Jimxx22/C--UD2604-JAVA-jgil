package com.c4.ud26;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	protected void configure(HttpSecurity http) throws Exception{
		http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/**").authenticated()
        .antMatchers(HttpMethod.GET,"/**").authenticated()
        .antMatchers(HttpMethod.POST,"/**").authenticated()
        .antMatchers(HttpMethod.PUT, "/**").authenticated()
        .antMatchers(HttpMethod.DELETE,"/**").authenticated()
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().httpBasic();
		
		/*http.authorizeRequests().anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().httpBasic();*/
	}
}
