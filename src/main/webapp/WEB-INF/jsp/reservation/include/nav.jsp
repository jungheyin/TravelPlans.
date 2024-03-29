<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="d-flex align-items-center justify-content-center mt-3">
	<ul class="nav w-100 nav-fill">
	
		<li class="nav-item d-flex align-items-center justify-content-center">
			<a href="/reservation/traffic_create_view?userId=${userId}&travelId=${travel.id}" class="nav-link"> 
			<img src="/static/icons/transportation.png" alt="교통수단" width="20px"
				height="20px" class="mb-1"> <span>교통수단</span>
		</a>
		</li>
		
		<li class="nav-item d-flex align-items-center justify-content-center">
			<a href="/reservation/accommodation_create_view?userId=${userId}&travelId=${travel.id}" class="nav-link"> <img
				src="/static/icons/accommodation.png" alt="숙소" width="20px"
				height="20px" class="mb-2"> <span>숙소</span>
		</a>
		</li>
		
		<li class="nav-item d-flex align-items-center justify-content-center">
			<a href="/reservation/reservation_create_view?userId=${userId}&travelId=${travel.id}" class="nav-link"> <img
				src="/static/icons/reservationInfo.png" alt="예약정보" width="25px"
				height="25px" class="mb-1"> <span>예약정보</span>
		</a>
		</li>
	</ul>
</nav>

<hr>
