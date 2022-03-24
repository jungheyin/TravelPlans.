<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<span class="font-weight-bold ml-2">NEW PLAN</span>
	
	<div class="tripBox border mt-3 ml-3">
		<div class="d-flex justify-content-between">
		
			<div class="font-weight-bold ml-3 mb-2 mt-3">travel name</div>
			<div class="border">
				<img src="/static/icons/change.png" id="checkImg" width="20px" 
					class="mr-3 mt-3">
				<button id="tripSaveBtn" class="btn d-none">수정</button>
			</div>
		</div>
			<h5 class="font-weight-bold ml-3 mb-3">${trip.title}</h5>
			
			<div class="d-flex ml-3 mb-3"> <!-- 2022-03-22 -->
				<small class="font-weight-bold">
					<fmt:parseDate value="${trip.startDate}" pattern="yyyy-MM-dd" var="date"/>
					<fmt:formatDate var="startDate" value="${date}" pattern="MM월 dd일" />
					${startDate}
				</small>
				
				<small class="font-weight-bold">
					<c:choose> 
						<c:when test="${trip.startDate != trip.endDate}">
							~
							<fmt:parseDate value="${trip.endDate}" pattern="yyyy-MM-dd" var="date"/>
							<fmt:formatDate var="endDate" value="${date}" pattern="MM월 dd일" />
							${endDate}
						</c:when>
						<c:when test="${trip.startDate == trip.endDate}">
									
						</c:when>
					</c:choose>
				</small>
				
				<small class="font-weight-bold">
					(${fn:substring(trip.startDate, 0,4)})
				</small>
			</div>
		
	</div>
<script>

$(document).ready(function() {
	
// trip.color의 색상을 가져온다.
 
// css에 색상을 넣기 

	
});

</script>