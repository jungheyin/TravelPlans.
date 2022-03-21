<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="traffic">
	<div class="d-flex justify-content-center mr-2 mb-4">
		<div class="ml-5 mt-3 font-weight-bold">
			교통수단 예약정보 등록하기
		</div>
	</div>

	<div class="traffic d-flex justify-content-center">
		<div>
		
			<div class="d-flex justify-content-center">
				<select class="category custom-select mb-2" id="category">
					<option value="choice">선택</option>
					<option value="airplans">비행기</option>
					<option value="train">기차</option>
					<option value="expressBus">고속버스</option>
					<option value="direct">직접입력</option>
				</select>
			</div>
			
			<div class="inputBox">
				<div id="airplansInput" class="form-group">
					<div class="font-weight-bold ml-1 mb-1">이름</div>
					<input type="text" class="trafficInfo form-control mb-2" placeholder="이름">

					<div class="font-weight-bold ml-1 mb-1">출발</div>
					<input type="text" class="start form-control mb-2" placeholder="출발">
					<!-- 데이터피커 -->
					
					<div class="d-flex mb-2">
						<input type="date" class="startDatepicker form-control mbt-2"> 
						<input type="time" class="startTimepicker form-control mbt-2">
					</div>

					<div class="font-weight-bold ml-1 mb-1">도착</div>
					<input type="text" class="arrive form-control mb-2" placeholder="도착">
					<!-- 데이터 피커 -->
					<div class="d-flex mb-2">
						<input type="date" class="arriveDatepicker form-control mbt-2"> 
						<input type="time" class="arriveTimepicker form-control mbt-2">
					</div>

					<div class="font-weight-bold ml-1 mb-1">가격</div>
					<input type="text" class="price form-control mb-2" placeholder="가격"
						 oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">

					<div class="font-weight-bold ml-1 mb-1">메모</div>
					<textarea rows="5" class="memo form-control mb-2"
						placeholder="메모(50자 이내)"></textarea>

					<button type="button" class="trafficBtn btn w-100 mt-2 mb-4">
						S A V E
					</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function(e) {
	
	// new plan 여행 제목과 색상 가져가기
	
	
	
	// 교통수단 정보 등록하기
	// select value값 저장하기
	/* $('.category').on('change', function() {
		let target = document.getElementById('category');
		var traffic = target.options[target.selectedIndex].value;
		
	}); */
	// validation check
	$('.trafficBtn').on('click', function() {
		//alert("클릭");

		let target = document.getElementById('category');
		var traffic = target.options[target.selectedIndex].value;
		console.log(traffic);
		
		if (traffic == 'choice') {
			alert("교통수단을 선택해 주세요.");
			return;
		} 
		
		let trafficInfo = $('.trafficInfo').val().trim();
		if (trafficInfo == '') {
			alert("이름을 입력해 주세요.");
			return;
		}
		
		let start = $('.start').val().trim();
		if (start == '') {
			alert("출발지를 입력해주세요");
			return;
		}
		
		let startDatepicker = $('.startDatepicker').val();
		let startTimepicker = $('.startTimepicker').val();
		
		let arrive = $('.arrive').val().trim();
		let arriveDatepicker = $('.arriveDatepicker').val();
		let arriveTimepicker = $('.arriveTimepicker').val();
		
		let price = $('.price').val().trim();
		let memo = $('.memo').val().trim();
		
		
		$.ajax({
			type: "POST"
			, url: "/my_travel/reservation_traffic_add"
			, data: {"traffic":traffic, "trafficInfo":trafficInfo, 
					"start":start, "startDatepicker":startDatepicker,"startTimepicker":startTimepicker, 
					"arrive":arrive, "arriveDatepicker":arriveDatepicker, "arriveTimepicker":arriveTimepicker, 
					"price":price, "memo":memo}
			, success: function(data) {
				if (data.result == 'success') {
					// 성공 - 새로고침
				 alert("성공");
				} else {
					// 실패
					alert("실패");
				}
			}
			, error : function(e) {
				alert("저장에 실패했습니다.");
			}
		});
	});
});

</script>
