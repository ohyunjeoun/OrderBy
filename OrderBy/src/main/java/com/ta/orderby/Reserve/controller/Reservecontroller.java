package com.ta.orderby.Reserve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ta.orderby.Notice.model.vo.Notice;
import com.ta.orderby.Reserve.model.service.ReserveService;
import com.ta.orderby.Reserve.model.vo.Reserve;
import com.ta.orderby.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class Reservecontroller {
	@Autowired
	private ReserveService service;
	
	
	@GetMapping("/mypage/reserve")
	public ModelAndView reserve (ModelAndView modelAndView,@RequestParam (defaultValue = "1")  int page) {
		int listCount = service.getReserveCount();
		
		log.info("page: { }",page);
		log.info("list: { }",listCount);
		
		
		
		PageInfo pageInfo = new PageInfo(page, 5, listCount, 5);
		
		List<Reserve> list = service.getReserveList(pageInfo);
		
		System.out.println(list);
		
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("list",list);
		modelAndView.setViewName("mypage/reserve");
		
		return modelAndView;
	}
	
	@GetMapping("/reserve/delete")
	public ModelAndView delete(ModelAndView modelAndView,@RequestParam (defaultValue = "2") int r_no) {
		
		
		int result = 0;
		Reserve reserve = null;
		
		reserve = service.findreserveByNo(r_no);
		
		result =service.delete(r_no);
		if (result > 0) {
			
			modelAndView.addObject("msg", " 예약취소 완료");
			modelAndView.addObject("location", "/mypage/reserve");
		}else {
			modelAndView.addObject("msg", "예약취소 실패");
			modelAndView.addObject("location", "/mypage/reserve?r_no=" + r_no);
		}

		modelAndView.setViewName("common/msg");
		return modelAndView;
	}
}
