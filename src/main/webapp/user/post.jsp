<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>게시글 보기</title>
<!--css js-->
<%@include file="/common/basiclib.jsp"%>

<script>
$(document).ready(function(){
	
	$("#modify").on("click",function(){
		
		$("#frm").submit();
		
	})
	
	
})


</script>

</head>
<body>

	<!--header-->
	<%@include file="/common/header.jsp"%>


	<div class="container-fluid">
		<div class="row">
		<!--left-->
		<%@include file="/common/left.jsp"%>

		

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
			<div class="col-sm-8 blog-main">
			
			
			
					
			<h2 class="sub-header">포스트보기</h2>
			
				
	  <form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/postModify" method="get">
	     <input type="hidden" id="postId" name="postId" value="${post.postid}"/>
				
				
				
				
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${post.posttitle}</label>
						</div>
					</div>
				
				
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<label  class="control-label">${post.postcontent}</label>
						</div>
					</div>


					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">작성일</label>
						<div class="col-sm-10">
							<label class="control-label">${post.postred_dtstr}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<label class="control-label">${post.userid}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시판코드</label>
						<div class="col-sm-10">
							<label class="control-label">${post.boardid}</label>
						</div>
					</div>
					
			
	
			
					        <div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-default">포스트 수정</button>
								</div>
							</div>

					
				</form>



					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
