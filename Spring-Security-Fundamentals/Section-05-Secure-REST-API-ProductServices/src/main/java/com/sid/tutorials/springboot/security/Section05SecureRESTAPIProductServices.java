/**
 * 
 */
package com.sid.tutorials.springboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
public class Section05SecureRESTAPIProductServices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section05SecureRESTAPIProductServices.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
