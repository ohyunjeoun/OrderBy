package com.ta.orderby.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ta.orderby.member.model.vo.Member;
import com.ta.orderby.mypage.model.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MypageController {

	@GetMapping("/mypage/main") //회원수정페이지 
 	public String myPage() {
 		log.info("회원 정보 수정 페이지 요청");

 		return "mypage/main";
 	}
	
	@Autowired
	private MemberService service;
	
	
	
	@PostMapping("/mypage/main")
	public ModelAndView update(
				ModelAndView modelAndView,
				@SessionAttribute("loginMember") Member loginMember,
				@ModelAttribute Member member) {

		int result = 0;

		member.setMNo(loginMember.getMNo());

		log.info(member.toString());

		result = service.save(member);

		if(result > 0) {
			modelAndView.addObject("loginMember", service.findMemberById(loginMember.getMId()));
			modelAndView.addObject("msg", "회원 정보 수정을 완료했습니다.");
		} else {
			modelAndView.addObject("msg", "회원 정보 수정을 실패했습니다.");			
		}

		modelAndView.addObject("location", "/mypage/main");
		modelAndView.setViewName("common/msg");

		return modelAndView;
	}


	
	
}
