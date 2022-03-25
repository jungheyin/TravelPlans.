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
					<input type="text" id="date" class="form-control mb-2" placeholder="날짜" value="${trip.startDate}">
					
					<div class="font-weight-bold ml-1 mb-1">위치</div>
					<input type="text" id="location" class="form-control mb-2" placeholder="위치">

					<div class="font-weight-bold ml-1 mb-1">가격</div>
					<input type="text" id="price" class="form-control mb-2" placeholder="가격"
						 oninput="this.value = this.value.replace(/[^0-9.]/g, '')">

					<div class="font-weight-bold ml-1 mb-1">메모</div>
					<textarea rows="5" id="memo" class="form-control mb-2"
						maxlength="49" placeholder="메모(50자 이내)"></textarea>

					<button type="button" id="accomSaveBtn" class=" btn w-100 mt-2">
					S A V E</button>
				</div>
			</div>

		</div>
	</div>
</div>

<script>
$(document).ready(function() {
	
	$("#date").datepicker({
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
		, dateFormat: 'yy-mm-dd'
		, showButtonPanel: true
		, currentText: '오늘'
		, minDate: 0
	});
	
	// price
	$('#price').on('keyup', function() {
		let target = $(this).val();
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
	
	$('#accomSaveBtn').on('click', function() {
		
		let name = $('#name').val().trim();
		if (name == '') {
			alert("숙소 이름을 적어주세요.");
			return;
		}
		
		let date = $('#date').val();
		
		let location = $('#location').val().trim();
		let price = $('#price').val().trim();
		let memo = $('#memo').val().trim();
		
		alert(name + date + location + price + memo);
		
		$.ajax({
			type: "POST"
			, url : "/my_travel/reservation_accommodation_add"
			, data: {"name":name, "date":date, "location":location, "price":price, "memo":memo}
			, success: function(data) {
				if (data.result == 'success') {
					alert(name + "저장");
					location.replace("/my_travel/reservation_accommodation_view");
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