<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div>
	<div class="d-flex justify-content-between">
		<h5 id="trafficSubject" class="font-weight-bold mt-3 mb-4">교통수단</h5>
		<a href="/reservation/traffic_create_view" class="mt-1 mr-2" >
			<img src="/static/icons/plus_skyBlue.png" alt="추가" width="40px">
		</a> 
	</div>
	<c:forEach var="traffic" items="${trafficList}">
	<div class="border p-3 mb-3">
		<div class="d-flex justify-content-end mb-2 mr-2">
			<img src="/static/icons/delete.png" alt="삭제" width="25px">
			<button type="button" class="deleteBtn btn d-none"></button>
		</div>
		<div class="d-flex justify-content-between mr-5">
			<div class="d-flex">
				<c:set var="trafficVal" value="${traffic.traffic}" />
				<c:choose>
					<c:when test="${trafficVal == 'airplans'}"> 
						<h5 class="font-weight-bold">비행기:</h5>
					</c:when>
					<c:when test="${trafficVal == 'train'}"> 
						<h5 class="font-weight-bold">기차:</h5>
					</c:when>
					<c:when test="${trafficVal == 'expressBus'}"> 
						<h5 class="font-weight-bold">고속버스:</h5>
					</c:when>
					<c:when test="${trafficVal == 'direct'}"> 
						<h5 class="font-weight-bold"></h5>
					</c:when>
				</c:choose>
				<h5 class="ml-1 font-weight-bold">${traffic.trafficInfo}</h5>
				
			</div>
			<div>
				<!-- TODO: 콤마찍어야한다. -->
				<h5>${traffic.price}</h5>
			</div>
		</div>	
		<div class="d-flex">
			<h6 class="font-weight-bold mr-1">(</h6>
			<h6 class="font-weight-bold">${traffic.start}</h6>
			<h6 class="font-weight-bold mx-2">→</h5>
			<h6 class="font-weight-bold">${traffic.arrive}</h6>
			<h6 class="mx-1">)</h6>
		</div>
		<!-- 시간설정해야한다. -->
		<div class="d-flex mb-2 font-weight-bold text-dark">
			<div>${traffic.startDate}</div>
			<div class="mx-1">${traffic.startTime}</div>
			<div class="mx-1">-</div>
			<div class="mx-1">${traffic.arriveDate}</div>
			<div>${traffic.arriveTime}</div>
		</div>
			
		<!-- TODO: 다시 해야함!! -->
		<div class="mb-3">
			<c:set var="memo" value="${traffic.memo}" />
			<c:choose>
				<c:when test="${memo == null}">
				
				</c:when>
				<c:when test="${memo != null}">
				-  ${traffic.memo}
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