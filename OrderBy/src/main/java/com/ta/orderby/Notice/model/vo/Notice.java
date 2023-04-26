package com.ta.orderby.Notice.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
	private int n_no;
	
	private String n_title;

	private Date n_date;
	
	private Date n_re_date;
	
	private String n_content;
	
	private int n_view;
	
	private String n_status;
	
	private int m_no;
	
	private String infofile_id;
	
	
}
