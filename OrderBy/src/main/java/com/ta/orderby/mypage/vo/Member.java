package com.ta.orderby.mypage.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private int mNo; // 회원 번호 SEQ (PK)

	private String mId; // 회원 아이디
	
	private String mPassword; // 회원 비밀번호
	
	private String mName; // 가입자 이름
	
	private String mBirth; // 가입자 생년월일
	
	private String mEmail; // 가입자 이메일
	
	private String mPhone; // 가입자 전화번호
	
	private String mGender; // 가입자 성별

	private String mAddress; // 가입자 주소

	private String mDetailAdd; // 가입자 상세주소
	
	private int mPoint; // 회원 보유 포인트 default 0
	
	private String mRole; // 회원등급 (브론즈, 실버, 골드, 다이아, 마스터(관리자)) default 브론즈
	
	private Date mEnrollDate; // 가입일자 default sysdate

	private Date mModifyDate; // 정보 수정일자 default sysdate
	
	private String mStatus; // 회원상태 (Y회원, N탈퇴) default Y
	
	private int mCnum; // 인증번호 default 0

	
	public Member(String mId, String mPassword) {
		this.mId = mId;
		this.mPassword = mPassword;
	}
}


