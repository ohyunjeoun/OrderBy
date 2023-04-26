package com.ta.orderby.Notice.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.ta.orderby.Notice.model.vo.Notice;

@Mapper
public interface NoticeMapper {
	int selectBoardCount();
	
	
	List<Notice> selectAll(RowBounds bounds);
	
	Notice selectBoardByNo(@Param("n_no")int n_no);
	
	int updateStatus(@Param("n_no") int n_no,@Param("n_status") String n_status);
	
	int insertBoard(Notice notice);


	int updateBoard(Notice notice);


	Boolean plusview(int n_no);
}
