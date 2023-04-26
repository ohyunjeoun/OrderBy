<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="path" value="${ pageContext.request.contextPath }"/>

<%@ page session="false" %>
<!DOCTYPE HTML>
<!--
	Escape Velocity by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${ path }/resources/static/assets/css/main.css" />
		
		<!-- 상우 2 -->
	    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    	<link rel="stylesheet" href="${ path }/resources/static/assets/css/slide.css">
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
		<!-- 상우 1 -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
		
		<title>Order By</title>
	</head>
	<body class="homepage is-preload">
	
	
	
	
	
	<!-- 상우 -->
	<div id="page-wrapper">
      <!-- Header -->
      <section id="header" class="wrapper" style="background: url('${ path }/resources/static/assets/css/images/banner.jpg'); center; center;">
        <!-- Logo -->
        <div id="logo">
          <h1>Order By</h1>
          <p>단 한번의 선택으로 당신의 위상을 높여드립니다.</p>
        </div>
        <!-- Nav -->
        <nav id="nav">
          <ul>
            <li class="current"><a href="index.html">Order By</a></li>
            <li>
              <a href="#">대여</a>
              <ul>
                <li><a href="#">자동차</a></li>
                <li><a href="#">바이크</a></li>
                <li><a href="#">지도로 검색</a></li>
              </ul>
            </li>
            <li><a href="left-sidebar.html">차종 및 요금</a></li>
            <li>
              <a href="right-sidebar.html">고객센터</a>
              <ul>
                <li><a href="${ path }/mypage/main ">자주 묻는 질문</a></li>
                <li><a href="${ path }/notice/notice ">공지사항</a></li>
              </ul>
            </li>
            <li><a href="no-sidebar.html">회사소개</a></li>
          </ul>
          <a href="${ path }/mypage/dibs" class="button style4 small">Login</a>
        </nav>
      </section>
	
	


      <!-- 이 달의 특가 -->
      <section id="intro" class="wrapper style1" >
        <div class="title"><strong  style="color:#202431; font-size: large;">이 달의 특가</strong></div>
        <div class="container">
          <ul>
            <li>
                <a href="">
                  <div class="month-sale-images">
                      <div class="hover-test"><strong style="color:black;">바로 예약하기</strong></div>
                      <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/롤스로이스 보트테일.png">
                  </div>
                </a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">롤스로이스 <br>보트 테일</h4>
                    <br>
                    <p style="font-size: medium;">대여 비용(일) : <del style="color: red;">12,000,000원</del></p>
                    <span class="material-symbols-outlined" style="color:red">
                      south
                      </span>
                    <p>할인 비용(일) : 8,000,000원</p>
                  </div>
            </li>
            <li>
              <a href="">
                <div class="month-sale-images">
                  <div class="hover-test"><strong style="color:black;">바로 예약하기</strong></div>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/람보르기니 세스토 엘레멘토.png">
                </div>
              </a>
              <div class="add-information"><br>
                <h4 style="color:black; font-size: x-large;">람보르기니 <br>세스토 엘레멘토</h4>
                <br>
                <p style="font-size: medium;">대여 비용(일) : <del style="color: red;">12,000,000원</del></p>
                <span class="material-symbols-outlined" style="color:red">
                  south
                  </span>
                <p>할인 비용(일) : 8,000,000원</p>
              </div>
          </li>
          <li>
            <a href="" class="hover-test">
              <div class="month-sale-images">
                <div class="hover-test"><strong style="color:black;">바로 예약하기</strong></div>
                <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/BMW_M_1000_RR.png">
              </div>
            </a>
            <div class="add-information"><br>
              <h4 style="color:black; font-size: x-large;">BMW <br>M_1000_RR</h4>
              <br>
              <p style="font-size: medium;">대여 비용(일) : <del style="color: red;">12,000,000원</del></p>
              <span class="material-symbols-outlined" style="color:red">
                south
                </span>
              <p>할인 비용(일) : 8,000,000원</p>
            </div>
        </li>
      </ul>
      </section>

            <!-- Highlights -->
      <section id="highlights" class="wrapper style3">
        <div class="title">인기 차종</div>
        <div class="container">
          <div class="swiper-container" >
            <div class="swiper-wrapper">
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" style="width:350px;height:250px;" src="${ path }/resources/static/assets/css/mainImages/롤스로이스 보트테일.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">롤스로이스<br>보트 테일</h4>
                    </div>
                </div>
              </div>
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/람보르기니 세스토 엘레멘토.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">람보르기니<br>세스토 엘레멘토</h4>
                    </div>
                </div>
              </div>
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/마세라티 MC20.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">마세라티<br>MC20</h4>
                    </div>
                </div>
              </div>
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/아우디R8 V12.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">아우디<br>R8 V12</h4>
                    </div>
                </div>
              </div>
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/페라리 F8 스파이더.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">페라리<br>F8 스파이더</h4>
                    </div>
                </div>
              </div>
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/부가티 볼리드.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">부가티<br>볼리드</h4>
                    </div>
                </div>
              </div>
            </div>
            <div class="swiper-button-next"><span class="material-symbols-outlined">
              arrow_forward_ios
              </span></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
            <div class="swiper-button-prev"><span class="material-symbols-outlined">
              arrow_back_ios_new
              </span></div><!-- 이전 버튼 -->

            <!-- 페이징 -->
            <div class="swiper-pagination"></div>
          </div>
        </div>
        <div class="container">
          <div class="swiper-container" >
            <div class="swiper-wrapper">
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/BMW_S1000RR.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">BMW<br>S1000RR</h4>
                    </div>
                </div>
              </div>
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/Ducati_Panigale_V4_R.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">두가티<br>파니갈레 V4 R</h4>
                    </div>
                </div>
              </div>
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/Honda_CBR1000RR-R.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">혼다<br>CBR1000RR-R</h4>
                    </div>
                </div>
              </div>
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/Kawaski ZR1000K.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">가와사키<br>ZR1000K</h4>
                    </div>
                </div>
              </div>
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/Yamaha_FJR-1300AS.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">야마하<br>FJR-1300AS</h4>
                    </div>
                </div>
              </div>
              <div class="swiper-slide">
                <div class="month-sale-images">
                <a href="">
                  <strong style="color:black;" class="hover-test2">바로 예약하기</strong>
                  <img class="sale-image" src="${ path }/resources/static/assets/css/mainImages/Suzuki HAYABUSA.png"></a>
                  <div class="add-information"><br>
                    <h4 style="color:black; font-size: x-large;">스즈키<br>하야부사</h4>
                    </div>
                </div>
              </div>
            </div>
            <br>
            <br>
            
            <div class="swiper-button-next"><span class="material-symbols-outlined">
              arrow_forward_ios
              </span></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
              <div class="swiper-button-prev"><span class="material-symbols-outlined">
                arrow_back_ios_new
                </span></div><!-- 이전 버튼 -->
            
            <!-- 페이징 -->
            <div class="swiper-pagination"></div>
          </div>
        </div>
      </div>
      </div>
    </div>
  </div>
      </section>


      <section id="footer" class="wrapper">
        <div class="container">
          <h1>Order By</h1>
          <br>
          <p class="footer-information">
            사업자등록번호 : 123-45-6789 &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; 대표자 : 정주리
              &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; 주소 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 4F  
              <br>
              전화번호 : 02-123-4567 &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; E-mail : orderby@naver.com
              &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;개인정보관리 책임자 : 한상우 (orderby@naver.com)
              <br> 
              영업시간 : AM 09 : 00 ~ PM 18 : 00&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; 점심시간 : AM 11 : 30 ~ PM 12 : 30
          </p>
          <div id="copyright">
            <ul>
              <li>&copy; Untitled.</li>
              <li>Design: Order By</li>
            </ul>
          </div>
        </div>
      </section>
    </div>
      <script>
        new Swiper('.swiper-container', {

        slidesPerView : 3, // 동시에 보여줄 슬라이드 갯수
        spaceBetween : 30, // 슬라이드간 간격
        slidesPerGroup : 1, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음

        // 그룹수가 맞지 않을 경우 빈칸으로 메우기
        // 3개가 나와야 되는데 1개만 있다면 2개는 빈칸으로 채워서 3개를 만듬
        loopFillGroupWithBlank : true,

        loop : true, // 무한 반복

        pagination : { // 페이징
          el : '.swiper-pagination',
          clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
        },
        navigation : { // 네비게이션
          nextEl : '.swiper-button-next', // 다음 버튼 클래스명
          prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
        },
        });
    </script>


		<!-- Scripts -->
<!-- 			<script src="assets/js/jquery.min.js"></script> -->
			<script src="${ path }/resources/static/assets/js/jquery.min.js"></script>
			<script src="${ path }/resources/static/assets/js/jquery.dropotron.min.js"></script>
			<script src="${ path }/resources/static/assets/js/browser.min.js"></script>
			<script src="${ path }/resources/static/assets/js/breakpoints.min.js"></script>
			<script src="${ path }/resources/static/assets/js/util.js"></script>
			<script src="${ path }/resources/static/assets/js/main.js"></script>

	</body>
</html>
