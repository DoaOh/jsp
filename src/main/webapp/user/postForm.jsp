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
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시글</title>
<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />
<%@include file="/common/basiclib.jsp"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="${pageContext.request.contextPath}/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

	$(document)
			.ready(
					function() {

						$('#click')
								.on(
										'click',
										function() {

											if ($('.file').length != 5) {
												$('#result')
														.append(
																"<input type='file'  class='file' name='profile'/>")
											} else {
												alert("첨부파일은 5개 까지만 가능합니다");

											}
										})

						// Editor Setting
						nhn.husky.EZCreator
								.createInIFrame({
									oAppRef : oEditors, // 전역변수 명과 동일해야 함.
									elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
									sSkinURI : "${pageContext.request.contextPath}/SE2/SmartEditor2Skin.html", // Editor HTML
									fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
									htParams : {
										// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
										bUseToolbar : true,
										// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
										bUseVerticalResizer : true,
										// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
										bUseModeChanger : true,
									}
								});

						// 전송버튼 클릭이벤트
						$("#postRegBtn").click(
								function() {
									if (confirm("저장하시겠습니까?")) {
										// id가 smarteditor인 textarea에 에디터에서 대입
										oEditors.getById["smarteditor"].exec(
												"UPDATE_CONTENTS_FIELD", []);

										// 이부분에 에디터 validation 검증
										if (validation()) {
											$("#frm").submit();
										}
									}
								})
					});

	// 필수값 Check
	function validation() {
		var contents = $.trim(oEditors[0].getContents());
		if (contents === '&nbsp;' || contents === '') { // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}

		return true;
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

						<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/postForm"
						method="post">




							<div class="form-group">
								<div class="col-sm-10">
									<input type="text" class="form-control" id="posttitle"
									name="posttitle" placeholder="제목" value="${param.posttitle}">
								</div>
							</div>


							<div class="form-group">



								<div class="col-sm-10">
									<%-- 		<input type="text" class="form-control" id="postcontent" name="postcontent" placeholder="내용" value="${param.postcontent}"> --%>
									<textarea name="postcontent" id="smarteditor" rows="10"
										cols="100" style="width: 828px; height: 412px;"
										value="${param.postcontent}"></textarea>



								</div>
							</div>


							<div class="form-group">

								<label class="col-sm-2 control-lable">첨부파일</label>

								<div class="col-sm-7">

									<input type="file" class="file" name="profile">
									<div id="result"></div>

								</div>
								<div class="col-sm-2">
									<button id="click" type="button"
										class="btn btn-default pull-right">추가</button>
								</div>
							</div>




							<div class="form-group">
								<div class="col-sm-8">
									<input type="text" class="form-control" id="boardid"
										name="boardid" placeholder="게시판지정" value="${boardid}">
								</div>
							</div>




							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-2">
									<button id="postRegBtn" type="button"
										class="btn btn-default pull-right">게시글등록</button>
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
