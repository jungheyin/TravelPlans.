<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>		
<div class="d-flex mt-4">
	<article id="id">
		<div class="d-flex justify-content-center mt-4">
			<h5 class="font-weight-bold text-secondary">아이디 찾기</h5>
		</div>
					
		<div class="m-3 mt-5 pt-5">
			<label class="email font-weight-bold ml-1">이메일</label>
			<input type="text" id="idEmail" class="form-control"
				placeholder="travel@plans.com">
		</div>
	 	<div class="mx-3 mt-5 pt-3">
			<button id="idBtn" class="btn w-100 font-weight-bold text-white">
				FIND ID!
			</button>
		</div>
	</article>
				
	<div class="border border-left mx-2 mt-5"></div>
				
	<article id="password">
		<div class="d-flex justify-content-center mt-4">
			<h5 class="font-weight-bold text-secondary">비밀번호 찾기</h5>
		</div>
		<div class="m-3 mt-5">
			<label class="id font-weight-bold ml-1">아이디</label>
			<input type="text" id="loginId" class="form-control"
				placeholder="아이디">
		</div>
		<div class="m-3">
			<label class="email font-weight-bold ml-1">이메일</label>
			<input type="text" id="pwEmail" class="form-control"
				placeholder="travel@plans.com">
		</div>
		<div class="mx-3 mt-4">
			<button id="passwordBtn" class="btn w-100 font-weight-bold text-white">
				FIND PASSWORD!
			</button>
		</div>
	</article>
</div>
<script>
$(document).ready(function() {
	
	 function emailCheck(email) {
		var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		return reg.test(email);
	} 
	
	$('#idBtn').on('click', function() {
		
		let email = $('#idEmail').val().trim();
		
		if (email == '') {
			alert("이메일을 입력해 주세요.");
			return;
		} else if (!emailCheck(email)) {
			alert("이메일 형식으로 입력해 주세요.");
			return;
		}
		
		let btEmail = btoa(encodeURIComponent(email));
	
		$.ajax({
			type: "POST"
			, url: "/user/is_find_id"
			, data: {"email" : email}
			, success : function(data) {
				if (data.result) {
					location.href="/travelplans/find_id_view?email="+ btEmail;
				} else if (data.result == false) {
					alert("traval plans 이용자가 아닙니다. \n회원가입 후 이용해주세요.");
				} else {
					alert("다시 시도해 주세요.");
				}
			}
			, error: function(e) {
				alert("아이디 찾기에 실패했습니다.");
			}
		});
	});
	
	$('#loginId').on('keyup', function() {
		let regLoginId = $(this).val();
		$(this).val((regLoginId.replace(/[ㄱ-힣~!@#$%^&*()_+|<>?:{}= ]/g,'')));
	});
	
	$('#passwordBtn').on('click', function() {
		
		let loginId = $('#loginId').val().trim();
		let email = $('#pwEmail').val().trim();
		
		if (loginId == '') {
			alert("아이디를 입력해 주세요.");
			return;
		}
		
		if (email == '') {
			alert("이메일을 입력해 주세요.");
			return;
		} else if (!emailCheck(email)) {
			alert("이메일 형식으로 입력해 주세요.");
			return;
		}
		
		
		let btLoginId = btoa(encodeURIComponent(loginId));
		let btEmail = btoa(encodeURIComponent(email));
		
		
		$.ajax({
			type:"POST"
			, url: "/user/is_find_password"
			, data: {"loginId": loginId, "email": email}
			, success : function(data) {
				if (data.result) {
					location.href="/travelplans/find_password_view?loginId="+ btLoginId + "&email=" + btEmail;
				} else if (data.result == false) {
					alert("travel plans 이용자가 아닙니다. \n회원가입 후 이용해주세요.");
				} else {
					alert("다시 시도해 주세요.");
				}
			}
			, error: function(e) {
				alert("비밀번호 찾기에 실패했습니다.");
			}
		});
	});
});
</script>
</html>