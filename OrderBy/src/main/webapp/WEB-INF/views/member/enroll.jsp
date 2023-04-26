<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/resources/css/member/enroll.css">
<script src="${ path }/resources/js/jquery-3.6.3.js"></script>
<title>회원가입</title>
</head>
<body>
	<c:if test="${ empty loginMember }">
		<form name="enrollForm" action="#" method="POST">
		    <div class="mainSignup">
		        <!--웹페이지 상단-->
		        <header>
		            <!-- LOGO -->
		
		        </header>
		
		        <!--회원가입 부분-->
		        <section class="signupWrap">
		
		            <div>
		                <!--아이디,비번,비번재확인-->
		                <h3>아이디</h3>
		                <span class="signupInput">
		                    <input id="memberId" type="text" name="memberId" placeholder="" required autofocus />
		                    <!-- <span class="signupAt">@naver.com</span> -->
		                    <span class="point successIdChk"></span><br/>
		                    <input type="hidden" id="idDoubleChk"/>
		                </span>
		
		                <h3>비밀번호</h3>
		                <span class="signupInput">
		                    <input id="memberPwd" type="text"></input>
		                    <span class="pwdLock"></span>
		                </span>
		
		                <h3>비밀번호 재확인</h3>
		                <span class="signupInput">
		                    <input id="memberPwdd" type="text"></input>
		                    <span class="pwddLock"></span>
		                </span>
		
		            </div>
		
		            <div style="margin-top: 35px;">
		                <!--이름,생년월일,성별,이메일-->
		                <h3>이름</h3>
		                <span class="signupInput">
		                    <input id="memberName" type="text" name="memberName" maxlength="8" placeholder="이름을 입력해주세요." required/>
		                </span>
		
		                <h3>생년월일</h3>
		                <span style="display: flex;">
		                    <span class="signupInputBirth">
		                        <input id="signupBirthYY" type="text" placeholder="년(4자)"></input>
		                    </span>
		                    <span class="signupInputBirth" style="margin-left: 10px;">
		                        <select id="signupBirthMM" class="selectbox" name="month" onchange="">
		                            <option value="month">월</option>
		                            <option value="1"> 1 </option>
		                            <option value="2"> 2 </option>
		                            <option value="3"> 3 </option>
		                            <option value="4"> 4 </option>
		                            <option value="5"> 5 </option>
		                            <option value="6"> 6 </option>
		                            <option value="7"> 7 </option>
		                            <option value="8"> 8 </option>
		                            <option value="9"> 9 </option>
		                            <option value="10"> 10 </option>
		                            <option value="11"> 11 </option>
		                            <option value="12"> 12 </option>
		                        </select>
		                    </span>
		                    <span class="signupInputBirth" style="margin-left: 10px;">
		                        <input id="signupBirthDD" type="text" placeholder="일"></input>
		                    </span>
		                </span>
		
		                <h3>성별</h3>
		                <span class="signupInput">
		                    <select id="memberGender" class="selectbox" name="gender" onchange="">
		                        <option value="gender">성별</option>
		                        <option value="man">남자</option>
		                        <option value="woman">여자</option>
		                        <option value="no">선택 안함</option>
		                    </select>
		                </span>
		
		                <span class="choice">
		                    <h3>본인 확인 이메일</h3>
		                    <span>(선택)</span>
		                </span>
		                <span class="signupInput">
		                    <input id="memberEmail" type="text" placeholder="선택입력"></input>
		                </span>
		
		            </div>
		
		            <div style="margin-top: 35px;">
		                <!--휴대전화-->
		                <h3>휴대전화</h3>
		                <span class="signupInput">
		                    <select id="memberCountry" class="selectbox" name="country" onchange="">
		                        <option value="ko">대한민국 +82</option>
		                    </select>
		                </span>
		                <div style="display: flex;">
		                    <span class="signupInput" style="width:100%; margin: 10px 0px 0px 0px">
		                        <input id="memberPhone" type="text" placeholder="전화번호 입력"></input>
		                    </span>
		                    <span class="cnum_btn_wrap">
		                        <button id="cnum_btn">인증번호 받기</button>
		                    </span>
		                </div>
		                
		                <span class="signupInput_c" style="margin-top: 10px;">
		                    <input id="memberCnum" type="text" placeholder="인증번호 입력하세요"></input>
		                </span>
		            </div>
		
		            <div>
		                <!--가입하기-->
		                <div class="signup_btn_wrap">
		                    <button id="signup_btn">가입하기</button>
		                </div>
		            </div>
		        </section>
		
		        <!--저작권 정보-->
		        <footer>
		            <div class="copyright_wrap" style="font-size: 12px;">
		                <span>이용약관 | 개인정보처리방침 | 책임의 한계와 고지 | 회원정보 고객센터</span>
		                <div>© NAVER Corp.</div>
		            </div>
		        </footer>
		    </div>
		</form>
	</c:if>
<script src="${path}/resources/js/member/enroll.js"></script>
</body>
</html>