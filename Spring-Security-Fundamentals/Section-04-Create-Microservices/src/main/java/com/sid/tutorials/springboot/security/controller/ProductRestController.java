/**
 * 
 */
package com.sid.tutorials.springboot.security.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sid.tutorials.springboot.security.dto.Coupon;
import com.sid.tutorials.springboot.security.model.Product;
import com.sid.tutorials.springboot.security.repositories.ProductRepositories;

/**
 * @author Lenovo <br/>
 *         URL:
 *         http://localhost:8080/Section-04-Create-Microservices-productservices/productapi/getproduct/1
 *         http://localhost:8080/Section-04-Create-Microservices-productservices/productapi/saveproduct/
 *
 */
@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Value("${couponservices.uri}")
	private String couponServices;

	@Autowired
	private ProductRepositories productRepositories;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public Product saveProduct(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject(couponServices + product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepositories.save(product);
	}

	@RequestMapping(value = "/getproduct/{productId}", method = RequestMethod.POST)
	public Product getProduct(@PathVariable("productId") Long productId) {
		Product product = productRepositories.findById(productId).get();
		return product;
	}

}
