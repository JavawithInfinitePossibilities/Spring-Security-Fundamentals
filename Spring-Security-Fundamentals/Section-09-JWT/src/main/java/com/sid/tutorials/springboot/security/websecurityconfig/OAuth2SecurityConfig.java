/**
 * 
 */
package com.sid.tutorials.springboot.security.websecurityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Lenovo
 *
 */
@Configuration
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
