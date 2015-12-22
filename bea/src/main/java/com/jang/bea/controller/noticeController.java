package com.jang.bea.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

import com.jang.bea.model.Notice;
import com.jang.bea.service.IdentifyService;
import com.jang.bea.service.NoticeService;

@Controller
public class noticeController {
	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	@Resource(name = "identifyService")
	private IdentifyService identifyService;


	@ModelAttribute
	public Notice setUpForm(HttpServletRequest request) {

		Notice notice = new Notice(); 
		return notice;
	}

	//--공지사항 글쓰기 화면
	@RequestMapping(value = "/noticewriteform", method = RequestMethod.GET)
	public String tonoticewriteView() {
		return "noticewriteform";
	}
	

	//--공지사항 목록
	@RequestMapping(value = "/noticelist", method = RequestMethod.GET)
	public String list112(@RequestParam(value = "shop_number", required = false) 
	int shop_number, ModelMap model, HttpServletRequest request) throws Exception {
		Object m_shopnumber = request.getSession().getAttribute("m_shopnumber");
		Object managermode = request.getSession().getAttribute("managermode");
		System.out.println("noticeController"+ shop_number);
		
		List<Notice> noticeList = this.noticeService.getAll(shop_number);
		List<Notice> noticeListSpecial = this.noticeService.getSpecial(shop_number);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticeListSpecial", noticeListSpecial);
		model.addAttribute("shop_number", shop_number);
		model.addAttribute("m_shopnumber", m_shopnumber);
		
		System.out.println("notice ");

		return "noticelist";

	}

		//--공지사항 등록
	@RequestMapping(value = "/noticewrite", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute @Valid Notice notice, BindingResult bindingResult) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		try {
			this.noticeService.insert(notice); 
			modelAndView.setViewName("redirect:noticelist?shop_number="+notice.getShop_number());
			modelAndView.addObject("notice", notice);
			return modelAndView;
		} catch (DataIntegrityViolationException e) {
			bindingResult.reject("error.duplicate.notice");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;

		}

	}

	//--공지사항 글보기 
	@RequestMapping("/noticeview")
	public String boardView(HttpServletRequest request, @RequestParam(value="notice_number", required=false, defaultValue="0") int notice_number, Model model)
																							throws Exception{
		Notice notice = noticeService.getNotice(notice_number);
		Object m_shopnumber = request.getSession().getAttribute("m_shopnumber");
		
		model.addAttribute("notice", notice); 
		model.addAttribute("m_shopnumber", m_shopnumber);
		return "noticeview";
	}
	
	
	//--공지사항 글 수정 화면 불러오기
	@RequestMapping(value = "/noticemodify", method = RequestMethod.GET)	
	public String tonoticemodifyView(@RequestParam(value="notice_number", required=false, defaultValue="0") int notice_number, Model model)
			throws Exception{
		
		Notice notice = noticeService.getNotice(notice_number); 
		
		
		model.addAttribute("notice", notice); 

							
		return "noticemodify";
	}
	

	//--공지사항 글 수정
	@RequestMapping(value = "/nupdate", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView identifyProc123(@ModelAttribute("notice_number") Notice notice, 
			BindingResult bindingResult) throws Exception{
		
		System.out.println("notice update");
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("update"+notice.getNotice_number());
		
		this.noticeService.update(notice);
		
			modelAndView.addObject("notice", notice);
			modelAndView.setViewName("redirect:noticeview?shop_number="+notice.getShop_number()+"&notice_number="+notice.getNotice_number());
			System.out.println("테이블번호:"+notice.getNotice_number());
			return modelAndView;
		
		
	}

	//--공지사항 글 삭제
	@RequestMapping(value = "/noticedelete", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView identifyProc1232(@ModelAttribute("Notice") Notice notice, int notice_number,
			BindingResult bindingResult) throws Exception{
		
		System.out.println("Notice delete");
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("anj"+notice.getShop_number());
	
		
		this.noticeService.delete(notice);
		System.out.println("anj"+ notice.getNotice_number());
		
			modelAndView.addObject("notice", notice);
			modelAndView.setViewName("redirect:noticelist?shop_number="+notice.getShop_number());
			System.out.println("shopnumber"+notice.getShop_number());
			return modelAndView;
		
		
	}
	
	
}