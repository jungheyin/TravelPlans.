<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travel plans:sign up</title>
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

<link rel="stylesheet" type="text/css" href="/static/css/user/sign_up.css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex justify-content-center mt-3">
			<h1>travel plans.</h1>
		</header>
		<section class="content">
			<!-- 닉네임 -->
			<div class="form-group">
				<h5 class="m-1">NICKNAME</h5> 
				<input type="text" id="nickname" class="form-control" placeholder="닉네임">
			</div>
			
			<!-- 로그인 아이디 -->
			<div class="form-group">
				<div class="d-flex justify-content-between">
					<h5 class="m-1">LOGINID</h5> <!-- input event 사용하기 -->
					
					<div class="mt-2 mr-2">
						<small class="text-primary d-none">사용 가능한 아이디입니다.</small>
						<small class="text-danger d-none">사용할 수 없는 아이디입니다.</small>
						<small class="text-warning d-none">아이디는 4글자 이상 가능합니다.</small>
						<small class="text-warning">아이디를 입력 해주세요..</small>
					</div>
				</div>
				<input type="text" id="loginId" class="form-control" placeholder="4자 이상">
			</div>
			
			<!-- 비밀번호-->
			<div class="form-group">
				<div class="d-flex justify-content-between">
					<h5 class="m-1">PASSWORD</h5> <!-- input event 사용하기 -->
					
					<div class="mt-2 mr-2">
						<small class="text-primary d-none">사용 가능한 비밀번호입니다.</small>
						<small class="text-danger d-none">비밀번호가 다릅니다.</small>
						<small class="text-warning">특수문자/문자/숫자 포함해 8~15자리 애내 입력헤 주세요.</small>
						<small class="text-danger d-none">비밀번호를 입력해 주세요.</small>
					</div>
				</div>
				<input type="password" id="password" class="form-control" placeholder="특수문자/문자/숫자 포함해 8~15자리 이내 입력해 주세요.">
			</div>
			
			<!-- 확인 비밀번호-->
			<div class="form-group">
				<div class="d-flex justify-content-between">
					<h5 class="m-1">PASSWORD</h5> <!-- input event 사용하기 -->
					
					<div class="mt-2 mr-2">
						<small class="text-primary d-none">비밀번호가 같습니다.</small>
						<small class="text-danger d-none">비밀번호가 다릅니다.</small>
						<small class="text-warning d-none">특수문자/문자/숫자 포함해 8~15자리 애내 입력헤 주세요.</small>
						<small class="text-danger ">비밀번호를 입력해 주세요.</small>
					</div>
				</div>
				<input type="password" id="confirmPassword" class="form-control" placeholder="특수문자/문자/숫자 포함해 8~15자리 이내 입력해 주세요.">
			</div>
			
			<!-- 이메일 -->
			<div class="form-group">
				<div class="d-flex justify-content-between">
					<h5 class="m-1">EMAIL</h5> <!-- input event 사용하기 -->
					
					<div class="mt-2 mr-2">
						<small class="text-primary d-none">사용 가능한 이메일입니다.</small>
						<small class="text-danger d-none">메일 형식으로 입력해주세요.</small>
						<small class="text-warning">이메일를 입력 해주세요.</small>
					</div>
				</div>
				<input type="text" id="email" class="form-control" placeholder="travel@plans.com">
				
				<button id="signUpBtn" type="button" class="btn btn-lg w-100 mt-5">
					SIGN UP
				</button>
			</div>
		</section>
		
		<footer class="d-flex align-items-end justify-content-center">
			<small class="text-secondary">
				Copyright 2022 travel plans. All rights reserved.
			</small>
		</footer>
	</div>
</body>
</html>