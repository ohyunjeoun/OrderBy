package com.ta.orderby.Payment.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.ta.orderby.Payment.model.vo.payment;

@Mapper
public interface PaymentMapper {
	
	 int selecPaymentCount();

	List<payment> selectAll(RowBounds bounds);
}
