/**
 * 
 */
package com.sid.tutorials.springboot.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.tutorials.springboot.security.model.Coupon;

/**
 * @author Lenovo
 *
 */
public interface CouponRepositories extends JpaRepository<Coupon, Long> {

	Coupon getByCode(String couponCode);

	Coupon findByCode(String code);

}
