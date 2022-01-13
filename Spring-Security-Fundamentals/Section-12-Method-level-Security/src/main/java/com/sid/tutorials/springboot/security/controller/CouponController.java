/**
 * 
 */
package com.sid.tutorials.springboot.security.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.sid.tutorials.springboot.security.model.Coupon;
import com.sid.tutorials.springboot.security.repositories.CouponRepositories;

/**
 * @author Lenovo
 *
 */
@Controller
public class CouponController {

	@Autowired
	private CouponRepositories couponRepositories;

	/**
	 * Created a custom login page.
	 * 
	 * @return
	 */
	/*@GetMapping("/")
	public String index() {
		return "index";
	}*/

	@GetMapping("/showCreateCoupon")
	@PreAuthorize("hasRole('ADMIN')")
	public String showCreateCoupon() {
		return "createCoupon";
	}

	@PostMapping("/saveCoupon")
	public String saveCoupon(Coupon coupon) {
		Coupon couponSave = couponRepositories.save(coupon);
		return "createResponse";
	}

	@GetMapping("/showGetCoupon")
	public String showGetCoupon() {
		return "getCoupon";
	}

	@PostMapping("/getCoupon")
	public ModelAndView getCoupon(String code) {
		ModelAndView modelAndView = new ModelAndView("couponDetails");
		Coupon couponSave = couponRepositories.findByCode(code);
		modelAndView.addObject(couponSave);
		return modelAndView;
	}

	@GetMapping("/getCouponInJSON/{code}")
	public Coupon getCouponInJson(@PathVariable("code") String code) {
		Coupon couponSave = couponRepositories.findByCode(code);
		return couponSave;
	}

}
