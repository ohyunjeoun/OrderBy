package com.ta.orderby.Payment.model.service;

import java.util.List;

import com.ta.orderby.Payment.model.vo.payment;
import com.ta.orderby.common.util.PageInfo;

public interface PaymentService {


	int getpaymentCount();

	List<payment> getPaymentList(PageInfo pageInfo);

	

}
