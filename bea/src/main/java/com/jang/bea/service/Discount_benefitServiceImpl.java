package com.jang.bea.service;

import java.util.List;

import com.jang.bea.dao.Discount_benefitDao;
import com.jang.bea.model.Discount_benefit;

public class Discount_benefitServiceImpl implements Discount_benefitService {
	
private Discount_benefitDao discount_benefitDao;
	
	public void setDiscount_benefitDao(Discount_benefitDao discount_benefitDaoimpl) {
	this.discount_benefitDao = discount_benefitDaoimpl;
}
	@Override
	public List<Discount_benefit> getAll() {
		// TODO Auto-generated method stub
		return this.discount_benefitDao.getAll();
	}

	@Override
	public Discount_benefit getBenefit(int benefit_number) {
		// TODO Auto-generated method stub
		return this.discount_benefitDao.getBenefit(benefit_number);
	}

}
