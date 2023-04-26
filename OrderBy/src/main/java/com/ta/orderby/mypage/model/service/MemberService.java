package com.ta.orderby.mypage.model.service;

import com.ta.orderby.member.model.vo.Member;

public interface MemberService {

	int save(Member member);

	Member findMemberById(String mId);

	

}
