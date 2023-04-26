package com.ta.orderby.Payment.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ta.orderby.Notice.model.vo.Notice;
import com.ta.orderby.Payment.model.mapper.PaymentMapper;
import com.ta.orderby.Payment.model.vo.payment;
import com.ta.orderby.common.util.PageInfo;

@Service
public class MyServiceImpl implements PaymentService {
	@Autowired
	private PaymentMapper mapper;
	



	@Override
	public int getpaymentCount() {
		return mapper.selecPaymentCount();
	}




	@Override
	public List<payment> getPaymentList(PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
	    int offset = (pageInfo.getCurrentPage() - 1) * limit;
	    RowBounds rowBounds = new RowBounds(offset, limit);
	    
		return mapper.selectAll(rowBounds);
	}





}
