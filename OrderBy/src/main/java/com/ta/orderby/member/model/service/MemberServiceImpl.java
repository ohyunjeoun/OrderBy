package com.ta.orderby.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ta.orderby.member.model.mapper.MemberMapper;
import com.ta.orderby.member.model.vo.Member;

// 구현내용이 바뀌어서 다른 구현체를 써야할때 결합도를 최소화하기위해 인터페이스를 만들고 그걸 구현한다.
@Service // 비지니스 로직을 처리하는 빈으로 만들거임!
//@Transactional
public class MemberServiceImpl implements MemberService {
//	@Autowired
//	private MemberDao dao;
//	
//	@Autowired
//	private SqlSession session;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	// 회원가입때는 암호화된(인코딩) 값으로 넘길예정 $2a$10$52EUR2ea4FnPkD8G0x81QuWNOEPZSgRTVy.UaiTAgqEECQGt7XuHW << 요딴식임
	
	@Autowired
	private MemberMapper mapper;
	
	// 아이디 조회
	@Override
	public Member findMemberById(String id) {
		
		return mapper.selectMemberById(id);
	}
	
	// 로그인
	@Override
	public Member login(String id, String password) {
		Member member = null;
		
		member = this.findMemberById(id);
		
		// 매번 랜덤한 솔트값을 가지고 암호화 하기 때문에 매번 다른 값으로 암호화 된다.
		System.out.println(passwordEncoder.encode(password));
		
		//matches() 메소드를 사용하면 내부적으로 복화화해서 나온 결과 값에 솔트값을 땐 나머지 값과 원문을 비교한다.
										// matches : 암호화가 되지않은 원문하고 암호화된 문자열을 받아서 둘을 비교하고 동일하면 true가 나온다.
		System.out.println(passwordEncoder.matches(password, member.getMPassword()));
		
		if (member != null && passwordEncoder.matches(password, member.getMPassword())) {
			return member;
		} else {
			return null;
		}
		
	}

	// 회원가입
	@Override
	@Transactional
	public int save(Member member) {
		int result = 0;
		
		if(member.getMNo() > 0) {
			// update
			result = mapper.updateMember(member);
		} else {
			// insert 먼저할거임 (이거 3월 20일 월요일에 안바꿔서 sql문에 null들어갔다고 에러났으니 주의하셈)
			member.setMPassword(passwordEncoder.encode(member.getMPassword()));
			
			result = mapper.insertMember(member);
		}
		
//		if(true) {
//			throw new RuntimeException();
//		}
		
		return result;
	}

	// 아이디 중복검사
	@Override
	public Boolean isDuplicateId(String id) {
		 //널인지 아닌지만 체크허면됨
		
		return this.findMemberById(id) != null;
	}

	// 회원 탈퇴
	@Override
	@Transactional // 중간에 잘못되면 롤백될수있게 트랜잭셔널 어노테이션 붙여줌!
	public int delete(int no) {
		
		return mapper.updateMemberStatus(no, "N");
	}

	
	
	

}
