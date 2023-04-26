package com.ta.orderby.Payment.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class payment {

	private int p_no;
	
	private String p_method;
	
	private Date p_date;
	
	private int p_tot_price;

	private int p_dis_price;

	private int p_fin_price;
	
	private String p_status;
	
	private int m_no;
	
	private int c_no;
	
	private int mc_no;
	
	private String c_name;
	
	private String mc_name;
}
