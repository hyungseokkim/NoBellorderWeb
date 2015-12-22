package com.jang.bea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.jang.bea.model.Identify;
import com.jang.bea.model.Menu;
import com.jang.bea.model.Order;
import com.jang.bea.service.IdentifyService;
import com.jang.bea.service.MenuService;
import com.jang.bea.service.OrderService;

@Controller
public class identifyController {

	int checkmenu;

	@Resource(name = "identifyService")
	private IdentifyService identifyService;

	@Resource(name = "menuService")
	private MenuService menuService;

	@Resource(name = "orderService")
	private OrderService orderService;

	@ModelAttribute
	public Identify setUpForm(HttpServletRequest request) {

		Identify identify = new Identify();
		return identify;
	}

	// --임시 주문 목록 불러오기
	@RequestMapping(value = "/identifylist", method = { RequestMethod.POST, RequestMethod.GET })
	public String onIdentifyView(@RequestParam(value = "table_number", required = false) int table_number,
			ModelMap model) throws Exception {

		System.out.println("주문내역페이지");

		List<Identify> identify = this.identifyService.getIdentify(table_number); //임시주문목록 리스트로 불러오기
		List<Order> order = this.orderService.getorder(table_number); //주문내역 리스트로 불러오기(주문 상태 불러오기위해)

		model.addAttribute("identify", identify); //리스트로 불러온 임시주문목록을 모델에 담기
		model.addAttribute("order", order); //리스트로 불러온 최종주문내역을 모델에 담기

		System.out.println("돌린다!!!!" + identify.get(0).getMenu_name());
		
		ArrayList<HashMap<String, Object>> //JSON으로 변환하기위해 HashMap리스트를 작성
		identifyhlist = new ArrayList<HashMap<String, Object>>();
		
		try {
			HashMap<String, Object> identifymap = new HashMap<String, Object>();

			/* 여기부터 list를 hashMap변환(임시주문에서 AngularJs사용을 위해 Jason변환작업) */
			for (int i = 0; i < identify.size(); i++) {
				identifymap = new HashMap<String, Object>();

				identifymap.put("check_number", identify.get(i).getCheck_number());
				identifymap.put("table_number", identify.get(i).getTable_number());
				identifymap.put("menu_number", identify.get(i).getMenu_number());
				identifymap.put("check_amount", identify.get(i).getCheck_amount());
				identifymap.put("check_price", identify.get(i).getCheck_price());
				identifymap.put("menu_name", identify.get(i).getMenu_name());
				identifymap.put("check_discount", identify.get(i).getCheck_discount());
				identifyhlist.add(identifymap);
			}
		} catch (Exception e) { //예외처리
			System.out.println("RS to List error");
			identifyhlist = null;
		}

		String identifyhlists = new Gson().toJson(identifyhlist); // hashMap리스트를 Json으로 변환하여 String화 시킨다.
		model.addAttribute("identifyhlist", identifyhlists);
		System.out.println(identifyhlists);

		return "identify";
	}

	// --임시 주문 목록에서 메뉴 삭제하기
	@RequestMapping(value = "/identifydelete", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView identifyProc123(@ModelAttribute("Identify") Identify identify, BindingResult bindingResult)
			throws Exception {

		System.out.println("DB에 delete");
		ModelAndView modelAndView = new ModelAndView();
		int tablenumber = identify.getTable_number();
		System.out.println("getCheck_number" + identify.getCheck_number());

		this.identifyService.delete(identify); //선택하는 메뉴 DB에서 삭제하기
		System.out.println("getCheck_amount" + identify.getCheck_amount());

		modelAndView.addObject("identify", identify);
		modelAndView.setViewName("redirect:identifylist.do?table_number=" + tablenumber); // 삭제하고나서 임시 주문목록으로 돌아오게함 
		System.out.println("테이블번호:" + identify.getTable_number());
		return modelAndView;

	}

	// --임시주문 목록에서 수량 업데이트 하기
	@RequestMapping(value = "/identifyupdate", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView identifyProc1234(@ModelAttribute("Identify") Identify identify, BindingResult bindingResult)
			throws Exception {

		System.out.println("DB에update");
		ModelAndView modelAndView = new ModelAndView();
		int tablenumber = identify.getTable_number();
		System.out.println("upadate" + identify.getCheck_number());

		this.identifyService.update(identify); // 선택한 메뉴 수량 고치면 DB에서 업데이트
		System.out.println("upadate" + identify.getCheck_amount());

		modelAndView.addObject("identify", identify);
		modelAndView.setViewName("redirect:identifylist.do?table_number=" + tablenumber); // 삭제하고나서 임시 주문목록으로 돌아오게함 
		System.out.println("테이블번호:" + identify.getTable_number());
		return modelAndView;

	}

	// --임시 주문 목록에 메뉴 담기
	@RequestMapping(value = "/identify", method = { RequestMethod.POST, RequestMethod.GET })
	public String identifyProc14(@ModelAttribute("Identify") Identify identify, int menu_number, int table_number,
			BindingResult bindingResult, ModelMap model) throws Exception {
		System.out.println("getMenu_number" + checkmenu + "중복됨");
		System.out.println("getMenu_number" + checkmenu + "중복됨" + identify.getMenu_number());
		System.out.println("getMenu_number" + checkmenu + "중복됨" + identify.getTable_number());
		
		checkmenu = this.identifyService.checkmenu(menu_number, table_number); // 메뉴가 임시주문목록에 있는지 검사

		// --임시 주문 목록에 해당 메뉴가 있을경우
		if (checkmenu > 0) {
			ModelAndView modelAndView = new ModelAndView();
			System.out.println("getMenu_number" + checkmenu + "중복됨");
			modelAndView.setViewName("redirect:recipeform1.do?table_number=" + table_number); //메뉴 주문화면으로 돌아옴
			System.out.println("chmenu");
			model.addAttribute("chmenu", "이미 담겨있습니다"); // 모델에 이미 담겨있다는 문구를 담음

			List<Menu> list1 = this.menuService.getMenu_division1(); // 메뉴구분 1인 메뉴들을 리스트로 불러옴
			model.addAttribute("table_number", table_number);
			model.addAttribute("list1", list1);
			System.out.println("list_Bean 1 = " + list1);

			return "recipelist";
		}

		// --임시 주문 목록에 해당 메뉴가 없을경우
		else {
			ModelAndView modelAndView = new ModelAndView();
			int tablenumber = identify.getTable_number();

			this.identifyService.insert(identify); // 임시주문 목록 DB에 담음
			System.out.println("중복안됨" + identify.getMenu_number());

			modelAndView.addObject("identify", identify);
			modelAndView.setViewName("redirect:recipeform1.do?table_number=" + table_number); // 담고나서 임시 주문목록으로 돌아오게함 
			System.out.println("테이블번호:" + identify.getTable_number());
			model.addAttribute("chmenu1", "주문표에  담겼습니다"); //모델에 주문표에 담겼다는 문구를 담음

			List<Menu> list1 = this.menuService.getMenu_division1(); // 메뉴구분 1인 메뉴들을 리스트로 불러옴
			model.addAttribute("table_number", table_number);
			model.addAttribute("list1", list1);
			System.out.println("list_Bean 1 = " + list1);

			return "recipelist";
		}

	}

}