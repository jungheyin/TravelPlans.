<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div>
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
 		<c:forEach items="${dateListView}" var="date">
		<!-- 일정 총합의 비용을 넣어준다. -->
		<div class="mt-2 mr-5 pr-5 font-weight-bold text-white">
			 <fmt:formatNumber value="${itineraryPrice}" type="currency"/>
		</div>
	</div>
	
 	<div>
			<div class="d-flex mt-2 ml-4 mb-3">
				<div class="date font-weight-bold mr-3 mt-1">
					${date.date}
				</div>
				<div>
					<c:choose>
						<c:when test="${empty date.itinerary.title}">
							<div class="d-flex">
								<input type="text" class="title form-control" id="${date.date}" placeholder="제목 입력하기">
								<div class="ml-2">
									<button class="titleAddBtn btn d-none">${date.date}</button>
									<img src="/static/icons/plus_skyBlue.png" alt="저장하기" data-target="${date.date}"
										class="titleAddImg" width="35px">
								</div>								
							</div>
						</c:when>
						<c:when test="${!empty date.itinerary.title}">
						 	<div class="d-flex">
						 		<input type="text" class="titleUpdate form-control" id="${date.date}" value="${date.itinerary.title}">
						 		<div class="ml-3">
						 			<button class="titleUpdateBtn btn d-none" >${date.date}</button>
						 			<img src="/static/icons/change_skyBlue.png" alt="수정하기" data-target="${date.date}"
										data-itiner-id="${date.itinerary.id}" class="titleUpdateImg mt-2" width="20px">
						 		</div>
						 	</div>
						</c:when>
					</c:choose>
				</div>
				
			</div>
			<!-- 일정 박스 --> 	
			<div class="mx-3">
				<!-- planName0, time0, locaiton, memo , price0 -->
				<c:forEach items="${date.plan}" var="plan">
					<div class="schedule border rounded  mb-2 p-1 pl-4" id="${plan.id}">
						<div class=" d-flex justify-content-between mt-1">
							<div class="d-flex">
								<div>${plan.time}</div>
								<div class="border-left mx-3"></div>
								<div>
									<div class="fullPlanName font-weight-bold d-none">${plan.planName}</div>
									
									<div class="d-flex">
										<div class="planName font-weight-bold">${fn:substring(plan.planName, 0, 7)}</div>
										<div class="planName font-weight-bold">
											<c:if test="${fn:length(plan.planName) > 7 }">...</c:if>
										</div>
									</div>
								
								</div>
								
								
							</div>
							<div class="d-flex mr-2">
								<!-- 수정하기 -->
								<div class="text-secondary">
									<fmt:formatNumber value="${plan.price}" type="currency"/>
								</div>
								<a href="/plan/update_view?travelId=${travel.id}&itineraryId=${date.itinerary.id}&date=${date.itinerary.date}&planId=${plan.id}" class="mx-3">
									<img alt="수정" src="/static/icons/change_black.png" width="20px">
								</a>
								<!-- 삭제하기 -->
								<div>
									<button class="planDelBtn btn d-none">${plan.id}</button>
									<img alt="삭제" src="/static/icons/delete_red.png" width="20px"
										class="planDelImg" data-plan-id="${plan.id}" data-target="${date.itinerary.id}">
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- 일정 추가 박스 -->
			<a href="/plan/create_view?travelId=${travel.id}&itineraryId=${date.itinerary.id}&date=${date.date}"
				class="planLink" data-itiner-id="${date.itinerary.id}">
				<div class="planBox d-flex justify-content-end mx-3 pr-2">
					<img src="/static/icons/plus_red.png" alt="추가" height="30px" class="p-1">
				</div>
			</a>	
			<div class="mx-3">
			<hr>
			</div>
			
			<!-- 결과 -->
			<div class="resultBox d-flex justify-content-end mr-5 mb-3">
				<div class="mr-5 text-dark font-weight-bold pr-2"> 
				<fmt:formatNumber value="${date.planPrice}" type="currency"/>
				</div>
			</div>
 		</c:forEach>
 	</div>
		
<script>
$(document).ready(function() {
	
 
	 
	
	// 저장하기
	$('.titleAddImg').on('click', function() {
		$('.titleAddBtn').click();
		
		let travelId = ${travel.id};
		let date = $(this).attr('data-target');
		let title = $('#' + date).val();
		
		if (title == '') {
			alert("제목을 입력해주세요.");
			return;
		}
		
		$.ajax({
			type: "POST"
			, url: "/itinerary/create"
			, data: {"travelId": travelId, "date": date, "title": title}
			, success: function(data) {
				if (data.result == 'success') {
					alert(date + "\n" + title + " 저장");
					document.location.reload();
				} else if (data.result == 'error'){
					alert(errorMessage);
				}
			}
			, error : function(e) {
				alert(date + "\n 저장 실패");
			}
		});
	});

	// 수정하기
	$('.titleUpdateImg').on('click', function() {
		$('.titleUpdateBtn').click();
		
		let itineraryId = $('.titleUpdateImg').data('itiner-id');
		let travelId = ${travel.id};
		let date = $(this).attr('data-target');
		let title = $('#' + date).val();
		
		$.ajax({
			type: "PUT"
			, url: "/itinerary/update"
			, data: {"itineraryId": itineraryId, "travelId": travelId, "date": date, "title": title}
			, success: function(data) {
				if (data.result == 'success') {
					alert(date + "\n" + title + " 수정");
					document.location.reload();
				} else if (data.result == 'error'){
					alert(errorMessage);
				}
			}
			, error : function(e) {
				alert(date + "\n 수정실패");
			}
		});
	});
	
	$('.planLink').on('click', function(e) {
		
		let itineraryId = $(this).data('itiner-id');
		
		if (itineraryId == false) {
			alert("제목을 입력해 주세요.");
			e.preventDefault();
			return;
		}
	});
	
	// 삭제하기
	$('.planDelImg').on('click', function() {
		$('.planDelBtn').click();
		
		let itineraryId = $(this).attr('data-target');
		let planId = $(this).data('plan-id');
		
		alert(itineraryId + planId + "삭제");
		
		$.ajax({
			type:"DELETE"
			,url: "/plan/delete"
			,data: {"planId": planId, "itineraryId": itineraryId}
			,success: function(data) {
				if (data.result == "success") {
					alert("삭제");
					document.location.reload();
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