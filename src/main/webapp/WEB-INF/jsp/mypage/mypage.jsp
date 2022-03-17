<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<a href="/travelplans/travelplans_view">
					<small class="font-weight-bold mr-2 text-dark">LOGOUT</small>
				</a>
			</div>
			
			<div class="mypageBox d-flex justify-content-between mt-2 mx-2">
				<h4 class="logo font-weight-bold">travle plans.</h4>
				<!-- TODO: user의 nickname정보 넣기 -->
				<h6 class="font-weight-bold mt-2">여행자 님</h6>
			</div>
			
			
		</header>
		<section class="contents">
		
			<div class="d-flex justify-content-between mx-3">
				<div>
					<h5 class="font-weight-bold">MY PLANS</h5>
				</div>
				<div class="d-flex">
					<a href="/my_travel/reservation_view" class="mx-3">
						<img src="#" alt="">
						<small class="addPlans">추가</small>
					</a>
					<a href="/mypage/setting_view">
						<img src="#" alt="">
						<small class="SettingText">설정</small>	
					</a>
				</div>
			</div>
			
			<hr>
			
			<!-- user의 my plans 리스트 -->
			<div class="d-flex flex-wrap ml-3">
				<div class="planBox">
					<div class="mt-4 ml-3">
						<!-- trip의 title  -->
						<div class="tripTitle text-dark">제주도 여행</div>
						<!-- trip의 startDate ~ endDate -->
						<div class="tripDate">10월25일 ~ 10월31일 (2022)</div>
					</div>
					
					<div class="">
						<!-- trip의 price -->
						<span class="tripPrice mr-2 text-dark">￦ 5,000</span>
						<!-- my travel 페이지로 이동 -->
						<a href="/my_travel/detail_view?tripId={tripId}">
							<img src="#" alt="들어가기">
						</a>
					</div>
				</div>
			</div>
		</section>
		
		<footer></footer>
	</div>
</body>
</html>