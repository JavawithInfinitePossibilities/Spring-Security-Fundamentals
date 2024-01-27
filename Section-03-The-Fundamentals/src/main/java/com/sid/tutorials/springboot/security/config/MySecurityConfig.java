/**
 * 
 */
package com.sid.tutorials.springboot.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.sid.tutorials.springboot.security.filter.MySecurityFilter;

/**
 * @author Lenovo
 *
 */
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MyAuthenticationProvider authenticationProvider;

	@Autowired
	private MySecurityFilter filter;

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		InMemoryUserDetailsManager userDetailsInmemory = new InMemoryUserDetailsManager();
		UserDetails userDetails = User.withUsername("sid").password(passwordEncoder.encode("sahu")).authorities("read")
				.build();
		userDetailsInmemory.createUser(userDetails);
		auth.userDetailsService(userDetailsInmemory) .passwordEncoder(passwordEncoder) ;
	}*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		/*http.formLogin();*/
		http.authorizeRequests().antMatchers("/hello").authenticated()/*.anyRequest().denyAll()*/;
		http.addFilterBefore(filter, BasicAuthenticationFilter.class);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
