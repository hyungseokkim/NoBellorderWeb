package com.jang.bea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.jang.bea.model.Order;
import com.jang.bea.service.IdentifyService;
import com.jang.bea.service.OrderService;

@Controller
public class OrderController {
	String[] order;
	int checktable;
	int checkstate;
	
	@Resource(name = "orderService")
	private OrderService orderService;
	
	@Resource(name = "identifyService")
	private IdentifyService identifyService;
	

	//--최중주문내역 불러오기
	@RequestMapping(value = "/orderlist",  method = {RequestMethod.POST,RequestMethod.GET})
	public String onIdentifyView(@RequestParam(value = "table_number", required = false) int table_number,
	ModelMap model) throws Exception{
		
		System.out.println("주문내역페이지");
		
		List<Order> order = this.orderService.getorder(table_number); //최종주문내역 리스트로 불러오기

		model.addAttribute("order", order);//불러온 리스트 모델에 담기
		model.addAttribute("table_number", table_number);// 모델에 테이블 번호 담기
		
		System.out.println("최종123 = " + order);

		return "orderlist";
	}
	
	//--최종 주문하기
	@RequestMapping(value = "/orderinsert", method = {RequestMethod.POST,RequestMethod.GET})
	public String identifyProc14(@ModelAttribute("Order") Order order,int menu_number, int table_number,int order_state, 
			HttpServletRequest request,	HttpServletResponse response, HttpSession session, BindingResult bindingResult, ModelMap model) throws Exception{ 
		
		checktable = this.orderService.checktable(table_number); //최중 주문내역에 테이블 번호가 있는지 확인하기
		checkstate = this.orderService.checkstate(order_state); //최종 주문 내역의 주문 상태 불러오기
		checkstate = order.getOrder_state();//최종주문내역의 상태 담기
		System.out.println("--------------------------");
		System.out.println("checkstate"+order.getOrder_state());
		System.out.println("check====table"+checktable);
		System.out.println("check+++state"+checkstate);
		session.setAttribute("order_table_number", table_number); //세션으로 테이블 번호 가져오기
		
		//-- 테이블번호가 있고 주문상태가 주문완료(조리전)일 경우 주문내역를 업데이트함
		if(checktable>0 && checkstate == 1){

		ModelAndView modelAndView = new ModelAndView();
		System.out.println("getChecktable/"+ checktable +"테이블중복됨" + order.getTable_number());
		modelAndView.setViewName("redirect:identifylist.do?table_number="+table_number);// 임시주문목록 화면으로 가게 함
		this.orderService.update(order); // 최종주문내역을 업데이트함
		System.out.println("update"+order.getMenu_name());
		modelAndView.setViewName("redirect:orderlist.do?table_number="+table_number);// 업데이트 후 최종 주문 내역 화면으로 넘어가게함
		System.out.println("getordergrossvalue"+ order.getOrder_grossvalue());
		System.out.println("getCheck_discount"+ order.getCheck_discount());
		System.out.println("getCheck_price"+ order.getCheck_price());
		System.out.println("업데이트됩니다");
		model.addAttribute("update", "업데이트됩니다"); // 모델에 업데이트됩니다 라는 문구를 담음
			
			List<Order> order1 = this.orderService.getorder(table_number); //최종주문내역 리스트로 불러오기

			model.addAttribute("order", order1);// 불러온 리스트 모델에 담기
			model.addAttribute("table_number", table_number); // 테이블번호 모델에 담기
			
			System.out.println("최종123 = " + order1);

			return "orderlist";
			
		//--테이블 번호가 있고 주문상태가 조리중 일 경우 업데이트가 불가능함.
		}else if(checktable>0 && checkstate > 1){
			
			ModelAndView modelAndView = new ModelAndView();
			System.out.println("변경 불가능해요");
			model.addAttribute("noup", "이미 조리중 입니다."); // 모델에 '이미 조리중 입니다.'라는 문구를 담음
			
			
			List<Identify> identify = this.identifyService.getIdentify(table_number);// 임시주문목록을 리스트로 불러옴
			List<Order> order1 = this.orderService.getorder(table_number);// 최종주문 내역을 리스트로 불러옴
			

			model.addAttribute("identify", identify);//불러온 임시주문목록 리스트를 모델에 담음
			model.addAttribute("order", order1);// 불러온 최종주문내역 리스트를 모델에 담음
			
			System.out.println("돌린다!!!!"+identify.get(0).getMenu_name());
			ArrayList<HashMap<String, Object>> //JSON으로 변환하기위해 HashMap리스트를 작성
			identifyhlist = new ArrayList<HashMap<String, Object>>();
			try{
				HashMap<String, Object> identifymap = new HashMap<String, Object>();

			/*여기부터 list를 hashMap변환*/
			for(int i=0; i<identify.size();i++){	
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
			}catch (Exception e) {//예외처리
		        System.out.println("RS to List error");
		        identifyhlist = null;
		    }
			
			String identifyhlists = new Gson().toJson(identifyhlist);// hashMap리스트를 Json으로 변환하여 String화 시킨다.
			model.addAttribute("identifyhlist",identifyhlists);
			System.out.println(identifyhlists);
			
			return "identify";
		
		//--테이블 번호가 없는 최종 주문 하기 전일경우 최종 주문 내역에 담기
		}else{
			
			System.out.println("테이블중복안됨"+ order.getTable_number());
			
			ModelAndView modelAndView = new ModelAndView();		
			this.orderService.insert(order); //최종 주문 내역 DB에 insert하기
			System.out.println("테이블중복안됨"+ order.getTable_number());
			System.out.println("getOther"+ order.getOrder_etc());
				System.out.println("getordergrossvalue"+ order.getOrder_grossvalue());
				System.out.println("getCheck_discount"+ order.getCheck_discount());
				System.out.println("getCheck_price"+ order.getCheck_price());

				List<Order> order1 = this.orderService.getorder(table_number); //최종주문내역 리스트로 불러오기

				model.addAttribute("order", order1);// 불러온 리스트 모델에 담기
				model.addAttribute("table_number", table_number); // 모델에 테이블 번호 담기
				
				System.out.println("최종123 = " + order1);

				return "orderlist";
		}
		

		
	}

}