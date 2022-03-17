<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travel plans.:login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="/static/css/user/sign_in.css">
</head>
<body>
	
	<div id="wrap" class="container">
		<header class="d-flex align-items-end justify-content-center mb-5">
			<div>
				<h1 class="font-weight-bold text-center">L O G I N</h1>
				<a href="/travelplans/travelplans_view">
					<span class="loginText font-weight-bold m-5">travel plans.</span>
				</a>
			</div>
		</header>
		
		<section class="content">
				<div>
					<input type="text" id="loginId" class="form-control mb-3" 
					 placeholder="ID">
				</div>
				<div>				
					<input type="password" id="password" class="form-control" 
						placeholder="PASSWORD">
				</div>
				
				<button class="btn w-100 btn-lg font-weight-bold text-white mt-4" 
					id="loginBtn">
						GO ON A TRIP.
				</button>
		</section>
		
		<footer class="d-flex justify-content-center">
			<small class="text-secondary">
				Copyright 2022 travel plans. All rights reserved.
			</small>
		</footer>
	</div>

<script>
$(document).ready(function() {
	
	$('#loginId').on('keyup', function() {
		let regLoginId = $(this).val();
		$(this).val((regLoginId.replace(/[ㄱ-힣~!@#$%^&*()_+|<>?:{}= ]/g,'')));
	});
	
	$('#loginBtn').on('click', function() {
		
		let loginId = $('#loginId').val().trim();
		
		if (loginId == '') {
			alert("아이디를 입력하세요.");
			return false;
		}
		
		let password = $('#password').val();
		
		if (password == '') {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
		$.ajax({
			type: "POST"
			, url: "/user/sign_in"
			, data: {"loginId":loginId, "password":password}
			, success: function(data) {
				if (data.result == 'success') {
					location.href ="/mypage/mypage_view";
				} else {
					alert(data.errorMessage);
				}
			}
			,error: function(e) {
				alert("실패");
			}
		});	
	});
});
</script>
</body>
</html>