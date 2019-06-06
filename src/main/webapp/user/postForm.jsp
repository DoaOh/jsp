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
<link rel="icon" href="../../favicon.ico">

<title>사용자 등록</title>
<!--css js-->
<%@include file="/common/basiclib.jsp"%>

<script>

  //주소 찾기 버튼 이벤트 클릭 
$(document).ready(function(){
	
				$("#postRegBtn").on("click",function(){
        		$("#frm").submit();
        		
        		
        	});
        	
    //데이터 초기화 함수 
   ///dataInit();
 });
 
 function dataInit(){
	 
	 $("#posttitle").val("제목 오늘");
	 $("#postcontent").val("내용 폭염주의보");
	 $("#boardid").val("60001");
	
	 
 }
 

</script>



<style>


</style>
</head>
<body>


	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
		<!--left-->
		<%@include file="/common/left.jsp"%>


			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
			<div class="col-sm-8 blog-main">
			
			
					
			<h2 class="sub-header">게시글 작성</h2>
			
				<form id="frm" class="form-horizontal" role="form"
				action="${pageContext.request.contextPath}/postForm" method="post"
				enctype="multipart/form-data">
				
			
			
			
			<div class="form-group">
			
						<label for="userId" class="col-sm-2 control-label">게시글 제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="posttitle" name="posttitle"
								placeholder="제목" value="${param.posttitle}">
							
						</div>
					</div>
				
				
				<div class="form-group">
				
						<label for="userNm" class="col-sm-2 control-label">내용</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="postcontent" name="postcontent" placeholder="내용"  value="${param.postcontent}">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userAlias" class="col-sm-2 control-label">게시판설정</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="boardid" name="boardid" placeholder="게시판지정" value="${param.boardid}">
						</div>
				</div>
				
				
				
				
				
				<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button  id="postRegBtn"  type="button" class="btn btn-default pull-right">게시글등록</button>
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
