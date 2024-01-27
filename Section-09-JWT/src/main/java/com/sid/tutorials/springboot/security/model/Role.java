package com.sid.tutorials.springboot.security.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	/**
	 * Bi-Directional relationship will create a cyclic dependency which create a
	 * infinite call to both the class. Due to which the application will fall in to
	 * a stackoverflow error.
	 */
	/*@ManyToMany(mappedBy = "roles")
	private Set<User> users;*/

	@Override
	public String getAuthority() {
		return name;
	}
}
