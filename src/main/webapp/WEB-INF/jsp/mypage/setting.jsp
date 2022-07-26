<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="contents">

	<h5 class="font-weight-bold ml-4">MY PLANS</h5>
	<hr>

	<!-- user의 my plans 리스트 -->
	<c:forEach items="${travelList}" var="travel">
		<div class="border d-flex justify-content-center mb-3 mx-5 ">

			<div class="itineraryBox d-flex justify-content-between mb-3">
				<c:set var="boxColor" value="${travel.color}" />
				<div class="ml-3 mt-4 mb-4">

				<div class="travelTitle">${travel.title}</div> <!-- trip의 startDate ~ endDate (year) : 수정해야한다. -->

					<div class="d-flex">
						<div class="travelDate">
							<fmt:parseDate value="${travel.startDate}" pattern="yyyy-MM-dd"
								var="date" />
							<fmt:formatDate var="startDate" value="${date}" pattern="MM월 dd일" />
							${startDate}
						</div>
						<div class="travelDate">
							<c:choose>
								<c:when test="${travel.startDate != travel.endDate}">
										~
								<fmt:parseDate value="${travel.endDate}" pattern="yyyy-MM-dd"
										var="date" />
									<fmt:formatDate var="endDate" value="${date}" pattern="MM월 dd일" />
								${endDate}
									</c:when>
								<c:when test="${travel.startDate == travel.endDate}">

								</c:when>
							</c:choose>
						</div>

						<div class="travelDate">
							<!-- 변경해야함 -->
							(${fn:substring(travel.startDate, 0,4)})

						</div>
					</div>
				</div>

				<div class="d-flex align-items-center mr-2">

					<div class="mr-4">
						<span class="travelPrice mr-2"> ￦
							<fmt:formatNumber value="${travel.price}" type="number" />
						</span>
					</div>
					<!-- my travel 페이지로 이동 -->
					<div>
						<img src="/static/icons/multiply.png" class="deleteImg" alt="삭제" width="30px"
							height="30px">
						<button type="button" class="deleteBtn btn d-none" data-travel-id="${travel.id}"></button>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<script>
$(document).ready(function() {
	
	$('.deleteImg').on('click', function(e) {
		$('.deleteBtn').click();
		var title = $('.travelTitle').val().trim();
		var travelId = $('.deleteBtn').data('travel-id');
		var userId = ${userId};
		
		alert( travelId + " 삭제");
		
		   $.ajax({
			type: "DELETE"
			, url: "/mypage/delete"
			, data: { "userId": userId, "travelId": travelId}
			, success: function(data) {
				if (data.result == "success") {
					// 성공시 reload
					alert( "삭제");
					document.location.reload();
				} else {
					alert(errorMessage);
				}
			}
			, error: function(e) {
				alert("MY PLANS 삭제 실패");
			}
		});    
	});
	
});
</script>
