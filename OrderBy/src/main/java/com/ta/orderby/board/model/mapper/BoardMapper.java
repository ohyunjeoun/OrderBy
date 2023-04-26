package com.ta.orderby.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.ta.orderby.board.model.vo.Board;

@Mapper
public interface BoardMapper {
	// 내가 실행시키고자하는 쿼리문의 id값을 넣어주고 추상메소드 만들고, 쿼리문 참고해서 반환타입 지정해주면된다!!!!
	int selectBoardCount();
	
	List<Board> selectAll(RowBounds bounds);
	
	Board selectBoardByNo(@Param("no") int no);
	
	int updateStatus(@Param("no") int no, @Param("status") String status);
	// 이런거 다 쓰면 서비스가면됨

	int insertBoard(Board board);
}
