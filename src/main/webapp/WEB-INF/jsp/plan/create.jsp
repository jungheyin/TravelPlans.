<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="px-3 ml-5 mt-4">
	<!-- 일정제목 -->
`	<div>
		<label class="font-weight-bold mr-3 mt-2 text-secondary"
			for="planName" >
			일정
		</label>
		<input type="text" id="planName" class="form-control"
			placeholder="일정"maxlength="19">
	</div>
	
	<!-- 시간 -->
	<div class="mt-2">
		<label class="font-weight-bold mr-3 mt-2 text-secondary"
			for="time">
			시간
		</label>
		<input type="time" id="time" class="form-control">
	</div>
	
	<!-- 위치 -->
	<div class="mt-2">
		<label class="font-weight-bold mr-3 mt-2 text-secondary"
			for="location">
			위치
		</label>
		<input type="text" id="location" class="form-control"
			placeholder="위치" maxlength="499">
	</div>
	
	<!-- 비용 -->
	<div class="mt-2">
		<label class="font-weight-bold mr-3 mt-2 text-secondary"
			for="price">
			비용
		</label>
		<input type="text" id="price" class="form-control"
			placeholder="비용">
	</div>
	
	<!-- 메모 -->
	<div class="mt-2">
		<label class="font-weight-bold mr-3 mt-2 text-secondary"
			for="memo">
			메모
		</label>
		<textarea rows="3" id="memo" class="form-control"
			maxlength="49" placeholder="메모(50자 이내)"></textarea>
	</div>
	
	<button id="addBtn" class="btn w-100 mt-4"
		data-date-id="${date}"> A D D </button>
	
</div>

<script>
$(document).ready(function() {
	
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
	
	
	$('#addBtn').on('click', function() {
		
		let planName = $('#planName').val().trim();
		let time = $('#time').val().trim()
		let location = $('#location').val().trim();
		
		let priceStr = $('#price').val().trim();
		let price = priceStr.split(',').join("");
		
		let memo = $('#memo').val().trim();
		let date = $(this).data('date-id');
		
		if (planName == '') {
			alert("일정을 입력해 주세요.");
			return;
		}
		
		if (time == '') {
			alert("시간을 입력해 주세요.");
			return;
		}
		
		if (price == '') {
			price = 0;
		}
		
		alert("일정 : " + planName + "\n시간 : " + time +"\n위치 : " + location
			 + "\n비용 : " + price + "원\n메모 : " + memo);
		
		$.ajax({
			type: "POST"
			,url: "/plan/create"
			,data: {"itineraryId": ${itineraryId}, "date": date, "planName": planName, "time": time, 
					"location": location, "memo": memo, "price": price}
			, success: function(data) {
				if (data.result == 'success') {
					alert("저장성공");
					document.location.reload();
				} else {
					alert(errorMessage);
				}
			}
			, error : function(e) {
				alert("실패했습니다.");
			}
		});
	});
	
	
});
</script>
