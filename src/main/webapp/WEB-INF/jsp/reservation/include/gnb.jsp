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
	<a href="/itinerary/traffic_info_view?travelId=${travel.id}" class="mt-2 mr-3">
		<img src="/static/icons/airplans_black.png" alt="비행기아이콘" width="30px">
	</a>
</div>