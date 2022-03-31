<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage">
	<a href="/mypage/mypage_view" class="d-flex justify-content-end"> <span
		class="text-white font-weight-bold mr-2">mypage</span>
	</a>
</div>
<div class="d-flex justify-content-between">
	<div class="d-flex">
		<img src="/static/icons/airplan.png" alt="로고" width="25px"
			height="25px" class="mt-2 ml-2">
		<h4 class="font-weight-bold mt-2 mr-1">travel plans.</h4>
	</div>
	<!-- new 여행계획2으로 이동 -->
	<div class="mt-2 mr-3">
		<img src="/static/icons/airplans_black.png" id="airplanImg" 
			alt="비행기아이콘" width="30px">
		<button type="button" id="nextBtn" class="btn d-none" data-travel-id=${travel.id}></button>
	</div>
	
	
	<!-- <a href="/itinerary/traffic_info_view?travelId=${travel.id}" class="mt-2 mr-3"> -->
	</a>
</div>

<script>
$(document).ready(function() {
	
	$('#airplanImg').on('click', function() {
		$('#nextBtn').click();
		
		let travelId = $('#nextBtn').data('travel-id');
		
		// alert(travelId);
		 $.ajax({
			type: "GET"
			,url: "/reservation/pass_travelId"
			, data: {"travelId": ${travel.id}}
			, success: function(data) {
				if (data.result == 'success') {
					location.href="/itinerary/traffic_info_view?travelId=${travel.id}";
				} else {
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