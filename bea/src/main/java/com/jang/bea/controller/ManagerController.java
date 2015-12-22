package com.jang.bea.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jang.bea.model.Identify;
import com.jang.bea.model.Manager;
import com.jang.bea.model.Order;
import com.jang.bea.service.IdentifyService;
import com.jang.bea.service.ManagerService;
import com.jang.bea.service.OrderService;

@Controller
public class ManagerController {

	String[] order;
	
	@Resource(name = "orderService")
	private OrderService orderService;
	
	@Resource(name = "identifyService")
	private IdentifyService identifyService;
	
	@Resource(name = "managerService") 
	private ManagerService managerService;
	
	
	//--매니저 로그인 화면 불러오기
	@RequestMapping("/managerlogin")
	public String ajlogin(HttpSession session) {	
		session.setAttribute("managermode", "managermode");
		return "managerlogin";
	}
	
	//--매니저 로그인
	@RequestMapping(value= "/managerlogin", method=RequestMethod.POST, headers = {"Accept=text/xml, application/json"})
	public @ResponseBody HashMap<String, Object>onLogin(@Valid @ModelAttribute("Manager") Manager manager, BindingResult bindingResult, 
			HttpServletRequest request,	HttpServletResponse response, HttpSession session) {
		
		System.out.println("ManagerId:"+manager.getM_id()+"ManagerPassword:"+manager.getM_password());
		
		Manager loginManager = this.managerService.getManager(manager.getM_id(), manager.getM_password()); //DB에서 매니저 아이디/비밀번호 가져오기
		
		System.out.println("loginManger "+ loginManager);
		
		HashMap<String, Object> result = new HashMap<String, Object>();//ajax로 로그인하기 위하여 관리자 정보(id, pass)를 JSON으로 변한하기 위해 사용
		
		System.out.println("managerlogin"+ result);
		
		//--아이디 혹은 비밀번호가 잘못 된 경우
		if(loginManager == null){	
			System.out.println("ID 혹은 PASSWORD가 잘못되었습니다!! ");
			
			result.put("id", "Null");// HashMap에 배열 추가
			result.put("msg", "Fail");// HashMap에 배열 추가
			
			System.out.println(result);

		    return result;		
		}
		
		//--로그인 성공
		else {
			System.out.println("loginSuccess!! ");
			session.setAttribute("m_id", loginManager.getM_id()); //세션으로 매니저 아이디 가져오기
			session.setAttribute("m_shopnumber", loginManager.getShop_number()); //세션으로 가게번호 가져오기

			result.put("id", loginManager.getM_id()); // HashMap에 배열 추가
			result.put("msg", "Success");// HashMap에 배열 추가
			result.put("shop_number", loginManager.getShop_number());// HashMap에 배열 추가
			
			System.out.println(result);
			return result;
		}
		
	}
	
	//--매니저 로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.invalidate(); 
		return "redirect:/managerlogin";
	}
	
	//--매니저 로그인 후 메인화면
	@RequestMapping("/managermain")
	public String managermainview(HttpSession session) {	
		session.setAttribute("managermode", "manager");
		
		return "managermain";
	}
	
	//--카운터 (테이블 별 주문 상세 목록)
	@RequestMapping(value = "/counterorderlist",  method = {RequestMethod.POST,RequestMethod.GET})
	public String onCountertableView(@RequestParam(value = "table_number", required = false) int table_number,
	ModelMap model) throws Exception{
		
		System.out.println("counterlist");
		
		List<Order> order = this.orderService.getorder(table_number); //최종 주문 내역 리스트로 불러오기

		model.addAttribute("order", order);//불러온 리스트를 모델에 넣음
		model.addAttribute("table_number",table_number);  //테이블번호를 모델에 넣음
		
		System.out.println("order = " + order);

		return "counterorderlist";
	}
	
	//--카운터 (테이블별 주문 목록)
	@RequestMapping(value = "/countertables",  method = {RequestMethod.POST,RequestMethod.GET})
	public String onCountertables(@RequestParam(value = "table_number", required = false) int table_number,
	ModelMap model) throws Exception{
		
		System.out.println("테이블 별 주문목록");
		
		List<Order> order = this.orderService.getorder(table_number);  //최종 주문 내역 리스트로 불러오기

		model.addAttribute("order", order);//불러온 리스트를 모델에 넣음
		model.addAttribute("table_number", table_number);//테이블번호를 모델에 넣음
		
		System.out.println(" tablesorder " + order);

		return "countertables";
	}
	
	//--카운터 화면 불러오기
	@RequestMapping("/counter")
	public String counterlists(HttpServletRequest request, Model model) {	
		Object m_shopnumber = request.getSession().getAttribute("m_shopnumber");
		model.addAttribute("m_shopnumber", m_shopnumber);
		
		return "counter";
	}
	
	//--매니저 TOP(가게번호, 카운터/주방/공지사항 화면 이동가능)
	@RequestMapping("/managertop")
	public String managertop(HttpServletRequest request, Model model) {	
		
		//세션으로 가게번호, 매니저아이디, 매니저 메인 가져옴		
		Object m_shopnumber = request.getSession().getAttribute("m_shopnumber");
		Object m_id = request.getSession().getAttribute("m_id");
		Object managermode = request.getSession().getAttribute("managermode");
		
		//모델에 가게번호, 매니저아이디, 매니저 메인 담음
		model.addAttribute("m_shopnumber", m_shopnumber);
		model.addAttribute("m_id", m_id);
		model.addAttribute("managermode", managermode);
		
		return "managertop";
	}
	
	//--주방화면 불러오기
	@RequestMapping("/kitchen")
	public String kitchenlists(HttpServletRequest request, Model model) {	
	
		//세션으로 가게번호 가져옴
		Object m_shopnumber = request.getSession().getAttribute("m_shopnumber");
		
		//모델에 가게번호 담음
		model.addAttribute("m_shopnumber", m_shopnumber);
		
		return "kitchen";
	}
	
	
	//--테이블별 상제 주문 메뉴
	@RequestMapping(value = "/kitchentables",  method = {RequestMethod.POST,RequestMethod.GET})
	public String onktichentables(@RequestParam(value = "table_number", required = false) int table_number,
	ModelMap model) throws Exception{
		
		System.out.println("테이블 별 주문 메뉴 화면");
		
		List<Order> order = this.orderService.getorder(table_number); //최종 주문 내역 리스트로 불러오기

		model.addAttribute("order", order);//불러온 리스트를 모델에 넣음
		model.addAttribute("table_number", table_number);// 모델에 테이블 번호 담기
		
		System.out.println("kitchentables " + order);

		return "kitchentables";
	}

	//--주문 승인(주문상태 업데이트)
	@RequestMapping(value = "/orderstate", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView identifyProc1234(@ModelAttribute("Order") Order order, 
			BindingResult bindingResult) throws Exception{
		
		System.out.println("주문상태 업데이트");
		ModelAndView modelAndView = new ModelAndView();
		int tablenumber = order.getTable_number();
		this.managerService.update(order); // 주문승인을 누르면 주문 상태 업데이트하기
		modelAndView.setViewName("redirect:counterorderlist.do?table_number="+tablenumber); //업데이트 하고 카운터 주문화면으로 돌아오게 하기
		System.out.println("테이블번호:"+order.getTable_number());
		System.out.println("상태번호:"+order.getOrder_state());
		System.out.println("주문번호:"+order.getOrder_number());
		
		return modelAndView;
		
	}
	
}
