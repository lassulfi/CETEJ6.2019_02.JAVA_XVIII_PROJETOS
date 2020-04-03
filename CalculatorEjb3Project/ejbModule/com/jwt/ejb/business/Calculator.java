package com.jwt.ejb.business;

import javax.ejb.Remote;

@Remote
public interface Calculator {

	Double add(Double a, Double b);
}
