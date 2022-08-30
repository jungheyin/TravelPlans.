<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<div class="d-flex justify-content-center mr-2 mb-2">
		<button id="unregisterBtn" class=" btn d-none">
			회원탈퇴
		</button>
		<small id="unregister" class=" font-weight-bold text-secondary">
			회원탈퇴
		</small>
		
	</div>
	<div class="d-flex align-items-end justify-content-center">
		<small class="text-secondary">
			Copyright 2022 travel plans. All rights reserved.
		</small>
	</div>
</div>

<script>
$(document).ready(function() {
	
	$('#unregister').on('click', function() {
		$('#unregisterBtn').click();
		
		// alert("회원탈퇴");
		
		let userId = ${userId};
		
		alert(userId);
		
		$.ajax({
			type: "DELETE"
			, url: "/user/delete"
			, data: {"userId": userId}
			, success: function(data) {
				if (data.result) {
					alert("BYE~");
					location.href="/travelplans/travelplans_view";
				} else {
					alert(errorMessage);
				}
			}
			, error : function(data) {
				alert("회원탈퇴에 실패했습니다.");
			}
		});
		
	});
	
	
});

</script>