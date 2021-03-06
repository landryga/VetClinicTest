package com.vetClinic.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	 DataSource dataSource;
	 
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	
	   auth.jdbcAuthentication().dataSource(dataSource)
	  .usersByUsernameQuery(
	   "select username ,password, active from users where active = 1 and username=?")
	  .authoritiesByUsernameQuery(
	   "select u.username, r.role from user_roles r, users u where u.user_id = r.user_id and u.username=?");
	 } 
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/login").permitAll()
		 	.antMatchers("/", "/*todo*/**", "/admin").access("hasRole('ADMIN')")
			.antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
			.formLogin();
	 }

}
