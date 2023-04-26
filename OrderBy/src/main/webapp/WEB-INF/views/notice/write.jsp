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
<script src="${ path }/resources/js/jquery-3.6.3.js"></script>
<style>
        .outer {
            width: 800px;
            margin: auto;
        }
        
        .wrap {
            width: 780px;
            margin: 100px auto;
        }
        
        .notice_title {
            border-bottom: 1px solid #282A35;
        }
        
        .notice_content {
            padding: 0px 20px;
        }
        
        .notice_content .subject {
            height: 55px;
            line-height: 55px;
            display: flex;
            justify-content: space-between;
            border-bottom: 1px solid #f3f5f7;
        }
        
        .notice_content .content {
            margin-bottom: 30px;
        }
        
        .input_area {
            border: solid 1px #dadada;
            padding: 10px 10px 14px 10px;
            background: white;
        }
        
        .input_area input {
            width: 680px;
            height: 30px;
            border: 0px;
        }
        
        .input_area input:focus {
            outline: none;
        }
        
        .textarea {
            resize: none;
            border: solid 1px #dadada;
            width: 700px;
        }
        
        .textarea:focus {
            outline: none;
        }
        
        .title_span {
            background-color: #282A35;
        }
        
        .notice_area button {
            width: 100px;
            height: 35px;
            border: 0px;
            color: white;
            background: #282A35;
            margin: 5px;
        }
        
        .btn_area {
            text-align: center;
            border-top: 1px solid #282A35;
            padding: 30px;
        }

        .main1{
    padding-left: 40%;
}
        </style>
</head>
<body>
<div class="outer">
		<div class="wrap">
			<div class="notice_area">
				<div class="notice_title">
					<br><br><h1 class="main1">공지사항 수정</h1>
				</div>
				<div class="notice_content">
					
					<form action="${ path }/notice/write" method="POST" enctype="multipart/form-data" >
					 
					<input type="hidden" name="n_no" value="${ notice.n_no }">
						<div class="content">
							<h4>
								<span class="title_span">&nbsp;</span> 제목
							</h4>
							<span class="input_area"> <input type="text" name="n_title" value="${ notice.n_title }"
						    required>
							</span>
                            <br><br>
                                <hr>
							<h4>
								<span class="title_span">&nbsp;</span> 내용
							</h4>
							<textarea class="textarea" rows="20" cols="100" name="n_content"
								required>${ notice.n_content }</textarea>
						</div>
						<div class="btn_area">
							<button type="button" onclick="location.href='${ path }/notice/notice'">목록으로</button>
							<button type="submit">등록</button>
                            
						</div>
					</form>
				</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>