package com.jang.bea.dao;

import java.util.List;

import com.jang.bea.model.Discount_benefit;

public interface Discount_benefitDao {

List<Discount_benefit> getAll();
	
	Discount_benefit getBenefit(int benefit_number);

	
}
