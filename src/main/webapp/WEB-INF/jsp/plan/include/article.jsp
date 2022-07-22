<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
  
<div class="">
	<div class="d-flex ml-5 mb-2">
		<div>
			<img alt="달력아이콘" src="/static/icons/planner_skyBlue.png" width="35px" height="32px">
		</div>
		<div>
		<h4 class="schedule ml-3 mt-1">SCHEDULE</h4></div>
	</div>
	
	<!-- planList -->
	
	<div>
		<div class="border rounded d-flex justify-content-between p-3">
			<div class="d-flex">
				<!-- 시간 -->
				 <div class="ml-1">7:30</div>
				 <div class="mx-2">|</div>
				 <!-- 제목 -->
				 <div class="planName">호텔 조식 먹기</div>
			 </div>
			 <div class="d-flex">
				 <a href="/plan/update_view?travelId=${travel.id}&itineraryId=${itineraryId}&date=${date}&planId=${plan.id}" class="mr-2">
				 	<img alt="수정" src="/static/icons/update.png" width="20px"
				 		class="updateImg">
				 </a>
				 <div>
				 	<button class="delBtn btn d-none">삭제</button>
					 <img alt="삭제" src="/static/icons/delete_red.png" width="20px"
					 	class="delImg">
				 </div>
			 </div>
		</div>
	</div>
	
</div>

<script>

$(document).ready(function() {
	
	// 삭제
	$('.delImg').on('click', function() {
		$('.delBtn').click();
		
		alert("삭제");
	});
	
});

</script>