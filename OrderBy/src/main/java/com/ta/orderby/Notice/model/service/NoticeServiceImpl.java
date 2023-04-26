package com.ta.orderby.Notice.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ta.orderby.Notice.model.mapper.NoticeMapper;
import com.ta.orderby.Notice.model.vo.Notice;
import com.ta.orderby.common.util.PageInfo;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper mapper;
	
	@Override
	public int getBoardCount() {
		return mapper.selectBoardCount();
	}

	@Override
	public List<Notice> getBoardList(PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
	    int offset = (pageInfo.getCurrentPage() - 1) * limit;
	    RowBounds rowBounds = new RowBounds(offset, limit);
	      
	      
		return mapper.selectAll(rowBounds);
	}

	@Override
	public Notice findBoardByNo(int n_no) {
		return mapper.selectBoardByNo(n_no);
	}

	@Override
	@Transactional
	public int delete(int n_no) {
		
		return mapper.updateStatus(n_no, "N");
	}

	@Override
	@Transactional
	public int save(Notice notice) {
		int result = 0;
		
		if (notice.getN_no() > 0) {
			result = mapper.updateBoard(notice);
		}else {
			result = mapper.insertBoard(notice);
		}
		
		return result;
		
	}


	@Override
	public Boolean plusview(int n_no) {
		
		return mapper.plusview(n_no);
	}
}
