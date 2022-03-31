<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div>
	<div class="d-flex justify-content-between">
		<h5 id="trafficSubject" class="font-weight-bold mt-3 mb-4">예약정보</h5>
		<a href="/reservation/reservation_create_view?travelId=${travel.id}" class="mt-1 mr-2" >
			<img src="/static/icons/plus_skyBlue.png" alt="추가" width="40px">
		</a> 
	</div>
	<c:forEach var="reservation" items="${reservationList}">
	<div class="border p-3 mb-3">
		<div class="d-flex justify-content-end mb-2 mr-2">
			<img src="/static/icons/delete.png" alt="삭제" width="25px">
			<button type="button" class="deleteBtn btn d-none" data-reservation-id=${reservation.id}></button>
		</div>
		<!-- name과 price : font-size조절하기 -->
		<div class="d-flex justify-content-between mr-5">
			<h5 class="font-weight-bold">${reservation.title}</h5>
				<!-- TODO: 콤마찍어야한다. -->
				<h5>${reservation.price}</h5>
		</div>	
		<!-- 시간설정해야한다. -->
			<span class="font-weight-bold ml-1">예약자: ${reservation.booker}</span>
			<small class="font-weight-bold text-secondary">(${reservation.date})</small>
		<!-- TODO: 다시 해야함!! -->
		<div class="mb-3 font-weight-bold text-dark">
			<c:set var="memo" value="${reservation.memo}" />
			<c:choose>
				<c:when test="${memo == null}">
				
				</c:when>
				<c:when test="${memo != null}">
				-  ${reservation.memo}
				</c:when>
			</c:choose>
		</div>
	</div>
	</c:forEach>
</div>


<script>
$(document).ready(function() {
	
	
});

</script>