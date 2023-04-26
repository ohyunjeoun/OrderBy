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
<title>Insert title here</title>
<script src="${ path }/js/jquery-3.6.3.js"></script>
    <style>
        div {
            /* border: 1px solid  wheat; */
            box-sizing: border-box;
        }


        /* 전체를 감싸는 div */
        .wrap {
            width: 1000px;
            height: 800px;
            margin: auto;
        }

        #header {
            height: 20%;
        }

        #content {
            height: 50%;
        }

        #footer {
            height: 20%;
        }

        #content>div {
            height: 100%;
            float: left;
            /* display: inline-block; */
        }

        #content1 {
            width: 15%;
        
            
        }

        #content2 {
            width: 85%;
            /* margin-left: -4px; */
            padding-left: 5%;
            padding-right: 10%;
            padding-top: 3%;
        
        
            
            
        }

        table.type02 {
        border-collapse: separate;
        border-spacing: 0;
        /* text-align: left; */
        line-height: 1.6;
        border-top: 1px solid #ccc;
        border-left: 1px solid #ccc;
        margin : 30px 10px;
        border-left: none;
        }
        table.type02 th {
        width: 150px;
        padding: 10px;
        font-weight:600;
        vertical-align: top;
        border-right: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
        /* border-top: 1px solid #fff; */
        border-left: 1px solid #fff;
        background: #eee;
        }
        table.type02 td {
        width: 400px;
        padding: 10px;
        vertical-align: top;
        border-right: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
        border-right: none;
        }
        .mypagelogo{
        font-size: 14pt;
        list-style-type: none;
        line-height: 200%;

        }

    #menu div {
    /* position: relative; */
    /* display: inline-block; */
    }

    span {
    /* display: flex; */
    /* width: 200px; */
    padding: 2px 16px;
    /* cursor: pointer; */
    }

    /* 말풍선 적절한 top 과 margin-left 로 위치조정 */
    .arrow_box {
    display: none;
    /* position: absolute; */
    width: 100px;
    padding: 8px;
    /* left: 10; */
    /* -webkit-border-radius: 8px; */
    /* -moz-border-radius: 8px; */
    /* border-radius: 8px; */
    background: gray;
    color: #fff;
    font-size: 10px;
    }


    span:hover + p.arrow_box {
    display: block;
    }

    .find-btn{
	text-align: center;
    padding-right: 10%;
    
}
    .find-btn1{
	display :inline-block;
    width: 60px;
    height: 25px;
    color: black;
    background-color: whitesmoke;
    border: none;
    cursor: pointer;
    
    
}
a{
    text-decoration: none;
    color: black;
}
a:hover{
    color: gray;
}    

    </style>
</head>
<body>
    <div class="wrap">
        <div id="header"></div>
        <!-- <div id="content"><div id="content1"></div><div id="content2"></div></div> -->
        <div id="content">
            <div id="content1">
                <h1 class="l_title">My 페이지</h1>
                <br><br><br><br>

                <ul class="mypagelogo">
                    <li><a href="${ path }/mypage/main" class="on"  >개인정보</a></li>
                    <li><a href="${ path }/mypage/payment" class="on">결제내역</a></li>
                    <li><a href="${ path }/mypage/reserve" class="on" >예약확인</a></li>
                    <li><a href="${ path }/mypage/dibs" class="on" >찜목록</a></li>
                </ul>
            </div>
            <div id="content2">
                <br><br><h2>개인정보</h2>
                <form action="${ path }/main"method="POST">
                <table class="type02">
                    <tr>
                    <th scope="row">이름</th>
                    <td><input type="text" name="mName" id="userId" size="12" maxlength="12" style="border: none;"
                        value="${ loginMember.mName }" readonly></td>
                    </tr>
                        <tr>
                        <th scope="row" >아이디</th>
                        <td><input type="text" name="mId" id="newId" style="border: none;"
                            value="${ loginMember.mId }" readonly required ></td>
                        </tr>
                           <tr>
                              <th scope="row">비밀번호</th>
                                <td><input type="password" id="userPwd1" name="mPassword" size="12" maxlength="12"  value="${ loginMember.mPassword }" style="border: none;"></td>
                           </tr>
                    <tr>
                    <th scope="row">생년월일</th>
                    <td><input type="text" name="mBirth" id="userbr" size="12" maxlength="12" style="border: none;"
                        value="${ loginMember.mBirth }" readonly></td>
                    </tr>
  					<tr>
                    <th scope="row">전화번호</th>
                    <td><input type="text" name="mPhone" id="phone" size="12" maxlength="12" style="border: none;"
                        value="${ loginMember.mPhone }"></td>
                    </tr> 
                        <tr>
                        <th scope="row">이메일</th>
                        <td><input type="text" name="mEmail" id="email" size="30" maxlength="30" value="${ loginMember.mEmail }" readonly style="border: none;"></td>
                        </tr>
                        <tr>
                    <th scope="row" style="table-layout:fixed;">등급</th>
                    <div id="menu"><td><input value="${ loginMember.mRole }" type="text" 
                     name="mRole" id="grade" size="10" maxlength="30"
                       style="border: none;"><span><img src="${ path }/resources/static/assets/css/images/main.png" style="width: 16px;"></span>
                        <p class="arrow_box">
                            첫 렌트 시 브론즈 <br>
                            3번 렌트 시 실버 5%  <br>
                            7번 렌트 시 골드 10%  <br>
                            15번 다이아 20%  </p>
                        </div></td>
                    
                    </tr>                    
                <tr>
                <th scope="row">주소</th>
                <td><input    value="${ loginMember.mAddress }" type="text" name="mAddress" id="addr" size="20" maxlength="30"  style="border: none;"></td>
                </tr>   
                <tr>
                    <th scope="row">포인트</th>
                    <td><input    value="${ loginMember.mPoint }" type="text" name="mPoint" id="point" size="20" maxlength="30"  style="border: none;"></td>
                    </tr>
                </table>
                <div class="find-btn">
                    <input  type="submit" id="btnUpdate" value="수정"  class="btn btn-navy navbar-btn find-btn1" >
                    <input  type="button"  id="btnDelete" value="탈퇴"  class="btn btn-navy navbar-btn find-btn1" >
                </div>
                </form>
        </div>
        <div id="footer"></div>
    </div>
</div>
  <script>
	$(document).ready(() => {
		$('#btnDelete').on('click', () => {
			let url = '${ path }/mypage/main'; // 연동하고 jsp파일 만들고~
			let status = 'left=2500px,top=200px,width=500px,height=250px'; 
		
			open(url, 'updatePwd', status);
		});
		
		$('#btnDelete').on('click', () => {
			if(confirm('정말로 탈퇴하시겠습니까?')) {
				location.replace('${ path }/member/delete');
			}
		});
	});
</script>
</body>
</html>