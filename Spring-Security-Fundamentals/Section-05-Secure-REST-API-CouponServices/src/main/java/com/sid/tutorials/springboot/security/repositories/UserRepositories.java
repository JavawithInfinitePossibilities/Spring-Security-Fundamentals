/**
 * 
 */
package com.sid.tutorials.springboot.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.tutorials.springboot.security.model.User;

/**
 * @author Lenovo
 *
 */
public interface UserRepositories extends JpaRepository<User, Long> {
	public User findByEmail(String username);
}
