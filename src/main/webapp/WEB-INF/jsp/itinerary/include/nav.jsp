<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="ml-2">
	<ul class="nav flex-column">
		<li class="nav-item my-2">
			<a class="nav-link font-weight-bold" 
				href="/itinerary/traffic_info_view?travelId=${travel.id}">
				교 통 수 단
			</a>
		</li>
		<li class="nav-item my-2">
			<a class="nav-link font-weight-bold" 
				href="/itinerary/accommodation_info_view?travelId=${travel.id}">
				숙     소
			</a>
		</li>
		<li class="nav-item my-2">
			<a class="nav-link font-weight-bold" 
				href="/itinerary/reservation_info_view?travelId=${travel.id}">
				예 약 정 보
			</a>
		</li>
		<li class="nav-item">
			<a class="nav-link font-weight-bold" 
				href="/itinerary/create_view?travelId=${travel.id}">
				여행 일 정
			</a>
		</li>
	</ul>
</div>