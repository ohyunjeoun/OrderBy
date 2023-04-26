package com.ta.orderby.Reserve.model.service;

import java.util.List;

import com.ta.orderby.Reserve.model.vo.Reserve;
import com.ta.orderby.common.util.PageInfo;

public interface ReserveService {

	int getReserveCount();

	List<Reserve> getReserveList(PageInfo pageInfo);

	Reserve findreserveByNo(int r_no);

	int delete(int r_no);



}
