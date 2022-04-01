<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
		
		<c:choose>
			<c:when test="${reservationSubject == 'traffic'}">
				<a href="/itinerary/traffic_info_view?travelId=${travel.id}" class="mt-2">
					<img src="/static/icons/airplans_black.png" id="airplanImg" 
						alt="비행기아이콘" width="30px">
				</a>
			</c:when>
			<c:when test="${reservationSubject == 'accommodation'}">
				<a href="/itinerary/accommodation_info_view?travelId=${travel.id}" class="mt-2">
					<img src="/static/icons/airplans_black.png" id="airplanImg" 
						alt="비행기아이콘" width="30px">
				</a>
			</c:when>
			<c:when test="${reservationSubject == 'reservation'}">
				<a href="/itinerary/reservation_info_view?travelId=${travel.id}" class="mt-2">
					<img src="/static/icons/airplans_black.png" id="airplanImg" 
						alt="비행기아이콘" width="30px">
				</a>
			</c:when>
		</c:choose>
	</div>
</div>