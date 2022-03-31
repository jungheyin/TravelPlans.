<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div>
	<div class="d-flex justify-content-between">
		<h5 id="trafficSubject" class="font-weight-bold mt-3 mb-4 ml-2">숙   소</h5>
		<a href="/reservation/accommodation_create_view?travelId=${travel.id}" class="mt-1 mr-2" >
			<img src="/static/icons/plus_skyBlue.png" alt="추가" width="40px">
		</a> 
	</div>
	<c:forEach var="accommodation" items="${accommodationList}">
	<div class="border p-3 mb-3">
		<div class="d-flex justify-content-end mb-2 mr-2">
			<img src="/static/icons/delete.png" alt="삭제" width="25px">
			<button type="button" class="deleteBtn btn d-none" data-accommodation-id=${accommodation.id}></button>
		</div>
		<!-- name과 price : font-size조절하기 -->
		<div class="d-flex justify-content-between mr-5">
			<h5 class="font-weight-bold">${accommodation.name}</h5>
				<!-- TODO: 콤마찍어야한다. -->
				<h5>${accommodation.price}</h5>
		</div>	
		<!-- 시간설정해야한다. -->
		<div class="d-flex mb-2 font-weight-bold text-secondary">
			<div>${accommodation.startDate}</div>
			<div class="mx-1">-</div>
			<div class="mx-1">${accommodation.endDate}</div>
		</div>
		<div>
			<span>${accommodation.location}</span>
		</div>
		<!-- TODO: 다시 해야함!! -->
		<div class="mb-3 font-weight-bold text-dark">
			<c:set var="memo" value="${accommodation.memo}" />
			<c:choose>
				<c:when test="${memo == null}">
				
				</c:when>
				<c:when test="${memo != null}">
				-  ${accommodation.memo}
				</c:when>
			</c:choose>
		</div>
	</div>
	</c:forEach>
</div>





    
    <!-- 해야할것
    1. 체크인 체크아웃시간 넣기
    2. 날짜 마지막날 이후 안나오게 하기
     -->