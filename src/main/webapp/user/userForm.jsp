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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>

  //주소 찾기 버튼 이벤트 클릭 
$(document).ready(function(){
	
	
	
	
	var msg='${msg}';
	
	if(msg!=''){alert(msg)};
	
	
        	$("#addrSearchBtn").on("click",function(){
        		
        	    new daum.Postcode({
        	        oncomplete: function(data) {
        	         
        	        	
        	        	$("#userZipcd").val(data.zonecode);
        	        	$("#userAddr1").val(data.roadAddress);
        	        	
        	        	
        	        }
        	    }).open();
        
    });
        	
        	
        	$("#userRegBtn").on("click",function(){
        		
        		console.log("userRegBtn click");
        		//유효성 체크 
        		
        		//여기까지 도달하면  유효성 검사 완료 
        		$("#frm").submit();
        		
        		
        	});
        	
    //데이터 초기화 함수 
   ///dataInit();
 });
 
 function dataInit(){
	 
	 $("#userId").val("userTest");
	 $("#userNm").val("userTest");
	 $("#userAlias").val("userTest");
	 $("#userAddr1").val("userTest");
	 $("#userAddr2").val("userTest");
	 $("#userZipcd").val("udest");
	 $("#userPass").val("ddddd");
	 $("#userBirth").val("2019-05-31");
	
	 
 }
 

</script>



<style>


.form-horizontal{
postion:relative;
top:50px;
     left:10%;
   
}

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
			
			
					
			<h2 class="sub-header">사용자 등록</h2>
			
				<form id="frm" class="form-horizontal" role="form"
				action="${pageContext.request.contextPath}/userForm" method="post"
				enctype="multipart/form-data">
				
				
				
				
					
				<div class="form-group">
				<label for="profile" class="col-sm-2 control-label">프로필 사진</label>
						
						<div class="col-sm-10">
							<input type="file" id="profile" name="profile">
						</div>
				</div>
				
			
			<div class="form-group">
			
						<label for="userId" class="col-sm-2 control-label">아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디" value="${param.userId}">
							
						</div>
					</div>
				
				
				
				<div class="form-group">
				
						<label for="userNm" class="col-sm-2 control-label"> 이름</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userNm" name="userNm" placeholder="사용자 이름"  value="${param.userNm}">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userAlias" class="col-sm-2 control-label">별명</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userAlias" name="userAlias" placeholder="별명" value="${param.userAlias}">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userPass" class="col-sm-2 control-label"> 비밀번호</label>
						
						<div class="col-sm-10">
							<input type="password" class="form-control" id="userPass" name="userPass" placeholder="비밀번호" value="${param.userPass}">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userAddr1" class="col-sm-2 control-label"> 주소</label>
						
						<div class="col-sm-9">
							<input type="text"  class="form-control" id="userAddr1" name="userAddr1" placeholder="주소" readonly="readonly" >
						
						
						</div> <a id="addrSearchBtn" class="btn btn-default">&nbsp;&nbsp;주소&nbsp;&nbsp;</a>
						
						
				</div>
				
				
				<div class="form-group">
				
						<label for="userAddr2" class="col-sm-2 control-label">상세주소</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userAddr2" name="userAddr2" placeholder="상세주소" value="${param.userAddr2}">
						</div>
				</div>
				
	
			
				<div class="form-group">
				
						<label for="userZipcd" class="col-sm-2 control-label"> 우편번호</label>
						
						<div class="col-sm-10">
							<input type="text"   class="form-control" id="userZipcd" name="userZipcd" placeholder="우편번호" readonly="readonly">
						</div>
				</div>
				
				
				<div class="form-group">
						<label for="userBirth" class="col-sm-2 control-label">생일</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="userBirth" name="userBirth" placeholder="생일" value="${param.userBirth}">
						</div>
				</div>
				
				
				
				
				
				<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button  id="userRegBtn"  type="button" class="btn btn-default pull-right">사용자등록</button>
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
