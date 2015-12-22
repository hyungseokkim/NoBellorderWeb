package com.jang.bea.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jang.bea.model.Postscript;
import com.jang.bea.service.PostscriptService;

@Controller
public class PostscriptController {
	
	@Resource(name = "postscriptService")
	private PostscriptService postscriptService;
	
	

	@ModelAttribute
	public Postscript setUpForm(HttpServletRequest request) {

		Postscript postscript = new Postscript(); 
		return postscript;
	}
	
	//--한줄평(후기) 쓰기 화면 불러오기
	@RequestMapping(value = "/postscriptwriteform", method = RequestMethod.GET)
	public String pswriteView(HttpServletResponse response, HttpServletRequest request, HttpSession session, Model model) throws Exception {
		Object order_table_number = request.getSession().getAttribute("order_table_number");
		Object member_phone = request.getSession().getAttribute("member_phone");
		Object shop_number = request.getSession().getAttribute("shopnumber");
		if(order_table_number ==null || member_phone==null){
			response.sendRedirect(request.getContextPath()+"/shopmain?shop_number="+shop_number);
			
		}
		
		model.addAttribute("member_phone", member_phone);
		model.addAttribute("shop_number", shop_number);
		return "postscriptwriteform";
	}
	
	
	//--한줄평(후기) 등록하기
	@RequestMapping(value = "/postscriptwriteform", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute @Valid Postscript postscript, BindingResult bindingResult) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		try {
			this.postscriptService.insertPostscript(postscript);
			System.out.println("insertController" + postscript.getPostscript_content());
			modelAndView.setViewName("redirect:postscriptlist?shop_number="+postscript.getShop_number());
			modelAndView.addObject("postscript", postscript);
			return modelAndView;
		} catch (DataIntegrityViolationException e) {
			bindingResult.reject("error.duplicate.notice");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;

		}

	}



	//--한줄평(후기)목록 화면
	@RequestMapping(value = "/postscriptlist", method = RequestMethod.GET)
	public String list112(@RequestParam(value = "shop_number", required = false) 
	int shop_number, ModelMap model) throws Exception {
		
		System.out.println("postscriptController"+ shop_number);
		
		List<Postscript> postscriptList = this.postscriptService.getAll(shop_number);
		
		model.addAttribute("postscriptList", postscriptList);
		System.out.println("postscript");

		return "postscriptlist";

	}


	//--한줄평(후기) 수정 화면
	@RequestMapping(value = "/postscriptmodify", method = {RequestMethod.GET, RequestMethod.POST})	
	public String tonoticemodifyView(@RequestParam(value="postscript_number", required=false, defaultValue="0") int postscript_number, Model model)
			throws Exception{
		
		Postscript postscript = postscriptService.getPostscript(postscript_number); 
		
		
		model.addAttribute("postscript", postscript); 

							
		return "postscriptmodify";
	}
	

	//--한줄평(후기) 수정(업데이트)
	@RequestMapping(value = "/pupdate", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView identifyProc123(@ModelAttribute("postscript_number") Postscript postscript, 
			BindingResult bindingResult) throws Exception{
		
		System.out.println("postscript update");
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("update"+postscript.getPostscript_number());
		
		this.postscriptService.UpdatePostscript(postscript);
			modelAndView.addObject("postscript", postscript);
			modelAndView.setViewName("redirect:postscriptlist?shop_number="+postscript.getShop_number());
			
			return modelAndView;
		
		
	}
	
	
}