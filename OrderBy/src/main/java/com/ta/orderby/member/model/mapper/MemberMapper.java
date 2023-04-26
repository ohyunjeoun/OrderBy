package com.ta.orderby.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.session.SqlSession;

import com.ta.orderby.member.model.vo.Member;

@Mapper
public interface MemberMapper {

	Member selectMemberById(@Param("id") String id);
	
	int insertMember(Member member);
	
	int updateMember(Member member);
	
	// 쿼리문에 파라미터 이름이 @Param("no") 임!
	int updateMemberStatus(@Param("no") int no, @Param("status") String status);
}
