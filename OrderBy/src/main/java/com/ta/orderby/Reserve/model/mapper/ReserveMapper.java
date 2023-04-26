package com.ta.orderby.Reserve.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.ta.orderby.Reserve.model.vo.Reserve;

@Mapper
public interface ReserveMapper {
	
	int selecReserveCount();
	
	List<Reserve> selectAll(RowBounds bounds);
	
	Reserve selectReserveByNo(@Param("r_no")int r_no);
	
	int updateStatus(@Param("r_no") int r_no);
}
