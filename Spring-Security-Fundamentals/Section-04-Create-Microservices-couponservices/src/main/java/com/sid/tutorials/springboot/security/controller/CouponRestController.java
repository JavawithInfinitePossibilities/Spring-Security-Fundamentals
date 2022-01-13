/**
 * 
 */
package com.sid.tutorials.springboot.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.tutorials.springboot.security.model.Coupon;
import com.sid.tutorials.springboot.security.repositories.CouponRepositories;

/**
 * @author Lenovo <br/>
 *         URL:
 *         http://localhost:9090/Section-04-Create-Microservices-couponservices/couponapi/getcoupon/NEWYEAR
 *         http://localhost:9090/Section-04-Create-Microservices-couponservices/couponapi/couponsave/
 *
 */
@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	private CouponRepositories couponRepositories;

	@RequestMapping(value = "/couponsave", method = RequestMethod.POST)
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponRepositories.save(coupon);
	}

	@RequestMapping(value = "/getcoupon/{couponCode}", method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("couponCode") String couponCode) {
		return couponRepositories.getByCode(couponCode);
	}
}
