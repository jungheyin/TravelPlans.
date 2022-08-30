<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div>
	<div class="d-flex justify-content-between">
		<h5 class="font-weight-bold ml-1 mt-2">교통수단</h5>
		<a href="/reservation/traffic_create_view?userId=${userId}&travelId=${travel.id}" class="mr-2">
			<img src="/static/icons/plus_skyBlue.png" alt="추가" width="35px">
		</a>
	</div>
	
	<c:forEach var="traffic" items="${trafficList}">
		
		<a href="/reservation/traffic_update_view?userId=${userId}&travelId=${travel.id}&trafficId=${traffic.id}" 
						class="updateLink">
						
		<div class="trafficBox border p-3 mb-3" data-traffic-id="${traffic.id}">
			<div class="d-flex justify-content-end">
				<img src="/static/icons/delete_black.png" alt="삭제" width="25px" class="deleteImg">
				<button type="button" class="deleteBtn btn d-none" data-traffic-id="${traffic.id}"></button>
			</div>
			
			<div class="d-flex justify-content-between mt-1">
				<div>
						<div class="d-flex text-dark">
							<h5 class="font-weight-bold">${traffic.start}</h5>
							<h5 class="font-weight-bold mx-2">→</h5>
							<h5 class="font-weight-bold">${traffic.arrive}</h5>
						</div>
				</div>
				<div class="font-weight-bold mr-5">
					<fmt:formatNumber value="${traffic.price}" type="currency"/>
				</div>
			</div>
			<div>
				<div class="d-flex">
					<c:set var="trafficVal" value="${traffic.traffic}" />
					<c:choose>
						<c:when test="${trafficVal == 'airplans'}"> 
							<span class="font-weight-bold">비행기:</span>
						</c:when>
						<c:when test="${trafficVal == 'train'}"> 
							<span class="font-weight-bold">기차:</span>
						</c:when>
						<c:when test="${trafficVal == 'expressBus'}"> 
							<span class="font-weight-bold">고속버스:</span>
						</c:when>
						<c:when test="${trafficVal == 'direct'}"> 
							<span class="font-weight-bold"></span>
						</c:when>
					</c:choose>
					<span class="ml-1 font-weight-bold">${traffic.trafficInfo}</span>
				</div>
				
				
			</div>	
			
			<!-- 시간설정해야한다. -->
			<div class="d-flex font-weight-bold text-secondary">
				<small class="font-weight-bold">${traffic.startDate}</small>
				<small class="font-weight-bold mx-1">${traffic.startTime}</small>
				<small class="font-weight-bold mx-1">-</small>
				<small class="font-weight-bold mx-1">${traffic.arriveDate}</small>
				<small class="font-weight-bold">${traffic.arriveTime}</small>
			</div>
				
			<!-- TODO: 다시 해야함!! -->
			<div class="my-2 font-weight-bold text-dark">
				<span class="ml-2">
					${traffic.memo}
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
		
		var travelId = ${travel.id};
		var trafficId = $('.deleteBtn').data('traffic-id');
		console.log(trafficId + " 삭제");
		
		 $.ajax({
			type: "DELETE"
			, url: "/reservation/delete_traffic"
			, data: { "travelId": travelId, "trafficId": trafficId}
			, success: function(data) {
				if (data.result == "success") {
					// 성공시 reload
					alert( "삭제 성공");
					document.location.reload();
				} else {
					alert(errorMessage);
				}
			}
			, error: function(e) {
				alert("삭제 실패");
			}
		}); 
		
	});
});
</script>
