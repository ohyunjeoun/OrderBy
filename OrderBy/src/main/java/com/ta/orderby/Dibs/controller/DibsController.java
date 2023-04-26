package com.ta.orderby.Dibs.controller;

import java.util.List;

import javax.swing.plaf.synth.SynthScrollPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ta.orderby.Dibs.model.service.DibsService;
import com.ta.orderby.Dibs.model.vo.dibs;
import com.ta.orderby.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DibsController {
	
	@Autowired
	private DibsService service;

	@GetMapping("/mypage/dibs")
	public ModelAndView dibs(ModelAndView modelAndView,@RequestParam (defaultValue = "1")  int page) {
		int listCount = service.getdibsCount();
		
		log.info("page: { }",page);
		log.info("listCount: { }",listCount);
		PageInfo pageInfo = new PageInfo(page, 5, listCount, 5);
		List<dibs> list = service.getDibsList(pageInfo);
		
		System.out.println(list);
		
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("list",list);
		modelAndView.setViewName("mypage/dibs");
		
		return modelAndView;
	}
	
	@GetMapping("/dibs/delete")
	public ModelAndView delete(ModelAndView modelAndView,    @RequestParam (defaultValue = "1") int m_no) {
		int result = 0;
		dibs dibs = null;
		
		dibs =service.finddibsByNo(m_no);
		result = service.delete(m_no);
		
		
		
		if (result > 0) {
			
			
			modelAndView.addObject("msg", "예약취소 완료");
			modelAndView.addObject("location", "/mypage/dibs");
		}else {
			modelAndView.addObject("msg", "취소 실패");
			modelAndView.addObject("location", "/mypage/dibs?m_no=" + m_no);
		}


		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
}
