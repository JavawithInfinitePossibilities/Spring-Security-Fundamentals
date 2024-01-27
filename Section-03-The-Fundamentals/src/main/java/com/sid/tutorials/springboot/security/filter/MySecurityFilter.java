/**
 * 
 */
package com.sid.tutorials.springboot.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class MySecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Before request!!!");
		chain.doFilter(request, response);
		System.out.println("After Request!!!");
	}

}
