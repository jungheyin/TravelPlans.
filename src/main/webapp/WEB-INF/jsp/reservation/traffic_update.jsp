<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="traffic">
	<div class="d-flex justify-content-center mr-2 mb-4">
		<div class="ml-5 mt-3 font-weight-bold">
			교통수단 예약정보 수정하기
		</div>
	</div>

	<div class="traffic d-flex justify-content-center">
		<div>
			<div class="d-flex justify-content-center">
				
				<select class="category custom-select mb-2" id="category">
					<option value="choice">교통수단 선택</option>
					<option value="airplans">비행기</option>
					<option value="train">기차</option>
					<option value="expressBus">고속버스</option>
					<option value="direct">직접입력</option>
				</select>
			</div>
			
			<div class="inputBox">
				<div id="airplansInput" class="form-group">
					<div id="trafficInfo" class="font-weight-bold ml-1 mb-1">이름</div>
					<input type="text" class="trafficInfoInput form-control mb-2" maxlength="20" placeholder="교통수단을 선택해 주세요."
						 value="${traffic.trafficInfo}">

					<div class="font-weight-bold ml-1 mb-1">출발</div>
					<input type="text" class="start form-control mb-2" value="${traffic.start}">
					
					
					<!-- 데이터피커 -->
					<div class="d-flex mb-2">
						<input type="text" id="startDate" class="form-control mb-2 mr-1" value="${traffic.startDate}"> 
						<input type="time" id="startTime" class="form-control mb-2" value="${traffic.startTime}">
					</div>

					<div class="font-weight-bold ml-1 mb-1">도착</div>
					<input type="text" class="arrive form-control mb-2" value="${traffic.arrive}">
					
					
					<!-- 데이터 피커 -->
					<div class="d-flex mb-2">
						<input type="text" id="arriveDate" class="form-control mb-2 mr-1" value="${traffic.arriveDate}"> 
						<input type="time" id="arriveTime" class="form-control mb-2" value="${traffic.arriveTime}">
					</div>


					<div class="font-weight-bold ml-1 mb-1">가격</div>
					<input type="text" id="price" class=" form-control mb-2" value="${traffic.price}">

					<div class="font-weight-bold ml-1 mb-1">메모</div>
					<textarea rows="5" class="memo form-control mb-2" maxlength="49"
						placeholder="메모(50자 이내)">${traffic.memo}</textarea>

					<button type="button" id="trafficBtn" class="btn w-100 mt-2 mb-4" data-travel-id=${travel.id}>
						S A V E
					</button>
				</div>
			</div>
		</div>	
	</div>
</div>

<script>
$(document).ready(function(e) {
	
	$.datepicker.setDefaults({
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
		, dateFormat: 'yy-mm-dd'
		, showButtonPanel: true
		, currentText: '오늘'
		, minDate: 0
	});
	
	$("#startDate").datepicker({
		onSelect:function(dateText) {
            $('#arriveDate').datepicker('option', 'minDate', dateText);
         }
	});
	
	$("#arriveDate").datepicker();
	
	$("#startDate").on('change', function() {
		
		let startDate = $('#startDate').val();
		$("#startDate").datepicker("setDate",startDate);
		
		let arrviveDate = startDate;
		$("#arriveDate").datepicker("setDate", arrviveDate);
		
	});
	
	
	$('.category').on('change', function() {
		let target = document.getElementById('category');
		var traffic = target.options[target.selectedIndex].value;
		console.log(traffic);
		
		if (traffic == 'choice') {
			$('#trafficInfo').text("이름");
			$('.trafficInfoInput').attr("placeholder", "교통수단을 선택해 주세요.");
			return;
		} else if (traffic == 'airplans') {
			$('#trafficInfo').text("항공사");
			$('.trafficInfoInput').attr("placeholder", "항공사");
			return;
		} else if (traffic == 'train') {
			$('#trafficInfo').text("기차 종류");
			$('.trafficInfoInput').attr("placeholder", "기차 종류");
			return;
		} else if (traffic == 'expressBus') {
			$('#trafficInfo').text("버스 종류");
			$('.trafficInfoInput').attr("placeholder", "버스 종류");
			return;
		} else if (traffic == 'direct') {
			$('#trafficInfo').text("이름");
			$('.trafficInfoInput').attr("placeholder", "이름");
			return;
		} 
	});
	
	$('.trafficInfoInput').on('click', function() {
		let target = document.getElementById('category');
		var traffic = target.options[target.selectedIndex].value;
		console.log(traffic);
		
		if (traffic == 'choice') {
			alert("교통수단 선택을 먼저해주세요.");
			$(this).attr("readonly", true);
			return;
		} else if (traffic != 'choice') {
			$(this).attr("readonly", false);
			return;
		}
	});
	
	$('#price').on('keyup', function() {
		let target = $('#price').val();
		target = target.replace(/,/gi, '');
		
		let regexg =  /^[0-9]*$/;
		
		if(!regexg.test(target)) {
			$(this).val('');
			return;
		} else {
			target = target.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			
			$(this).val(target);
		}
		
	});
	
	$('#trafficBtn').on('click', function() {

		let target = document.getElementById('category');
		var traffic = target.options[target.selectedIndex].value;
		
		if (traffic == 'choice') {
			alert("교통수단을 선택해 주세요.");
			return;
		} 
		
		let trafficInfo = $('.trafficInfoInput').val().trim();
		if (trafficInfo == '') {
			alert("이름을 입력해 주세요.");
			return;
		}
		
		let start = $('.start').val().trim();
		if (start == '') {
			alert("출발지를 입력해주세요");
			return;
		}
		
		let startDate = $('#startDate').val();
		let startTime = $('#startTime').val();

		
		let arrive = $('.arrive').val().trim();
		let arriveDate = $('#arriveDate').val();
		let arriveTime = $('#arriveTime').val();
		
		let priceStr = $('#price').val().trim();
		let price = priceStr.split(',').join("");
		
		let memo = $('.memo').val().trim();
		
		let travelId = $(this).data('travel-id');
		
		alert( traffic + "\n 이름: " + trafficInfo + "\n 출발: " + start + "(" +startDate + " " + startTime + ") \n 도착: " 
				+ arrive + " (" + arriveDate + " " + arriveTime +  ") \n 가격: " +  price + "\n 메모: " + memo);
		
		   $.ajax({
			type: "PUT"
			, url: "/reservation/traffic_update"
			, data: {"trafficId": ${traffic.id},"travelId":travelId, "traffic":traffic, "trafficInfo":trafficInfo, 
					"start":start, "startDate":startDate,"startTime":startTime, 
					"arrive":arrive, "arriveDate":arriveDate, "arriveTime":arriveTime, 
					"price":price, "memo":memo}
			, success: function(data) {
				if (data.result == 'success') {
					 alert(start + " → " + arrive +" 수정");
					 location.href="/itinerary/traffic_info_view?userId=${userId}&travelId=${travel.id}";
				} else {
					alert("수정에 실패했습니다.");
				}
			}
			, error : function(e) {
				alert("실패");
			}
		});  
	});
});

</script>
