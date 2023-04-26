package com.ta.orderby.board.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ta.orderby.board.model.mapper.BoardMapper;
import com.ta.orderby.board.model.vo.Board;
import com.ta.orderby.common.util.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper; // 얘를 이용해서 쿼리문 수행만 할거임..이렇게 하고 BoardMapper.java 인터페이스 만드셈
	
	@Override
	public int getBoardCount() {
		
		return mapper.selectBoardCount();
	}

	@Override
	public List<Board> getBoardlist(PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
	    int offset = (pageInfo.getCurrentPage() - 1) * limit;
	    RowBounds rowBounds = new RowBounds(offset, limit);
	    
	    return mapper.selectAll(rowBounds);
	}

	@Override
	public Board findBoardByNo(int no) {
		
		return mapper.selectBoardByNo(no);
	}
	
	// 게시글 삭제(는 아니고 status "N"으로 바꿔서 안보이게 하는거임)
	@Override
	@Transactional // 롤백될수있게끔 트렌젝셔널 넣어주기 ㅋㅋ
	public int delete(int no) {

		return mapper.updateStatus(no, "N");
	}

	// 게시글 저장
	@Override
	@Transactional
	public int save(Board board) {
		int result = 0;
		
		if(board.getNo() > 0) {
			// update
			
		} else {
			// insert
			result = mapper.insertBoard(board);
		}
		
		return result;
	}

}
