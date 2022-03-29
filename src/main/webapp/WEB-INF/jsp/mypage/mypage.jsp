<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travel plans:mypage</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	
<link rel="stylesheet" type="text/css" href="/static/css/mypage/mypage.css">
</head>
<body>
	<div id="wrap" class="container">
		
		<header>
			<div class="logoutNav d-flex justify-content-end">
				<a href="/travelplans/sign_out">
					<small class="font-weight-bold mr-2 text-dark">LOGOUT</small>
				</a>
			</div>
			
			<div class="mypageBox d-flex justify-content-between mt-1 mx-2">
				<div class="d-flex">
					<img src="/static/icons/airplan.png" alt="로고" width="25px" height="25px" class="mt-2 ml-2">
					<h4 class="font-weight-bold mt-2 mr-1">travel plans.</h4>
				</div>
				<!-- TODO: user의 nickname정보 넣기 -->
				<h6 class="font-weight-bold mt-2">${userNickname} 님</h6>
			</div>
			
			
		</header>
		<section class="contents">
		
			<div class="d-flex justify-content-between mx-4">
				<div>
					<h5 class="font-weight-bold">MY PLANS</h5>
				</div>
				<div class="d-flex">
					<label>
						<a href="/new_travel/create_view" class="mr-3">
							<img src="/static/icons/plus.png" alt="추가" width="20px">
							<small class="addPlans">추가</small>
						</a>
					</label>
					<label>
						<a href="/mypage/setting_view">
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
					
						<div class="travelTitle">${travel.title}</div>
						<!-- trip의 startDate ~ endDate (year) : 수정해야한다. -->
						
						<div class="d-flex mb-2">
							<div class="travelDate">
								<fmt:parseDate value="${travel.startDate}" pattern="yyyy-MM-dd" var="date"/>
								<fmt:formatDate var="startDate" value="${date}" pattern="MM월 dd일" />
								${startDate}
							</div>
							<div class="travelDate">
								<c:choose> 
									<c:when test="${travel.startDate != travel.endDate}">
										~
								<fmt:parseDate value="${travel.endDate}" pattern="yyyy-MM-dd" var="date"/>
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
							<span class="travelPrice mr-2">
								￦<fmt:formatNumber value="${travel.price}" type="number" />
							</span>
						</div>
						<!-- my travel 페이지로 이동 -->
						<a href="#" class="mytravelBtn mr-3">
							<img src="/static/icons/right.png" alt="들어가기" width="25px" height="25px">
						</a>
					</div>
				</div>
			</div>
			</c:forEach>
			
			
		</section>
		
	</div>
	
<script>
$(document).ready(function() {
	
	/* function itineraryBox (itineraryBox) {
		let color = "<c:out value="${boxColor}" />";
		let target = document.getElementByClassName("itineraryBox"); 
		
		if (color == "#7BB0DB") {
			target.style.backgroundColor = "#7BB0DB";
			return;
		} else if (color == "#ffcc85") {
			target.style.backgroundColor = "#ffcc85";
			return;
		} else if (color == "#76af7b") {
			target.style.backgroundColor = "#76af7b";
			return;
		} else if (color == "#7BB0DB") {
			target.style.backgroundColor = "#7BB0DB";
			return;
		} else if (color == "#AEADCA") {
			target.style.backgroundColor = "#AEADCA";
			return;
		}  */
	
});

</script>
</body>
</html>