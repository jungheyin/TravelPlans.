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
				<c:forEach items="${date.planTimeList}" var="plan">
						<div class="schedule mb-2 p-2" id="${plan.plan.id}">
							<div class="plan${plan.plan.id} d-flex justify-content-between" >
								<div class="d-flex">
									<div class="time ">
										<a href="#" class="timeCheckBtn" data-plan-id="${plan.plan.id}" data-itinerary-id="${date.itinerary.id}">
											<c:if test="${plan.plan.id == plan.time.planId }">
												<img alt="체크이미지" src="/static/icons/check_red.png" width="30px"
													class="ml-2">
											</c:if>
											<c:if test="${plan.plan.id != plan.time.planId }">
												${fn:substring(plan.plan.time,0,5)}
											</c:if>
										</a>
									</div>
									<div class="border-left mx-3"></div>
									<a data-toggle="collapse" href="#plan${plan.plan.id}">
									<div>
										<c:choose>
											<c:when test="${fn:length(plan.plan.planName) > 9 }">
											<div class="planName font-weight-bold">
												${fn:substring(plan.plan.planName,0,9)}
											...</div>
											</c:when>
											<c:when test="${fn:length(plan.plan.planName) < 9 }">
												<div class="planName font-weight-bold">${plan.plan.planName}</div>
											</c:when>
										</c:choose>
									</div>
								</div>
								
								<div class="d-flex">
									<!-- 수정하기 -->
									<div class="text-secondary">
										<fmt:formatNumber value="${plan.plan.price}" type="currency"/>
									</div>
									<a href="/plan/update_view?userId=${userId}&travelId=${travel.id}&itineraryId=${date.itinerary.id}&date=${date.itinerary.date}&planId=${plan.plan.id}" class="mx-3">
										<img alt="수정" src="/static/icons/change_black.png" width="20px">
									</a>
									<!-- 삭제하기 -->
									<div>
										<button class="planDelBtn btn d-none">${plan.plan.id}</button>
										<img alt="삭제" src="/static/icons/delete_red.png" width="20px"
											class="planDelImg" data-plan-id="${plan.plan.id}">
									</div>
								</div>
							</div>
						</div>
					</a>
					<div class="collapse mb-2" id="plan${plan.plan.id}">
				      <div class="card card-body">
				      	<div class="ml-5 mb-2">
							<img alt="위치아이콘" src="/static/icons/location_gray.png" height="20px"
								class="mb-1">
							<span class="font-weight-bold text-secondary mr-1">위치:</span>
							<c:choose>
								<c:when test="${empty plan.plan.location}">
									-
								</c:when>
								<c:when test="${!empty plan.plan.location}">
									${plan.plan.location}
								</c:when>
							</c:choose>	
						</div>
						<div class="ml-5">
							<img alt="메모이미지" src="/static/icons/memo_gray.png" width="20px" height="20px"
								class="mb-1">
							<span class="font-weight-bold text-secondary mr-1">메모:</span>
							<c:choose>
								<c:when test="${empty plan.plan.memo}">
									-
								</c:when>
								<c:when test="${!empty plan.plan.memo}">
									${plan.plan.memo}
								</c:when>
							</c:choose>	
						</div>
				      	
				      </div>
				    </div> 
				</c:forEach>
			</div>
			<!-- 일정 추가 박스 -->
			<a href="/plan/create_view?userId=${userId}&travelId=${travel.id}&itineraryId=${date.itinerary.id}&date=${date.date}"
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
		
		let planId = $(this).data('plan-id');
		
		$.ajax({
			type:"DELETE"
			,url: "/plan/delete"
			,data: {"planId": planId}
			,success: function(data) {
				if (data.result == "success") {
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
		
	$('.timeCheckBtn').on('click', function(e) {
		e.preventDefault();
		
		let planId = $(this).data('plan-id');
		let itineraryId = $(this).data('itinerary-id');
		console.log("planId: " + planId + "itineraryId: " + itineraryId + "클릭");
		
		$.ajax({
			url: "/time/" + planId
			, data: {"travelId": ${travel.id}, "itineraryId": itineraryId}
			, success: function(data) {
				if (data.result == "success") {
					location.reload();
				} else {
					alert(errorMessage);
				}
			}
			, error : function(e) {
				alert("실패 다시시도해 주세요.");
			}
		});
	});
});

</script>