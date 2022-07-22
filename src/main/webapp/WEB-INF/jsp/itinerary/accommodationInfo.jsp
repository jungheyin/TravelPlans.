<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div>
	<div class="d-flex justify-content-between">
		<h5 id="trafficSubject" class="font-weight-bold mb-4 ml-2">숙 소</h5>
		<a href="/reservation/accommodation_create_view?travelId=${travel.id}" class="mt-1 mr-2" >
			<img src="/static/icons/plus_skyBlue.png" alt="추가" width="40px">
		</a> 
	</div>
	<c:forEach var="accommodation" items="${accommodationList}">
	<a href="/reservation/accommodation_update_view?travelId=${travel.id}&accommodationId=${accommodation.id}"
				class="text-dark">
	<div class="border p-3 mb-3">
		<div class="d-flex justify-content-end mb-2 mr-2">
			<img src="/static/icons/delete.png" alt="삭제" width="25px" class="deleteImg">
			<button type="button" class="deleteBtn btn d-none" data-accommodation-id="${accommodation.id}"></button>
		</div>
		<!-- name과 price : font-size조절하기 -->
		<div class="d-flex justify-content-between mr-5">
			
				<h5 class="font-weight-bold">${accommodation.name}</h5>
			
				<!-- TODO: 콤마찍어야한다. -->
			<h5>${accommodation.price}</h5>
		</div>	
		<!-- 시간설정해야한다. -->
		<div class="d-flex text-secondary mb-3">
			<small class="font-weight-bold ">${accommodation.startDate}</small>
			<small class="font-weight-bold mx-1">-</small>
			<small class="font-weight-bold mx-1">${accommodation.endDate}</small>
		</div>
		<div>
			<span class="font-weight-bold mb-2">위치: ${accommodation.location}</span>
		</div>
		<!-- TODO: 다시 해야함!! -->
		<div class="font-weight-bold text-dark mt-1 mb-2">
			<span class="ml-2">
				${accommodation.memo}
			</span>
			
		</div>
	</div>
	</a>
	</c:forEach>
</div>

<script>
$(document).ready(function() {
	
	$('.deleteImg').on('click', function(e) {
		$('.deleteBtn').click();
		
		var accommodationId = $('.deleteBtn').data('accommodation-id');
		var travelId = ${travel.id};
		
		alert(accommodationId + " 삭제");
		
		  $.ajax({
			type: "DELETE"
			, url: "/reservation/delete_accommodation"
			, data: { "accommodationId": accommodationId, "travelId": travelId}
			, success: function(data) {
				if (data.result == "success") {
					// 성공시 reload
					alert(travelId + accommodationId + " 성공");
					document.location.reload();
				} else {
					alert(errorMessage);
				}
			}
			, error: function(e) {
				alert("숙소 정보 삭제 실패");
			}
		});  
	});
});
</script>


    
    <!-- 해야할것
    1. 체크인 체크아웃시간 넣기
    2. 날짜 마지막날 이후 안나오게 하기 -->