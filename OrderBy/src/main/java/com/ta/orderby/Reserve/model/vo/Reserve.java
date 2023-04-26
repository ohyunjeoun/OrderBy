package com.ta.orderby.Reserve.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Reserve {

	private int r_no;
	
	private String vehicle;
	
	private Date rent_date;
	
	private Date return_date;
	
	private String store;
	
	private int p_no;
}
