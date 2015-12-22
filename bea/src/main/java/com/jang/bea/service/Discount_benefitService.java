package com.jang.bea.service;

import java.util.List;

import com.jang.bea.model.Discount_benefit;

public interface Discount_benefitService {
	
	List<Discount_benefit> getAll();
	
	Discount_benefit getBenefit(int benefit_number);

}
