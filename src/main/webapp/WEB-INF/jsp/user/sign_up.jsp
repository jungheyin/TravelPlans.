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
	<div id="travelplans" class="container">
		<div class="travelplansBar ml-2">
			<a href="/travelplans/travelplans_view">
				<span class="font-weight-bold ml-2 text-white">travel plans.</span>
			</a>
		</div>
	</div>
	<div id="wrap" class="container ">
		<header>
			<div class="d-flex justify-content-center m-5">
				<h2 class="font-weight-bold">SIGN UP</h2>
			</div>
		</header>
		<section class="content">
			
				<div class="form-group">
					<h6 class="ml-1">NICKNAME</h6> 
					<input type="text" id="nickname" class="form-control text-" placeholder="닉네임">
				</div>
		
				<div class="form-group">
					<div class="d-flex justify-content-between">
						<div>
							<h6 class="m-1">ID</h6> <!-- input event 사용하기 -->
						</div>
						<div class="mt-2 mr-2">
							<small id="idCheckOk" class="d-none">사용 가능한 아이디입니다.</small>
							<small id="idCheckNot" class="d-none">중복된 아이디입니다.</small>
							<small id="idCheckLength" class="d-none">아이디는 4글자 이상 가능합니다.</small>
						</div>
					</div>
					<div>
						<input type="text" id="loginId" class="form-control mr-2" maxlength="18" placeholder="4자 이상">
					</div>
				</div>
			
				<div class="form-group">
					<div class="d-flex justify-content-between">
						<h6 class="m-1">PASSWORD</h6> <!-- input event 사용하기 -->
						
						<div class="mt-2 mr-2">
							<small id="passwordOk" class="d-none">사용 가능한 비밀번호입니다.</small>
							<small id="passwordRule" class="d-none">특수문자/문자/숫자 포함해 8~15자리 애내 입력헤 주세요.</small>
						</div>
					</div>
					<input type="password" id="password" class="form-control" maxlength="15" placeholder="특수문자/문자/숫자 포함해 8~15자리">
				</div>
				<div class="form-group">
					<div class="d-flex justify-content-between">
						<h6 class="m-1">PASSWORD</h6> <!-- input event 사용하기 -->
						
						<div class="mt-2 mr-2">
							<small id="passwordSame" class="d-none">비밀번호가 같습니다.</small>
							<small id="passwordDifferent" class="d-none">비밀번호가 다릅니다.</small>
							<small id="confirmPasswordRule" class="d-none">특수문자/문자/숫자 포함해 8~15자리 애내 입력헤 주세요.</small>
						</div>
					</div>
					<input type="password" id="confirmPassword" class="form-control" placeholder="특수문자/문자/숫자 포함해 8~15자리">
				</div>
				<div class="form-group">
					<div class="d-flex justify-content-between">
						<h6 class="m-1">EMAIL</h6> <!-- input event 사용하기 -->
						
						<div class="mt-2 mr-2">
							<small id="emailOk" class="d-none">사용 가능한 이메일입니다.</small>
							<small id="emailRule" class="d-none">메일 형식으로 입력해주세요.</small>
						</div>
					</div>
					<input type="text" id="email" class="form-control" maxlength="128" placeholder="travel@plans.com">
				</div>
			
				<button id="signUpBtn" type="button" class="btn btn-lg w-100 mt-5">
					J O I N
				</button>
		</section>
		
		<footer class="d-flex align-items-end justify-content-center">
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
	
	$('#loginId').on('blur', function(e) {
		
		let loginId = $('#loginId').val().trim();
		
		//alert(loginId);
		
		$('#idCheckOk').addClass('d-none');
		$('#idCheckLength').addClass('d-none');
		$('#idCheckNot').addClass('d-none');
		
		if (loginId.length < 4) {
			$('#idCheckLength').removeClass('d-none');
			return;
		} 
		
		
		$.ajax({
			type: "POST"
			, url: "/user/is_duplicated_id"
			, data: {"loginId":loginId}
			, success : function(data) {
				if (data.result) {
					$('#idCheckNot').removeClass('d-none');
				} else if (data.result == false){
					$('#idCheckOk').removeClass('d-none');
				} else {
					alert("다시 시도하기");
				}
			}
			, error: function(e) {
				alert("실패");
			}
		});
		
	});
	
	
	function passwordCheck(password) {
		var regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
 
		return regExp.test(password);
	}	
	
	$('#password').on('blur', function() { 
		
		let password = $('#password').val();
		
		$('#passwordOk').addClass('d-none');
		$('#passwordRule').addClass('d-none');
		
		if (password == '') {
			return;
		}
		
		if (!passwordCheck(password)) {
			$('#passwordRule').removeClass('d-none');
			return;
		} else {
			$('#passwordOk').removeClass('d-none');
			return;
		}
		
	});
	
	$('#confirmPassword').on('blur', function() {
		
		let password = $('#password').val();
		let confirmPassword = $('#confirmPassword').val();
		
		$('#passwordSame').addClass('d-none');
		$('#passwordDifferent').addClass('d-none');
		$('#confirmPasswordRule').addClass('d-none');
		
		if (confirmPassword == '') {
			return;
		}
		
		if(!passwordCheck(confirmPassword)) {
			$('#confirmPasswordRule').removeClass('d-none');
			return;
		} 
		
		if (password != confirmPassword) {
			$('#passwordDifferent').removeClass('d-none');
			$('#password').val('');
			$('#confirmPassword').val('');
			return;
		} else if (password == confirmPassword) {
			$('#passwordSame').removeClass('d-none');
			return;
		}
	});
	
	function emailCheck(email) {
		var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		return reg.test(email);
	}
	
	$('#email').on('blur', function() {
		
		let email = $('#email').val().trim();
		
		$('#emailOk').addClass('d-none');
		$('#emailRule').addClass('d-none');
		
		if (!emailCheck(email)) {
			$('#emailRule').removeClass('d-none');
			return;
		} else {
			$('#emailOk').removeClass('d-none');
			return;
		}
	});
	
	
	$('#signUpBtn').on('click', function() {
		
		let nickname = $('#nickname').val().trim();
		let loginId = $('#loginId').val().trim();
		let password = $('#password').val();
		let confirmPassword = $('#confirmPassword').val();
		let email = $('#email').val().trim();
		
		if (nickname == '') {
			alert("닉네임을 입력해주세요.");
			return;
		}
		
		if (loginId == '') {
			alert("아이디를 입력해주세요.");
			return;
		}
		
		if (password == '' || confirmPassword == '') {
			alert("비밀번호를 입력해주세요.");
			return;
		}
		
		if (email == '') {
			alert("이메일을 입력해주세요.");
			return;
		}
		
		if ($('#idCheckOk').hasClass('d-none')) {
			alert("아이디를 확인해 주세요.");
			return;
		}
		
		if ($('#passwordSame').hasClass('d-none')) {
			alert("비밀번호를 확인해 주세요.");
			return;
		}
		
		if ($('#emailOk').hasClass('d-none')) {
			alert("이메일를 확인해 주세요.");
			return;
		}
		
		
		$.ajax({
			type: "POST"
			, url: "/user/sign_up"
			, data: {"nickname":nickname, "loginId":loginId, "password":password,"email":email}
			, success: function(data) {
				if (data.result == 'success') {
					alert("회원가입 성공 :) \n환영합니다.  " + nickname + " 님");
					location.href="/travelplans/travelplans_view";
				} else if (data.result == 'error') {
					alert("회원가입 실패");
				}
			}
			, error: function(e) {
				alert("실패");
			}
		});
		
	});
	
	
});
</script>
</body>
</html>