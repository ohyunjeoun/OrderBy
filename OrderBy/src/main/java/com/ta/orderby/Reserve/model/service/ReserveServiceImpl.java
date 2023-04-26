package com.ta.orderby.Reserve.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ta.orderby.Reserve.model.mapper.ReserveMapper;
import com.ta.orderby.Reserve.model.vo.Reserve;
import com.ta.orderby.common.util.PageInfo;

@Service
public class ReserveServiceImpl implements ReserveService {

	@Autowired
	private ReserveMapper mapper;
	
	@Override
	public int getReserveCount() {
		
		return mapper.selecReserveCount();
	}

	@Override
	public List<Reserve> getReserveList(PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
	    int offset = (pageInfo.getCurrentPage() - 1) * limit;
	    RowBounds rowBounds = new RowBounds(offset, limit);
	    
		return mapper.selectAll(rowBounds);
	}

	@Override
	public Reserve findreserveByNo(int r_no) {
		return mapper.selectReserveByNo(r_no);
	}

	@Override
	public int delete(int r_no) {
		
		return mapper.updateStatus(r_no);
	}


}
