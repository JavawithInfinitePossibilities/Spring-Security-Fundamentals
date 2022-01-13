/**
 * 
 */
package com.sid.tutorials.springboot.security.websecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
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
		/* Removing form login authentication as we implements the custom login*/
		/*http.formLogin();*/
		http.authorizeRequests()
				.mvcMatchers(HttpMethod.GET, "/couponapi/getcoupon", "/index", "/showGetCoupon", "/getCoupon",
						"/couponDetails")
				.hasAnyRole("USER", "ADMIN")
				.mvcMatchers(HttpMethod.GET, "/showCreateCoupon", "/createCoupon", "/createResponse").hasRole("ADMIN")
				.mvcMatchers(HttpMethod.POST, "/getCoupon").hasAnyRole("USER", "ADMIN")
				.mvcMatchers(HttpMethod.POST, "/couponapi/couponsave", "/saveCoupon", "/getCoupon").hasRole("ADMIN")
				.mvcMatchers("/", "/login", "/showReg", "/registerUser").permitAll().anyRequest().denyAll().and()
				/*.csrf()
				.disable()*/.logout().logoutSuccessUrl("/");
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
