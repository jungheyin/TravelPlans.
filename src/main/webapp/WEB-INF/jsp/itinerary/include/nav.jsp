<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<div class="ml-4 mt-3">

	<div class="border rounded">
		<div class="d-flex mx-2 ml-1 my-2">
			<img alt="돈아이콘" src="/static/icons/money_gray.png" width="30px" class=" ml-2 mr-3"> 
			<h5 class="font-weight-bold mt-1 text-secondary">
				<fmt:formatNumber value="${tafficPrice + accommodationPrice + reservationPrice + itineraryPrice}" 
				type="currency"/>
			</h5>
		</div>
	</div>

	<ul class="nav flex-column">
		<li class="nav-item my-2">
			<a class="nav-link" href="/itinerary/traffic_info_view?travelId=${travel.id}">
				<div class="d-flex">
				<img alt="교통아이콘" src="/static/icons/transportation.png" width="20px" height="20px" class="mt-1">
				<div class="nav-Text font-weight-bold ml-3">교 통 수 단</div>	
				</div>
				<small class="nav-smText font-weight-bold ml-4 pl-3">
				<fmt:formatNumber value="${tafficPrice}" type="currency"/></small>
			</a> 
		</li>
		<li class="nav-item">
			<a class="nav-link font-weight-bold" 
				href="/itinerary/accommodation_info_view?travelId=${travel.id}">
				<div class="d-flex">
					<img alt="숙소아이콘" src="/static/icons/accommodation.png" width="20px" height="20px">
					<div class="nav-Text font-weight-bold ml-3">숙   소</div>	
				</div>
				<small class="nav-smText font-weight-bold ml-4 pl-3">
				<fmt:formatNumber value="${accommodationPrice}" type="currency"/></small>
			</a>
		</li>
		<li class="nav-item my-2">
			<a class="nav-link font-weight-bold" 
				href="/itinerary/reservation_info_view?travelId=${travel.id}">
				<div class="d-flex">
					<img alt="예약아이콘" src="/static/icons/reservationInfo.png" width="20px" height="20px" class="mt-1">
					<div class="nav-Text font-weight-bold ml-3">예 약 정 보</div>	
				</div>
				<small class="nav-smText font-weight-bold ml-4 pl-3">
				<fmt:formatNumber value="${reservationPrice}" type="currency"/></small>
			</a>
		</li>
		<li class="nav-item">
			<a class="nav-link font-weight-bold" 
				href="/itinerary/date_list_view?travelId=${travel.id}">
				<div class="d-flex">
					<img alt="일정아이콘" src="/static/icons/planner_skyBlue.png" width="20px" height="20px">
					<div class="nav-Text font-weight-bold ml-3">여 행 일 정</div>	
				</div>
				<small class="nav-smText font-weight-bold ml-4 pl-3">
					<fmt:formatNumber value="${itineraryPrice}" type="currency"/></small>
			</a>
		</li>
	</ul>
</div>

