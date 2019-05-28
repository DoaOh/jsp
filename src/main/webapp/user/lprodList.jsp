<%@page import="kr.or.ddit.user.model.LprodVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<title>lprod 리스트</title>

<!--css js-->
<%@include file="/common/basiclib.jsp" %>

</head>

<body>


<!--header-->
<%@include file="/common/header.jsp" %>


	<div class="container-fluid">
		<div class="row">

			
			<!--left-->
<%@include file="/common/left.jsp" %>
			
			
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>lprod id</th>
									<th>lprod gu</th>
									<th>lprod nm</th>
									<th>등록일시</th>
								</tr>
								
								
								<%
								List<LprodVo>lprodList=(List<LprodVo>)request.getAttribute("lprodList");
		
								
								%>
								
								<%for(int i =0; i<lprodList.size();i++){
									
									
									
								%>
								<tr>
									<td><%=lprodList.get(i).getLprod_id()%></td>
									<td><%=lprodList.get(i).getLprod_gu()%></td>
									<td><%=lprodList.get(i).getLprod_nm()%></td>
									<td></td>
								</tr>
							
								<% } %>
							</table>
							
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination"> 
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
					</div>
				</div>




			</div>
		</div>
	</div>
</body>
</html>
