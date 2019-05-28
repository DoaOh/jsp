<%@page import="kr.or.ddit.user.model.LprodVo"%>
<%@page import="kr.or.ddit.paging.model.PageVo"%>
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

<title>사용자 리스트</title>

<!--css js-->
<%@include file="/common/basiclib.jsp" %>

</head>
<style>

</style>

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
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								
								
								<%
								List<LprodVo>lprodList=(List<LprodVo>)request.getAttribute("lprodPagingList");
		
								
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

						<a class="btn btn-default pull-right">등록</a>
						
						
				<!-- 		
						전체사용자수 조회 
						
						 -->
						

						<div class="text-center">
							<ul class="pagination"> 
							
							
							
							
							
					 
							
							
						
							
							<%
							PageVo pageVo =(PageVo)request.getAttribute("pageVo");
							
							
							int paginationSize =(Integer)request.getAttribute("paginationSize");
							
							%>
							
							
							
							
							<%if(pageVo.getPage()==1){ %>
							<li class="disabled"><span>«</span> </li>
							<%}else{ %>
							 <li >
							 
							<a href="<%=request.getContextPath()%>/LprodPagingList?page=<%=pageVo.getPage()-1%>&pageSize=<%=pageVo.getPageSize()%>">«</a>
							 
							 
							 </li>
							<%}%>
							 
						
							
							
							<%
							for(int i = 1; i <= paginationSize; i++){%>
							
							<li
								<% if(pageVo.getPage() == i){%>
								class="active"
								<%} %>
							>
							<% if(pageVo.getPage() == i){%>
								<span><%=i %></span>
							<%} 
							else{%>
							<a href="<%=request.getContextPath()%>/LprodPagingList?page=<%=i%>&pageSize=<%=pageVo.getPageSize()%>"><%=i %></a>
							</li>
							<%
							}
							%>
							<%
							}
							%>
							
							
							
							<%if(pageVo.getPage() >=paginationSize){ %>
							<li class="disabled"><span>»</span> </li>
							<%}else{ %>
							 <li >
							 
							<a href="<%=request.getContextPath()%>/LprodPagingList?page=<%=pageVo.getPage()+1%>&pageSize=<%=pageVo.getPageSize()%>">»</a>
							 
							 
							 </li>
							<%}%>
							
							 
							
						</ul>
						</div>
					</div>
				</div>




			</div>
		</div>
	</div>
</body>
</html>
