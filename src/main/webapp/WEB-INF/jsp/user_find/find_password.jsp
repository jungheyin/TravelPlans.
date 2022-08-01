<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<div id="findPasswordPage" class="container mt-5">
	<label class="font-weight-bold">비밀번호</label>
	<input type="password" id="password" class="form-control w-100" 
		placeholder="특수문자/문자/숫자 포함해 8~15자리">
	<div class="mt-2 ml-2">
		<small id="passwordOk" class="d-none">사용 가능한 비밀번호입니다.</small>
		<small id="passwordRule" class="d-none">특수문자/문자/숫자 포함해 8~15자리 이내 입력헤 주세요.</small>
	</div>	
	
	<label class="mt-4 font-weight-bold">비밀번호</label>
	<input type="password" id="confirmPassword" class="form-control" 
		placeholder="특수문자/문자/숫자 포함해 8~15자리">
	<div class="mt-2 ml-2">
		<small id="passwordSame" class="d-none">비밀번호가 같습니다.</small>
		<small id="passwordDifferent" class="d-none">비밀번호가 다릅니다.</small>
		<small id="confirmPasswordRule" class="d-none">특수문자/문자/숫자 포함해 8~15자리 이내 입력헤 주세요.</small>
	</div>	
		
	<button id="updateBtn" class="btn w-100 mt-5 font-weight-bold text-white"">CHANGE PASSWORD</button>
</div>

<script>
$(document).ready(function() {
	
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
			$('#passwordOk').addClass('d-none');
			$('#passwordDifferent').removeClass('d-none');
			$('#password').val('');
			$('#confirmPassword').val('');
			return;
		} else if (password == confirmPassword) {
			$('#passwordSame').removeClass('d-none');
			return;
		}
	});
	
	$('#updateBtn').on('click', function() {
		
		let password = $('#password').val();
		let confirmPassword = $('#confirmPassword').val();
		
		if (password == '' || confirmPassword == '') {
			alert("변경할 비밀번호를 입력해주세요.");
			return;
		}
		
		if ($('#passwordSame').hasClass('d-none')) {
			alert("비밀번호를 확인해 주세요.");
			return;
		}
		
		   $.ajax({
			type:"PUT"
			, url: "/user/password_update"
			, data: {"userId": ${user.id}, "password": password}
			, success: function(data) {
				if (data.result == 'success') {
					alert("비밀번호가 변경되었습니다.");
					location.href="/travelplans/travelplans_view"
				} else if (data.result == 'error') {
					alert(errorMessage);
				}
			}
			, error: function(e) {
				alert("실패했습니다.");
			}
		});  		
	});
});

</script>