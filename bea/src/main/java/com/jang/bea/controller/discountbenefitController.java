package com.jang.bea.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jang.bea.model.Discount_benefit;
import com.jang.bea.model.Menu;
import com.jang.bea.service.Discount_benefitService;
import com.jang.bea.service.MenuService;


@Controller
public class discountbenefitController {
	
	@Resource(name = "discount_benefitService")
	private  Discount_benefitService discount_benefitService;
	
	
	
	//---이벤트 쿠폰 불러오기
	@RequestMapping(value = "/event")
	public String list(ModelMap model) throws Exception {
		
		List<Discount_benefit> eventlist = this.discount_benefitService.getAll();

		model.addAttribute("eventlist", eventlist);
		System.out.println("discountvenefitController" + eventlist);

		return "event";
	}
	
	
}
