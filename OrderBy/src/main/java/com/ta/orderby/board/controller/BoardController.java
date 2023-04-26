package com.ta.orderby.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ta.orderby.board.model.service.BoardService;
import com.ta.orderby.board.model.vo.Board;
import com.ta.orderby.common.util.PageInfo;
import com.ta.orderby.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
	
	// 파일첨부관련 빈 주입받는거임(스프링에서 제공함)
	@Autowired
	private ResourceLoader resourceLoader;
	
//	메소드의 리턴 타입이 void 일 경우 Mapping URL을 유추해서 View를 찾는다.
//	@GetMapping("/board/list")
//	public void list() {
//	}
	
	// 게시글 리스트 조회
	@GetMapping("/list")
	public ModelAndView list(ModelAndView modelAndView, @RequestParam(defaultValue = "1") int page) {
		int listCount = service.getBoardCount();
		
		log.info("Page : {}", page);
		log.info("ListCount : {}", listCount);
		
		PageInfo pageInfo = new PageInfo(page, 10, listCount, 10);
		List<Board> list = service.getBoardlist(pageInfo);
		
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("board/list");
		
		return modelAndView;
	}
	
	// 게시글 상세 조회
	@GetMapping("/view")
//	public ModelAndView view(ModelAndView modelAndView, @RequestParam("no") int no) {
	public ModelAndView view(ModelAndView modelAndView, @RequestParam int no) {
		Board board = null;
		
		log.info("no : {}", no);
		
		board = service.findBoardByNo(no);
		
		modelAndView.addObject("board", board);
		modelAndView.setViewName("/board/view");
		
		return modelAndView;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(ModelAndView modelAndView, @RequestParam int no,
				@SessionAttribute("loginMember") Member loginMember) {
		int result = 0;
		Board board = null;
		
		board = service.findBoardByNo(no);
		
		if(board != null && board.getWriterId().equals(loginMember.getMId())) {
			result = service.delete(no);
			
			if(result > 0) {
				modelAndView.addObject("msg", "게시글이 정상적으로 삭제되었습니다.");
				modelAndView.addObject("location", "/board/list");
			} else {
				modelAndView.addObject("msg", "게시글이 삭제를 실패하였습니다.");
				modelAndView.addObject("location", "/board/view?no=" + no);
			}
		} else {
			modelAndView.addObject("msg", "잘못된 접근입니다.");
			modelAndView.addObject("location", "/board/list");
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
//	// 글쓰기 페이지로 요청
//	@GetMapping("/write")
//	public String write() {
//		log.info("게시글 작성 페이지 요청");
//		
//		return "board/write";
//	}
//	
//	// 글쓰기하고 서브밋했을때 post
//	@PostMapping("/write")
//	public ModelAndView write(
//			ModelAndView modelAndView,
//			@ModelAttribute Board board,
//			@RequestParam("upfile") MultipartFile upfile,
//			@SessionAttribute("loginMember") Member loginMember) {
//		
//		// 파일 저장(save)할때 정수 받아오는 변수임!
//		int result = 0;
//		// 파일을 업로드하지 않으면 true, 파일을 업로드하면 false
//		log.info("upfile.isempty() : {}", upfile.isEmpty());
//		// 파일을 업로드하지 않으면 "", 파일을 업로드하면 "파일명"
//		log.info("upfile.getOriginalFilename() : {}", upfile.getOriginalFilename());
//		
//		// 1. 파일을 업로드 했는지 확인 후 파일을 저장
//		if(upfile != null && !upfile.isEmpty()) {
//				String location = null;
//				String renamedFileName = null;
//				
//			try {
//																					//파일로부터 경로(패스)를 얻어옴
////				location = resourceLoader.getResource("file:resources/upload/board").getFile().getPath(); // 최상위부터 경로 찾음
////				location = resourceLoader.getResource("classPath:resources/upload/board").getFile().getPath(); // 클래스패스에서부터 경로 찾음
//				location = resourceLoader.getResource("resources/upload/board").getFile().getPath();
//				
//				// 실제로 물리적 경로에 저장하는 새로운(랜덤) 파일명을 리턴함
//				renamedFileName = MultipartFileUtil.save(upfile, location);
//				
//				System.out.println(renamedFileName);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//			// 파일이 업로드되었는지 확인한 후에 저장하는 로직
//			if(renamedFileName != null) {
//				board.setOriginalFileName(upfile.getOriginalFilename());
//				board.setRenamedFileName(renamedFileName);
//			}
//		}
//		
//		// 2. 작성한 게시글 데이터를 데이터 베이스에 저장
//		board.setWriterNo(loginMember.getNo());
//		
//		result = service.save(board);
//		
//		if(result > 0) {
//			modelAndView.addObject("msg", "게시글이 정상적으로 등록되었습니다.");
//			// 게시글 등록이 완료되면 바로 게시글 볼 수 있게끔!
//			modelAndView.addObject("location", "/board/view?no=" + board.getNo());
//		} else {
//			modelAndView.addObject("msg", "게시글 등록을 실패하였습니다.");
//			modelAndView.addObject("location", "/board/write");
//		}
//		
//		modelAndView.setViewName("common/msg");
//		
//		return modelAndView;
//	}
	
	
	
	
	
	
}
