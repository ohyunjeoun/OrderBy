package com.ta.orderby.Dibs.model.service;

import java.util.List;

import com.ta.orderby.Dibs.model.vo.dibs;
import com.ta.orderby.common.util.PageInfo;

public interface DibsService {

	int getdibsCount();

	List<dibs> getDibsList(PageInfo pageInfo);

	dibs finddibsByNo(int m_no);

	int delete(int m_no);

}
