/**
 * 
 */
package com.sid.tutorials.springboot.security.websecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Lenovo
 *
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsServicesImpl userDetailsServicesImpl;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServicesImpl);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/couponapi/getcoupon")
				.hasAnyRole("USER", "ADMIN").mvcMatchers(HttpMethod.POST, "/couponapi/couponsave")
				.hasRole("ADMIN").and().csrf().disable();
	}
}
