/**
 * 
 */
package com.sid.tutorials.springboot.security;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lenovo
 *
 */
public interface UserRepositories extends JpaRepository<User, Long> {
	public User findByEmail(String username);
}
