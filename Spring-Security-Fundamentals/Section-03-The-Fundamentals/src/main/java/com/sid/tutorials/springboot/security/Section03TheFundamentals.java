/**
 * 
 */
package com.sid.tutorials.springboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Section03TheFundamentals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section03TheFundamentals.class, args);
	}

}
