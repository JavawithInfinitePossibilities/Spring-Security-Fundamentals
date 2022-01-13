/**
 * 
 */
package com.sid.tutorials.springboot.security;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lenovo
 *
 */
public interface RoleRepositories extends JpaRepository<Role, Long> {

}
