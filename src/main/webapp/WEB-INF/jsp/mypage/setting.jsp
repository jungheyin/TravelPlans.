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
				<div class="ml-3 mt-4">

					<div class="travelTitle mt-2">${travel.title}</div>

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

				<div class="d-flex align-items-center mr-2 mt-3">
					<div>
						<a href="#" class="delCheckBtn" data-toggle="modal" data-target="#delCheckBtn"
							data-travel-id="${travel.id}" data-travel-title="${travel.title}">
							<img src="/static/icons/multiply.png" class="deleteImg" alt="삭제" width="30px"
								height="30px">
						</a>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="delCheckBtn" >
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">TRAVEL PLANS.</h5>
		      </div>
		      <div class="modal-body">
		      	<div class="d-flex justify-content-center font-weight-bold p-2 mb-4">
		        	'${travel.title}' 의 PLAN을 삭제하겠습니까?
		        </div>
		        <div class="d-flex justify-content-center m-3">
			      	<button class="modalCancBtn btn col-4 mr-4 py-2" 
			      		data-dismiss="modal">뒤로가기</button>
			       	<button type="button" class="modalDelBtn btn col-4">
			       		삭제하기</button>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
	</c:forEach>
</div>

<script>
$(document).ready(function() {
	
	$('.delCheckBtn').on('click', function(e) {
		e.preventDefault();
		
		let travelId = $(this).data('travel-id');
		$('#delCheckBtn').data('travel-id', travelId);
		
	});
	
 	$('#delCheckBtn .modalDelBtn').on('click', function(e) {
		
 		let travelId = $('#delCheckBtn').data('travel-id');
 		
 		console.log("삭제 travelId: " + travelId);
 		
 		 $.ajax({
 			type: "DELETE"
 			, url: "/travel/delete"
 			, data: {"travelId": travelId}
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
