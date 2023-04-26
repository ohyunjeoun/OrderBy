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
            padding-left: 10%;
            padding-right: 10%;
            padding-top: 3%;
        
        
            
            
        }
        .mypagelogo{
        font-size: 14pt;
        list-style-type: none;
        line-height: 200%;

        }
        
        a{
    text-decoration: none;
    color: black;
}
a:hover{
    color: gray;
}    

.d-none{
    display: none;
}
 
.board{
    width: 1200px;
    height: 100%;
    margin: auto;
}
 
.table{
    font-size :13px;
    border-collapse: collapse;
    width: 800px;
    /* margin-top:200px; */
    border: 1px solid #ccc;    
    text-align: center;
    border-left: none;
    border-right: none;
    
}
.thead td {
    background: #eee;
    font-size: 11px;
}
 
td{
    height: 40px;
    border-bottom:1px solid #ccc;
}
 
tr td:nth-child(2){
    width: 500px;
}
 
/* ********페이징******** */
.page-nation li{ 
    list-style: none;
} 
 
.page-wrap {
    text-align:center;
    font-size:0px;
 }
.page-nation  {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top:20px;
    margin-right:400px;
}
 
.page-nation a {
    display:block;
    margin:0 3px;
    float:left;
    border:1px solid #e6e6e6;
    width:28px;
    height:28px;
    line-height:28px;
    text-align:center;
    background-color: whitesmoke;
    font-size:11px;
    color: black;
    text-decoration:none;
    font-weight:bold;
    border: none;
}
.page-nation a:hover{
    background-color:gray;
    color:white;
}

.main1{
    padding-left: 50%;
}

    </style>
</head>
<body>
<div class="wrap">
        <div id="header"></div>
        <!-- <div id="content"><div id="content1"></div><div id="content2"></div></div> -->
        <div id="content">

            <div id="content2">
                <br><br><h1 class="main1">공지사항</h1>
                <section class="main">
                    <h1 class="d-none">게시판</h1>
                        <div class="board">
                            <table class="table">
                                <thead class="thead">
                                    <tr>
                                        <td>NO</td>
                                        <td>제목</td>
                                        
                                        <td>작성일</td>
                                        <td>조회수</td>
                                    </tr>
                                </thead>
                                 <tbody class="tbody">
                                 <c:if test="${ empty list }">
			                    <tr>
			                  <td colspan="4">
			                     조회된 게시글이 없습니다.
			                  	</td>
			               		</tr>   
                                </c:if>
                                
                                <c:if test="${ not empty list }">
                                <c:forEach var="notice" items="${ list }">
                                 
                                    <tr>
                                        <td>${ notice.n_no }</td>
                                        <td><a href="${ path }/notice/view?n_no=${notice.n_no}">${ notice.n_title }</a></td>
                                        <td><fmt:formatDate  type="date" value="${ notice.n_date }"/></td>
                                        <td>${ notice.n_view }</td>
                                    </tr>
                                        </c:forEach>
                                        </c:if>
                                    </tbody>
                            </table>
                            
                            
         <div class="page-wrap">
                         
            <!-- 맨 처음으로 -->
            <div class="page-nation">
            <button onclick="location.href='${ path }/notice/notice?page=1'">&lt;&lt;</button>
   
            <!-- 이전 페이지로 -->
            <button onclick="location.href='${ path }/notice/notice?page=${ pageInfo.prevPage }'">&lt;</button>
   
            <!--  10개 페이지 목록 -->
            <c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" varStatus="status">
               <c:choose>
                  <c:when test="${ status.current == pageInfo.currentPage}">
                     <button disabled>${ status.current }</button>
                  </c:when>
                  <c:otherwise>                  
                     <button onclick="location.href='${ path }/notice/notice?page=${ status.current }'">${ status.current }</button>
                  </c:otherwise>
               </c:choose>
            </c:forEach>
   
   
            <!-- 다음 페이지로 -->
            <button onclick="location.href='${ path }/notice/notice?page=${ pageInfo.nextPage }'">&gt;</button>
   
            <!-- 맨 끝으로 -->
            <button onclick="location.href='${ path }/notice/notice?page=${ pageInfo.maxPage }'">&gt;&gt;</button>
         </div>
                            
                           <c:if test="${  empty loginMember && loginMember.id == notice.n_no }">
							<button type="button" onclick="location.href='${ path }/notice/update?no=${ notice.n_no }'">글작성</button>
						</c:if>
						</div>
                        </div>
                </section>
                </div>
        </div>
        <div id="footer"></div>
    </div>
</body>
</html>