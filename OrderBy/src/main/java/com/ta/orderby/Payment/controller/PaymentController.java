package com.ta.orderby.Payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ta.orderby.Notice.model.vo.Notice;
import com.ta.orderby.Payment.model.service.PaymentService;
import com.ta.orderby.Payment.model.vo.payment;
import com.ta.orderby.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class PaymentController {
	@Autowired
	private PaymentService service;
	
	@GetMapping("/mypage/payment")
	public ModelAndView paymant(ModelAndView modelAndView,@RequestParam (defaultValue = "1")  int page) {
		int listCount = service.getpaymentCount();
		
		log.info("page: { }",page);
		log.info("listCount: { }",listCount);
		PageInfo pageInfo = new PageInfo(page, 5, listCount, 5);
		List<payment> list = service.getPaymentList(pageInfo);
		
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("list",list);
		modelAndView.setViewName("mypage/payment");
		
		return modelAndView;
	}
}
