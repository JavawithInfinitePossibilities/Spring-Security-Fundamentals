/**
 * 
 */
package com.sid.tutorials.springboot.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.tutorials.springboot.security.model.Product;

/**
 * @author Lenovo
 *
 */
public interface ProductRepositories extends JpaRepository<Product, Long> {

}
