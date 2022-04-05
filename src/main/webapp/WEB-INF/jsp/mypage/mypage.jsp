<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="contents">

	<div class="d-flex justify-content-between mx-4">
		<div>
			<h5 class="font-weight-bold">MY PLANS</h5>
		</div>
		<div class="d-flex">
			<label> 
			<a href="/new_travel/create_view?userId=${userId}" class="mr-3"> 
				<img src="/static/icons/plus.png" alt="추가" width="20px"> 
				 <small class="addPlans">추가</small>
			</a>
			</label> 
			<label> 
			<a href="/mypage/setting_view?userId=${userId}"> 
				<img src="/static/icons/setting.png" alt="설정" width="20px"> 
				<small class="SettingText">설정</small>
			</a>
			</label>
		</div>
	</div>

	<hr>

	<!-- user의 my plans 리스트 -->
	<c:forEach items="${travelList}" var="travel">
		<div class="d-flex justify-content-center mb-3">

			<div class="itineraryBox d-flex justify-content-between">
				<c:set var="boxColor" value="${travel.color}" />
				<div class="ml-3 mt-4">

						<div class="travelTitle">${travel.title}</div> <!-- trip의 startDate ~ endDate (year) : 수정해야한다. -->

					<div class="d-flex mb-2">
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
						<span class="travelPrice mr-2"> ￦<fmt:formatNumber
								value="${travel.price}" type="number" />
						</span>
					</div>
					<!-- my travel 페이지로 이동 -->
					<a href="/itinerary/traffic_info_view?travelId=${travel.id}" class="mytravelBtn mr-3"> 
						<img src="/static/icons/right.png" alt="들어가기" width="25px"
						height="25px">
					</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>


