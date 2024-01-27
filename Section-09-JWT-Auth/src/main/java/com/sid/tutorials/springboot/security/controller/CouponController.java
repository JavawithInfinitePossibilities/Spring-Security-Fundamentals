/**
 * 
 */
package com.sid.tutorials.springboot.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
