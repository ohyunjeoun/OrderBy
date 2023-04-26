package com.ta.orderby.Notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ta.orderby.Notice.model.service.NoticeService;
import com.ta.orderby.Notice.model.vo.Notice;
import com.ta.orderby.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NoticeController {
	@Autowired
	private NoticeService service;
	
//	@Autowired
//	private ResourceLoader resourceLoader;
	
	@GetMapping("/notice/notice")
	public ModelAndView notice(ModelAndView modelAndView,@RequestParam(defaultValue = "1") int n_no,@RequestParam (defaultValue = "1")  int page
			) {
		int listCount = service.getBoardCount();
		
		service.plusview(n_no);
		
		log.info("page: { }",page);
		log.info("listCount: { }",listCount);
//		System.out.println(service.getBoardCount());
		
		PageInfo pageInfo = new PageInfo(page, 5, listCount, 5);
		List<Notice> list = service.getBoardList(pageInfo);
		
		
		
		modelAndView.addObject("pageInfo",pageInfo);
		modelAndView.addObject("list",list);
		modelAndView.setViewName("notice/notice");
		
		return modelAndView;
	}
	
	
	@GetMapping("notice/view")
	public ModelAndView view(ModelAndView modelAndView,  @RequestParam int n_no) {
		Notice notice = null;
	
		
		log.info("n_no : {} ", n_no);
		
		notice = service.findBoardByNo(n_no);
		
		
//		log.info("공지사항 뷰 불러오기");

		modelAndView.addObject("notice",notice);
		modelAndView.setViewName("notice/view");
		
		return modelAndView;
	}
	
	
	@GetMapping("notice/delete")
	public ModelAndView delect(ModelAndView modelAndView, @RequestParam (defaultValue = "1") int n_no){
		//@SessionAttribute("loginMember") Member loginMember
		int result = 0;
		Notice notice = null;
		
		notice = service.findBoardByNo(n_no);
		
		result =service.delete(n_no);
		if (result > 0) {
			
			modelAndView.addObject("msg", "게시글이 삭제 성공");
			modelAndView.addObject("location", "/notice/notice");
		}else {
			modelAndView.addObject("msg", "게시글 삭제 실패");
			modelAndView.addObject("location", "/notice/view?n_no=" + n_no);
		}
		

		modelAndView.setViewName("common/msg");
		
		return modelAndView;
		

	}
	
	
	@GetMapping("notice/update")
	public String update() {
		log.info("게시글 작성");
		return "notice/update";
	}
	
	@PostMapping("notice/update")
	public ModelAndView update(ModelAndView modelAndView, @ModelAttribute Notice notice) {
		int result = 0;
		result = service.save(notice);
		
		if (result >0) {
			modelAndView.addObject("msg", "게시글 등록 완료");
			modelAndView.addObject("location", "/notice/view?n_no=" + notice.getN_no());
		}else {
			modelAndView.addObject("msg", "게시글 등록 실패");
			modelAndView.addObject("location", "/notice/update");
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	

	   @GetMapping("notice/write")
	   public ModelAndView write(ModelAndView modelAndView,@RequestParam (defaultValue = "1") int n_no ) {
		   
		   	Notice notice = null;
			
			notice = service.findBoardByNo(n_no);
		   
		   
		   modelAndView.addObject("notice",notice);
		   modelAndView.setViewName("notice/write");
		   
		   return modelAndView;
	   }
	   
	   @PostMapping("notice/write")
	   public ModelAndView write(ModelAndView modelAndView,
			   @RequestParam int n_no, @RequestParam String n_title, @RequestParam String n_content) {
		   Notice notice =null;
		   int result = 0;
		   notice = service.findBoardByNo(n_no);
		   
		   result = service.save(notice);
		   
		   log.info("{}, {}, {} ", new Object[] {n_no, n_title, n_content});
		   
		   if (result > 0) {
			modelAndView.addObject("msg", "게시글 수정 성공");
			modelAndView.addObject("location", "/notice/view?n_no="+  notice.getN_no());
		}else {
			 modelAndView.addObject("msg", "게시글 수정 실패");
			 modelAndView.addObject("location", "/notice/notice?n_no=" + notice.getN_no());
		}
		   
		   modelAndView.setViewName("common/msg");
		   
		   return modelAndView;
	   }
	   

}
