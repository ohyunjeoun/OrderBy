package com.ta.orderby.Dibs.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ta.orderby.Dibs.model.mapper.DibsMapper;
import com.ta.orderby.Dibs.model.vo.dibs;
import com.ta.orderby.common.util.PageInfo;

@Service
public class DibsServiceImpl implements DibsService {
	@Autowired
	private DibsMapper mapper;
	
	
	@Override
	public int getdibsCount() {
		
		return mapper.selecdibsCount();
	}

	@Override
	public List<dibs> getDibsList(PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
	    int offset = (pageInfo.getCurrentPage() - 1) * limit;
	    RowBounds rowBounds = new RowBounds(offset, limit);
		return mapper.selectAll(rowBounds);
	}

	@Override
	public dibs finddibsByNo(int m_no) {
		
		return mapper.selectdibsByNo(m_no);
	}

	@Override
	public int delete(int m_no) {
		return  mapper.updateStatus(m_no);
	}

}
