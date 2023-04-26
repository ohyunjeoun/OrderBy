package com.ta.orderby.mypage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ta.orderby.member.model.mapper.MemberMapper;
import com.ta.orderby.member.model.vo.Member;

@Service
public class MypageServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public int save(Member member) {
	int result = 0;
		
		if (member.getMNo() > 0) {
			//update
			result = mapper.updateMember(member);
		}else {
			//insert
			
			member.setMPassword(passwordEncoder.encode(member.getMPassword()));//이렇게 하면 로그인 할 때 암호화가 자동으로 SQL에 입력 된다
			result = mapper.insertMember(member);
		}
		
		
		
		return result;
	}

	@Override
	public Member findMemberById(String mId) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
