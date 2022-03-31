<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="accommodation">

	<div class="d-flex justify-content-center mr-2 mb-4">
		<div class="ml-5 mt-3 font-weight-bold">
			숙소 예약정보 등록하기
		</div>
	</div>
	<div class="accommodation d-flex justify-content-center">

		<div>
			<div class="inputBox">
				<div class="airplansInput">
					<div class="font-weight-bold ml-1 mb-1">숙소 이름</div>
					<input type="text" id="name" class="form-control mb-2" 
						maxlength="27"placeholder="숙소 이름">


					<div class="font-weight-bold ml-1 mb-1">날짜</div>
					<div class="d-flex mb-2">
					<input type="text" id="startDate" class="form-control mr-1" placeholder="시작날짜" value="${travel.startDate}">
					<input type="text" id="endDate" name="endDate" class="form-control" placeholder="마지막날짜" value="${travel.endDate}">
					</div>
					<div class="font-weight-bold ml-1 mb-1">위치</div>
					<input type="text" id="location" class="form-control mb-2" placeholder="위치">

					<div class="font-weight-bold ml-1 mb-1">가격</div>
					<input type="text" id="price" class="form-control mb-2" placeholder="가격">

					<div class="font-weight-bold ml-1 mb-1">메모</div>
					<textarea rows="5" id="memo" class="form-control mb-2"
						maxlength="49" placeholder="메모(50자 이내)"></textarea>

					<button type="button" id="accoSaveBtn" class="btn w-100 mt-2" data-travel-id=${travel.id}>
					S A V E</button>
				</div>
			</div>

		</div>
	</div>
</div>

<script>
$(document).ready(function() {
	
	$.datepicker.setDefaults({
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
		, dateFormat: 'yy-mm-dd'
		, showButtonPanel: true
		, currentText: '오늘'
		, minDate: $('#startDate').val()
	});
	
	$('#startDate').datepicker();
	
	$('#endDate').datepicker();
	
	$("#startDate").on('change', function() {
		
		let startDate = $('#startDate').val();
		$("#startDate").datepicker("setDate",startDate);
		
	//	let arrviveDate = startDate;
		$("#endDate").datepicker("setDate", startDate);
		
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
	
	
	$('#accoSaveBtn').on('click', function(e) {
		
		let name = $('#name').val().trim();
		if (name == '') {
			alert("숙소 이름을 적어주세요.");
			return;
		}
		
		let startDate = $('#startDate').val();
		let endDate = $('#endDate').val();
		
		let location = $('#location').val().trim();
		
		let priceStr = $('#price').val().trim();
		let price = priceStr.split(',').join("");
		
		let memo = $('#memo').val().trim();
		let travelId = $(this).data('travel-id');
		
		 alert(travelId + name + startDate + endDate + location + price + memo);
		
		 $.ajax({
			type: "POST"
			, url : "/reservation/accommodation_add"
			, data: {"travelId":travelId, "name":name, "startDate":startDate, "endDate":endDate, "location":location, "price":price, "memo":memo}
			, success: function(data) {
				if (data.result == 'success') {
					alert(name + " 저장");
					location.replace("/reservation/accommodation_create_view?travelId=${travel.id}");
				} else {
					alert(errorMessage);
				}
			}
			, error: function(e) {
				alert("실패했습니다.");
			}
		}); 
	});
});
</script>