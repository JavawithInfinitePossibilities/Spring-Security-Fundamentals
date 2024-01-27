/**
 * 
 */
package com.sid.tutorials.springboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo
 *
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Welcome to Spring security!!!";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Spring security with spring boot!!!";
	}
}
