<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travel plans.</title>
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

<link rel="stylesheet" type="text/css" href="/static/css/user/travelplans.css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex align-items-end justify-content-center">
			<div>
				<h1 class="font-weight-bold">travel plans.</h1>
			</div>
		</header>
		
		<section class="content">
			<a id="loginBtn" class="btn d-block btn-lg font-weight-bold text-white mt-4" 
				href="/travelplans/sign_in_view">
				L O G I N
			</a>
			<div class="d-flex justify-content-between mt-3 mx-3">
				<a href="/travelplans/find_user_view" >
					<small class="text-dark font-weight-bold">아이디/비밀번호 찾기</small>
				</a>
				<a href="/travelplans/sign_up_view">
					<small class="text-dark font-weight-bold">회원가입</small>
				</a>
			</div>
		</section>
		
		<footer class="d-flex justify-content-center align-items-end">
			<small class="text-secondary">
				Copyright 2022 travel plans. All rights reserved.
			</small>
		</footer>
	</div>
</body>
</html>