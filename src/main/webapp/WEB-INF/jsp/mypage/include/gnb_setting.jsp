<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="logoutNav d-flex justify-content-end">

	<div class="d-flex">
		<div id="mypage" class="font-weight-bold text-white mr-2">mypage</div>
		<button type="button" id="saveBtn" class="btn d-none" data-user-id="${userId}">버튼</button>
	</div>
</div>
<div class="mypageBox d-flex justify-content-between mt-1 mx-2">
	<div class="d-flex">
		<img src="/static/icons/airplan.png" alt="로고" width="25px"
			height="25px" class="mt-2 ml-2">
		<h4 class="font-weight-bold mt-2 mr-1">travel plans.</h4>
	</div>
	
	<div class="d-flex">
		<div class="mr-2">
			<input type="text" id="nickname" class="form-control" value="${user.nickname}" maxlength="18">
		</div>
		<h6 class="font-weight-bold mt-2">님</h6>
	</div>
	
</div>

<script>
$(document).ready(function(){
	
	$('#nickname').on('blur', function() {
		let nickname = $('#nickname').val().trim();
		
		if (nickname == '') {
			alert("닉네임을 입력해 주세요.");
			return;
		}
		
	});
	
	// 수정하기
	$('#mypage').on('click', function() {
		$('#saveBtn').click();
		
		let nickname = $('#nickname').val().trim();
		var userId = $('#saveBtn').data('user-id');
		
		if (nickname == '') {
			alert("닉네임을 입력해 주세요.");
			return;
		}
		
		alert(nickname + userId);
		
	 	$.ajax({
	 		type: "PUT"
			, url: "/mypage/update_nickname"
			, data: {"userId":userId, "nickname": nickname}
	 		, success: function(data) {
	 			if (data.result == 'success') {
	 				alert("수정");
	 				location.href="/mypage/mypage_view";
	 			} else {
	 				alert(errorMessage);
	 			}
	 		}
	 		, error: function(e) {
	 			alert("마이페이지에서 수정이 실패했습니다.");
	 		}
		}); 
		
		
	});
});

</script>