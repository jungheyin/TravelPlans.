<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
    
<div>
	<div class="nav-title d-flex justify-content-between">
		<img src="/static/icons/schedule_white.png" alt="일정" width="25px" height="30px" 
		class="mx-3 mt-1">
		<!-- <div class="d-flex mt-2 mr-4">
			<h5 class="font-weight-bold text-white mr-3"> 일 </h5>
			<h5 class="font-weight-bold text-white"> 정 </h5>
		</div> -->
		<h5 class="font-weight-bold text-white mt-2 mr-4">Date</h5>
	</div>

	<ul class="nav d-flex justify-content-end mt-4 mr-2">
		<li class="nav-item">
		<c:forEach var="date" items="${travelDateList}">
		    <a href="/plan/create_view?travelId=${travel.id}&date=${date}" class="nav-link mb-2">
			   ${date}
		    </a>
		</c:forEach>
		</li>
	</ul>
</div>
<script>
$(document).ready(function() {
	
});
</script>