package com.jang.bea.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jang.bea.model.Shop;
import com.jang.bea.service.ShopService;


@Controller
public class mainController {
	
	@Resource(name = "shopService")
	private ShopService shopService;
	

	//--가게 홈페이지 메인화면 불러오기
	@RequestMapping("/shopmain")
	public String boardView(@RequestParam(value="shop_number", required=false, defaultValue="0") int shop_number, Model model)
		throws Exception{
		

		int i = 0;
		String star1= "";
		String star2= "";
		Shop shop = shopService.getShop(shop_number); 
		
		//--가게별 평점 불러오기
		int shopgrade = shop.getShop_grade();
		model.addAttribute("shop", shop);
		for(i=0;i<shopgrade;i++){
			star1 += "<img src='./resources/images/star1.png' width='16%'/>";
			}
		for(i=0;i<5-shopgrade;i++){	
			star2 +="<img src='./resources/images/star2.png' width='16%'/>";	
		}
		
		model.addAttribute("stars", star1+star2);
		

		return "shopmain";
	}
	
	//--가게 소개 불러오기
	@RequestMapping("/aboutus")
	public String aboutView(@RequestParam(value="shop_number", required=false, defaultValue="0") int shop_number, Model model)
		throws Exception{
		
		Shop shop = shopService.getShop(shop_number); 
		
		model.addAttribute("shop", shop); 
		
		return "aboutus";
	}

	}
	



