<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="ml-3">

	<h5 id="planSub" class="ml-1">여행일정</h5>
	
	<div id="dateBox" class="d-flex justify-content-between mb-3">
	
		<div class="d-flex">
			<img src="/static/icons/schedule_white.png" width="30px" height="30px" class="m-1">
			<!--  날짜 형식대로 바꾸기 -->
			<div class="d-flex font-weight-bold mt-2 ml-2 text-white">
				<div>${travel.startDate}</div>
				<div class="mx-2">~</div>
				<div>${travel.endDate}</div>
			</div>
		</div>
		<!-- 일정 총합의 비용을 넣어준다. -->
		<div class="mt-2 mr-5 font-weight-bold text-white">￦500,000</div>
	</div>
	
	<div class="mt-4 ml-2">
		<c:forEach var="date" items="${travelDateList}">
			<div class="d-flex ">
			
				<!-- TODO: 날짜 형식 바꾸기!! -->
				<div class="font-weight-bold  mt-1 ml-2">${date}</div>
				
				<a href="/plan/create_view?travelId=${travel.id}&date=${date}">
					<input type="text" class="title form-control ml-2" placeholder="제목">
				</a>
				<!--  <div>
				 	<img src="/static/icons/done.png" alt="추가" width="20px" class="saveImg">
				 	<img src="/static/icons/update.png" alt="변경" width="20px" class="updateBtn">
				 	
				 	<button class="saveImg btn d-none">추가</button>
				 	<button class="updateBtn btn d-none">변경</button>
				 </div>  -->
			</div>
			
			<div>
			
			
			</div>
			
			<div class="planBox mt-3 d-flex justify-content-end ml-1">
				<a href="/plan/create_view?travelId=${travel.id}&date=${date}" class="mr-3 mt-1">
					<img src="/static/icons/plus_red.png" width="30px">
				</a>
			</div>
			<hr>
			<div class="resultBox d-flex justify-content-end mb-4 ml-1">
				<div class="mt-2 mr-4 font-weight-bold">￦500,000</div>
			</div>
		</c:forEach>
		<div class="mb-5"></div>
	</div>
	
	
	
	
	
	
</div>
 <script>
 $(document).ready(function() {
	 
	
 });
 
 </script>
 