/**
 * 
 */
package com.sid.tutorials.springboot.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.tutorials.springboot.security.model.Role;

/**
 * @author Lenovo
 *
 */
public interface RoleRepositories extends JpaRepository<Role, Long> {

}
