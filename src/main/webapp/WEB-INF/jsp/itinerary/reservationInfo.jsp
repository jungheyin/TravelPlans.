<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div>
	<div class="d-flex justify-content-between">
		<h5 class="font-weight-bold ml-1 mt-2">예약정보</h5>
		<a href="/reservation/reservation_create_view?travelId=${travel.id}" class="mr-2" >
			<img src="/static/icons/plus_skyBlue.png" alt="추가" width="35px">
		</a> 
	</div>
	
	<c:forEach var="reservation" items="${reservationList}">
	<a href="/reservation/reservation_update_view?travelId=${travel.id}&reservationId=${reservation.id}">
	
	<div class="border p-3 mb-3">
		<div class="d-flex justify-content-end mb-2 mr-2">
			<img src="/static/icons/delete_black.png" alt="삭제" width="25px" class="deleteImg">
			<button type="button" class="deleteBtn btn d-none" data-reservation-id="${reservation.id}"></button>
		</div>
		<!-- name과 price : font-size조절하기 -->
		<div class="d-flex justify-content-between mr-5 mb-3">
			<div class="d-flex">
				
				<h5 class="font-weight-bold text-dark">${reservation.title}</h5>
				
				<small class="font-weight-bold text-secondary mt-1 ml-1">(${reservation.date})</small>
			</div>
			<div class="font-weight-bold mr-5">
				<fmt:formatNumber value="${reservation.price}" type="currency"/>
			</div>
		</div>	
		<!-- 시간설정해야한다. -->
			<span class="font-weight-bold ml-1">예약자: ${reservation.booker}</span>
		<!-- TODO: 다시 해야함!! -->
		<div class="mb-2 font-weight-bold text-dark">
			<span class="ml-2">
					${reservation.memo}
				</span>
		</div>
	</div>
	</a>
	</c:forEach>
</div>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

<script>
$(document).ready(function() {
	
	$('.deleteImg').on('click', function() {
		$('.deleteBtn').click();
		
		var reservationId = $('.deleteBtn').data('reservation-id');
		var travelId = ${travel.id};
		
		alert(travelId + " , " + reservationId + "삭제");
		
		$.ajax({
			type: "DELETE"
			, url: "/reservation/delete_reservation"
			, data: {"reservationId": reservationId, "travelId": travelId}
			, success: function(data) {
				if (data.result == 'success') {
					alert(travelId + reservationId + "성공");
					location.reload();
				} else {
					alert(errorMessage);
				}
			}
			, error: function(e) {
				alert("예약정보 삭제 실패");
			}
		});
		
	});
});
</script>