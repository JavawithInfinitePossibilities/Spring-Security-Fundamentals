/**
 * 
 */
package com.sid.tutorials.springboot.security.websecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 *
 */
@Service
public class SecurityServicesImpl implements ISecurityServices {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public boolean loginServices(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password,
				userDetails.getAuthorities());
		authenticationManager.authenticate(token);
		boolean authenticated = token.isAuthenticated();
		if (authenticated) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		return authenticated;
	}

}
