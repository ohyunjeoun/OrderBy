package com.ta.orderby.board.model.service;

import java.util.List;

import com.ta.orderby.board.model.vo.Board;
import com.ta.orderby.common.util.PageInfo;

public interface BoardService {
// 추상메소드 자리..
	int getBoardCount();

	List<Board> getBoardlist(PageInfo pageInfo);

	Board findBoardByNo(int no);

	int delete(int no); // 게시글 삭제

	int save(Board board); // 게시글 저장




	

}
