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
<title>사용자 상세조회</title>
<!--css js-->
<%@include file="/common/basiclib.jsp"%>

<script>
$(document).ready(function(){
	
	$("#modify").on("click",function(){
		
		$("#frm").submit();
		
		
	})
	
	
})


</script>

<style>

.col-sm-2 control-label{
 text-align: center;

}

.form-horizontal{
position:relative;
top:70px;
     left:29%;
    
   
}

.form-group2{

position:absolute;
     left:500px;

}

.form-group3{

position:absolute;
top:20px;
 left:45%;
     left:300px;
}

</style>

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
			
			
			
					
			<h2 class="sub-header">사용자 상세정보</h2>
			
				
	<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/userModify" method="get">
		<input type="hidden" id="userId" name="userId" value="${userinfo.userId}"/>
				
				<div class="form-group3">
				
						<div class="col-sm-10">
							<img src="${pageContext.request.contextPath}/profile?userId=${userinfo.userId}"/>
									
									<label for="userNm" class="col-sm-2 control-label">   &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label>
									<label for="userNm" class="col-sm-2 control-label">   &nbsp; &nbsp;&nbsp; </label>
									<label for="userNm" class="col-sm-2 control-label">&nbsp; &nbsp;&nbsp; </label>
									<label for="userNm" class="col-sm-2 control-label">&nbsp; &nbsp;</label>
									
						</div>
					</div>
				
				
				
				
				
				
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${userinfo.name}</label>
						</div>
					</div>
				
				
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label  class="control-label">${userinfo.userId}</label>
						</div>
					</div>



					
					
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label">${userinfo.alias}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소1</label>
						<div class="col-sm-10">
							<label class="control-label">${userinfo.addr1}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소2</label>
						<div class="col-sm-10">
							<label class="control-label">${userinfo.addr2}</label>
						</div>
					</div>
					
				
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${userinfo.zipcd}</label>
						</div>
					</div>
					
					
					
				
					
						
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">생일</label>
						<div class="col-sm-10">
							<label class="control-label">${userinfo.birthstr}</label>
						</div>
					</div>
					
					
	
					<br>
					
			
					<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									
									<button type="submit" class="btn btn-default">사용자 수정</button>
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
