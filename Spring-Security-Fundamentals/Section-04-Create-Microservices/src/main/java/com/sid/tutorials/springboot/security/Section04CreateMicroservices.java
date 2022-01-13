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
public class Section04CreateMicroservices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section04CreateMicroservices.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
