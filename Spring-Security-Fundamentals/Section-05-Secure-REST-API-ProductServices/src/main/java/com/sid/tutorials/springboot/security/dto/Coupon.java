package com.sid.tutorials.springboot.security.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Coupon {

	private Long id;
	private String code;
	private BigDecimal discount;
	private String expDate;
}
