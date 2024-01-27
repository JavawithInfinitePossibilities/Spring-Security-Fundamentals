/**
 * 
 */
package com.sid.tutorials.springboot.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sid.tutorials.springboot.security.model.User;
import com.sid.tutorials.springboot.security.repositories.UserRepositories;
import com.sid.tutorials.springboot.security.websecurityconfig.ISecurityServices;

/**
 * @author Lenovo
 *
 */
@Controller
public class UserController {

	@Autowired
	private ISecurityServices securityServices;

	@Autowired
	private UserRepositories userRepositories;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String index() {
		return "login";
	}

	@PostMapping("/login")
	public String login(String email, String password) {
		boolean loginResponse = securityServices.loginServices(email, password);
		if (loginResponse) {
			return "index";
		}
		return "login";
	}

	@GetMapping("/showReg")
	public String showReg() {
		return "registerUser";
	}

	@PostMapping("/registerUser")
	public String registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User saveUser = userRepositories.save(user);
		return "login";
	}
}
