package com.jwt.ejb.businesslogic;

import javax.ejb.Stateless;

import com.jwt.ejb.business.Calculator;

@Stateless
public class CalculatorBean implements Calculator {

	public CalculatorBean() {
		
	}
	
	public Double add(Double a, Double b) {
		return a + b;
	}
}
