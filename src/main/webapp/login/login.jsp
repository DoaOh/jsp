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

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>



	<script>
	//쿠키이름에 해당하는 쿠키값을 조회
	
	$(document).ready(function(){
		
		//문서 로딩이 완료되고 나서 실행되는 부분

		//rememberme checkbox
		//1.rememberme cookie가 있는지 있다면 값이 true인지
		//1-1 remember me가  true 라면  input id "rememberme" 테크박스를 테크 해줄거여 
		var rememberme = getCookie("rememberme")
		if(rememberme == "true"){
			$("#rememberme").prop("checked",true);
			$("#userId").val(getCookie("userid"));
			$("#password").focus();
			
			
			//encodeURLComponent
		}
		$("#signinBtn").on("click",function(){
			console.log("signin");
			//만약에 rememberme  체크박스가 체크되어있는경주 
			//사용자 아이디를 userid 쿠기로 저자 
			//true 값을 rememberme 
			
			if($("#rememberme").is(":checked")){
				setCookie("userid",$("#userId").val(),30);
				setCookie("rememberme","true",30);
				
			}else{
				deleteCookie("userid");
				deleteCookie("rememberme");
				
			}
			//만약에 rememberme  체크박스가 체크되어있지 않은경우
			//userid rememberme 쿠키에서 삭재
			
			
			$("#frm").submit();
			
		});

	});
	

	//expires 현재 날짜로부터 얼마동안이나 유효한지
	
	function setCookie(cookieName,cookieValue,expires){
	
		var dt =new Date();
		dt.setDate(dt.getDate()+ parseInt(expires));
		document.cookie=cookieName+"="+cookieValue+"; path=/; expires="+dt.toGMTString();
	}
	
	
	function deleteCookie(cookieName){
		setCookie(cookieName,"",-5);
	}
	
	function getCookie(cookieName){
		
		
		var cookieArray = document.cookie.split("; ");

		var cookieValue ="";
		
		for (var i = 0; i <cookieArray.length; i++) {
			var str =cookieArray[i];
			if(str.startsWith(cookieName+"=")){
				var cookieStr = str.split("=");
				cookieValue = cookieStr[1];
				break;
			}
		}
		
		return cookieValue;	
	}
	
	</script>
	


  </head>

  <body>

    <div class="container">

      <form id="frm" class="form-signin" action="<%=request.getContextPath() %>/login" method="post">
      
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="userId" class="sr-only">userId</label>
        <input type="text" id="userId" class="form-control" name="userId" 
        placeholder="userId"  required  >
        
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password"class="form-control"
         placeholder="Password" required >
         
        <div class="checkbox">
          <label>
            <input id="rememberme" type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button id="signinBtn"class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>