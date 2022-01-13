/**
 * 
 */
package com.sid.tutorials.springboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
@EnableWebSecurity
public class Section05SecureRESTAPICouponServices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section05SecureRESTAPICouponServices.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
