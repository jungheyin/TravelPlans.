<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="travelBox border mt-3 ml-3">
	<div class="d-flex justify-content-between mx-3 mt-3">
		<div class="font-weight-bold text-secondary">travel name</div>
		<a href="/new_travel/update_view?travelId=${travel.id}">
			<img alt="수정" src="/static/icons/setting_skyBlue.png" width="20px">
		</a>
	</div>
	<h5 class="font-weight-bold text-secondary ml-3 mt-3">${travel.title}</h5>

	<div class="d-flex ml-3 mb-3">
		<!-- 2022-03-22 -->
		<small class="font-weight-bold text-secondary"> 
			<fmt:parseDate
				value="${travel.startDate}" pattern="yyyy-MM-dd" var="date" /> 
			<fmt:formatDate
				var="startDate" value="${date}" pattern="MM월 dd일" /> ${startDate}
		</small> 
		<small class="font-weight-bold text-secondary"> 
			<c:choose>
				<c:when test="${travel.startDate != travel.endDate}">
						~
					<fmt:parseDate value="${travel.endDate}" pattern="yyyy-MM-dd" var="date" />
					<fmt:formatDate var="endDate" value="${date}" pattern="MM월 dd일" />
						${endDate}
				</c:when>
				<c:when test="${travel.startDate == travel.endDate}"></c:when>
			</c:choose>
		</small> 
		<small class="font-weight-bold text-secondary">
			(${fn:substring(travel.startDate, 0,4)}) 
		</small>
	</div>

</div>