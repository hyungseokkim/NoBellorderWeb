package com.jang.bea.controller;

import java.util.List;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jang.bea.model.Discount_benefit;
import com.jang.bea.model.Identify;
import com.jang.bea.model.Menu;
import com.jang.bea.model.Menu_division;
import com.jang.bea.model.Notice;
import com.jang.bea.service.Discount_benefitService;
import com.jang.bea.service.IdentifyService;
import com.jang.bea.service.MenuService;
import com.jang.bea.service.Menu_divisionService;
import com.jang.bea.service.NoticeService;

@Controller
public class menuController {

	@Resource(name = "menuService")
	private MenuService menuService;

	@Resource(name = "identifyService")
	private IdentifyService identifyService;

	int discount;

	@RequestMapping(value = "/menu")
	public String list(ModelMap model) throws Exception {
		int discount;

		List<Menu> menulist = this.menuService.getbenefit();

		model.addAttribute("menulist", menulist);
		System.out.println("menulist " + menulist);

		return "menu";
	}

	//--주문 메뉴 목록 불러오기
	@RequestMapping(value = "/recipeHome", method = RequestMethod.GET)
	public String list121(@RequestParam(value = "table_number", required = false) int table_number,
			ModelMap model) throws Exception {
		System.out.println("recipeHome " + table_number);
		model.addAttribute("table_number", table_number);

		return "recipeHome";
	}

	//--메뉴구분탭1(돈까스)
	@RequestMapping(value = "/recipeform1", method = RequestMethod.GET)
	public String list1(@RequestParam(value = "table_number", required = false) int table_number,
			ModelMap model) throws Exception {

		System.out.println("list_Bean111 ");
		List<Menu> list1 = this.menuService.getMenu_division1(); //메뉴구분 1에 해당하는 내용 리스트로 불러오기
		model.addAttribute("table_number", table_number);//모델에 테이블 번호 담기
		model.addAttribute("list1", list1);// 불러온 리스트 모델에 담기
		System.out.println("list_Bean 1 = " + list1);

		return "recipelist";

	}
	//--메뉴구분탭2(파스타)
	@RequestMapping(value = "/recipeform2", method = RequestMethod.GET)
	public String list2(@RequestParam(value = "table_number", required = false) int table_number,
			ModelMap model) throws Exception {
		System.out.println("list_Bean22 ");
		List<Menu> list2 = this.menuService.getMenu_division2();//메뉴구분 2에 해당하는 내용 리스트로 불러오기
		model.addAttribute("table_number", table_number);//모델에 테이블 번호 담기
		model.addAttribute("list2", list2);// 불러온 리스트 모델에 담기
		System.out.println("list_Bean2 = " + list2);
		return "recipelist2";
	}

	//--메뉴구분탭3(피자)
	@RequestMapping(value = "/recipeform3", method = RequestMethod.GET)
	public String list3(
			@RequestParam(value = "table_number", required = false) int table_number,
			ModelMap model) throws Exception {
		System.out.println("list_Bean33");
		List<Menu> list3 = this.menuService.getMenu_division3();//메뉴구분 3에 해당하는 내용 리스트로 불러오기
		model.addAttribute("table_number", table_number);//모델에 테이블 번호 담기
		model.addAttribute("list3", list3);// 불러온 리스트 모델에 담기
		System.out.println("list_Bean3 = " + list3);
		return "recipelist3";
	}

	//--메뉴구분탭4(샐러드)
	@RequestMapping(value = "/recipeform4", method = RequestMethod.GET)
	public String list4(
			@RequestParam(value = "table_number", required = false) int table_number,
			ModelMap model) throws Exception {
		System.out.println("list_Bean4");
		List<Menu> list4 = this.menuService.getMenu_division4();//메뉴구분 4에 해당하는 내용 리스트로 불러오기
		model.addAttribute("table_number", table_number);//모델에 테이블 번호 담기
		model.addAttribute("list4", list4);// 불러온 리스트 모델에 담기
		System.out.println("list_Bean4 = " + list4);
		return "recipelist4";
	}

	//--메뉴구분탭5(음료/주류)
	@RequestMapping(value = "/recipeform5", method = RequestMethod.GET)
	public String list5(
			@RequestParam(value = "table_number", required = false) int table_number,
			ModelMap model) throws Exception {
		System.out.println("list_Bean55");
		List<Menu> list5 = this.menuService.getMenu_division5();//메뉴구분 5에 해당하는 내용 리스트로 불러오기
		model.addAttribute("table_number", table_number);
		model.addAttribute("list5", list5);// 불러온 리스트 모델에 담기
		System.out.println("list_Bean5 = " + list5);
		return "recipelist5";
	}

}
