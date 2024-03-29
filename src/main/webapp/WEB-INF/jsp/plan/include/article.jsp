<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
    
  
<div class="">
	<div class="d-flex justify-content-around mb-2">
		<div class="d-flex">
			<div>
				<img alt="달력아이콘" src="/static/icons/planner_skyBlue.png" width="35px" height="32px">
			</div>
			<div>
			<h4 class="schedule ml-2 mt-1">SCHEDULE</h4>
			</div>
		</div>
		<div>
			<a href="/plan/create_view?travelId=${travel.id}&itineraryId=${itineraryId}&date=${date}">
				<img alt="추가아이콘" src="/static/icons/plus_skyBlue.png" width="35px">
			</a>
		</div>
	</div>
	
	<!-- planList -->
	
	<div class="planList">
		<c:forEach items="${planList}" var="plan">
			<div class="border rounded p-3 mb-2">
				<div class="d-flex justify-content-between">
					<div class="d-flex">
						<!-- 시간 -->
						 <div class="ml-1">${fn:substring(plan.time,0,5)}</div>
						 <div class="border-left mx-2"></div>
						 <!-- 제목 -->
						<div class="fullPlanName font-weight-bold">${plan.planName}</div>
					 </div>
					 <div class="d-flex">
					 	<!-- 수정하기 -->
						 <a href="/plan/update_view?userId=${userId}&travelId=${travel.id}&itineraryId=${itineraryId}&date=${date}&planId=${plan.id}" class="mr-2">
						 	<img alt="수정" src="/static/icons/change_black.png" width="20px"
						 		class="updateImg">
						 </a>
						 <!-- 삭제하기 -->
						 <div>
						 	<button class="delBtn btn d-none">삭제</button>
							 <img alt="삭제" src="/static/icons/delete_red.png" width="20px"
							 	class="delImg" data-plan-id="${plan.id}">
						 </div>
					 </div>
				 </div>
				<div class="ml-2 pl-4 mt-1 mb-1">
					<div>
						<img alt="돈아이콘" src="/static/icons/money_gray.png" height="20px" class="mr-1">
						<fmt:formatNumber value="${plan.price}" type="currency"/>
					</div>
					<div>
						<img alt="위치아이콘" src="/static/icons/location_gray.png" height="20px"
							class="mr-1">
						<c:choose>
							<c:when test="${empty plan.location}">
								-
							</c:when>
							<c:when test="${!empty plan.location}">
								${plan.location}
							</c:when>
						</c:choose>	
					</div>
					<div>
						<img alt="메모이미지" src="/static/icons/memo_gray.png" width="20px"
							class="mr-1">
						<c:choose>
							<c:when test="${empty plan.memo}">
								-
							</c:when>
							<c:when test="${!empty plan.memo}">
								${plan.memo}
							</c:when>
						</c:choose>		
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
</div>

<script>

$(document).ready(function() {
	
	// 삭제
	$('.delImg').on('click', function() {
		$('.delBtn').click();
		
		let planId = $(this).data('plan-id');
		let planList = ${planList.size()};
		
		
		
		$.ajax({
			type:"DELETE"
			,url: "/plan/delete"
			,data: {"planId": planId}
			,success: function(data) {
				if (data.result == "success") {
					alert("삭제");
					if (planList == 1) {
						document.location.href="/itinerary/date_list_view?userId=${userId}&travelId=${travel.id}";
					} else if (planList > 1) {
						document.location.reload();
					}
					
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