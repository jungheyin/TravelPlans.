<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<div class="itinerary">
	<a href="/itinerary/date_list_view?travelId=${travel.id}" class="d-flex justify-content-end mr-2">
		<h6 class="font-weight-bold text-white mt-1">itinerary</h6>
	</a>
</div>
<div>
	<div class="d-flex">
		<img src="/static/icons/airplan_skyBlue.png" alt="로고" width="25px"
			height="25px" class="mt-2 ml-2">
		<h4 class="font-weight-bold mt-2 mr-1">travel plans.</h4>
	</div>
	
	<div class="d-flex justify-content-end mr-2 mt-4 ">
		<div class="font-weight-bold text-secondary">
			${date}
		</div>
	</div>
	
	<c:forEach items="${dateListView}" var="itiner">
		<c:if test="${date ==  itiner.date}">
			<div class="d-flex justify-content-end mr-2 mt-1">
				<h3 class="gnbDate">
					${itiner.itinerary.title}
				</h3>
			</div>
		</c:if>
	</c:forEach>
	<div class="mx-1">
		<hr>
	</div>
	
	
	<div class="d-flex justify-content-end mr-2">
		<div class="">
			
		</div>
	</div>
	
</div>	