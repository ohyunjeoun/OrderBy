package com.ta.orderby.Notice.model.service;

import java.util.List;

import com.ta.orderby.Notice.model.vo.Notice;
import com.ta.orderby.common.util.PageInfo;

public interface NoticeService {

	int getBoardCount();

	List<Notice> getBoardList(PageInfo pageInfo);

	Notice findBoardByNo(int n_no);

	int delete(int n_no);

	int save(Notice notice);

	Boolean plusview(int n_no);
	
 

}
