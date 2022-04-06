<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="ml-3 mt-2">
		
	<div class="d-flex justify-content-between mt-1">
		<h5 class="font-weight-bold ml-1" >${date}</h5>
		<button id="saveBtn"class="btn btn-info btn-sm" data-date=${date}>저장</button>
	</div>
	
	<div class="d-flex justify-content-around mt-5">
		<div class="font-weight-bold mt-1">장소</div>
		<input type="text" id="planName" class="form-control col-9" 
			 maxlength="19" placeholder="장소">
	</div>
	
	<div class="d-flex justify-content-around mt-5">
		<div class="font-weight-bold mt-1">시간</div>
		<input type="time" id="time" class="form-control col-9">
	</div>
	
	<div class="d-flex justify-content-around mt-5">
		<div class="font-weight-bold mt-1">위치</div>
		<input type="text" id="location" class="form-control col-9" placeholder="위치">
	</div>
	
	<div class="d-flex justify-content-around mt-5">
		<div class="font-weight-bold mt-1">메모</div>
		<textarea id="memo" class="form-control col-9"  maxlength="49">메모</textarea>
	</div>
	
	<div class="priceBox d-flex justify-content-around mt-5 d-none">
		<div id="price" class="font-weight-bold text-secondary mt-1 d-none">가격</div>
		<input type="text" id="priceInput" class="form-control col-9 d-none" placeholder="가격">
	</div>
	
	<!-- 수정해야함!! -->
	<div class="testtimeBox d-flex justify-content-around mt-5">
		<div id="testTime" class="font-weight-bold text-secondary mt-1 d-none">소요시간</div>
		<input type="number" id="testTimeInput" class="form-control col-9 mr-2 d-none" 
			 maxlength="19"placeholder="소요시간">
	</div>
	
	<div class="trafficBox d-flex justify-content-around mt-5">
		<div id="traffic" class="font-weight-bold text-secondary mt-1 d-none">교통수단</div>
		<input type="text" id="trafficInput" class="form-control col-9 mr-2 d-none" placeholder="교통수단">
	</div>
	
	<div class="imagesBox d-flex justify-content-around mt-5 mb-5">
		<div id="images"class="font-weight-bold mt-1 text-secondary d-none">사진</div>
		<input type="file" id="imagesInput" accept=".jpg, .png, .gif, .jpeg"
			class="form-control d-none">
		<input type="button" id="imagesBtn" class="btn btn-white col-9 d-none" value="업로드">
	</div>
	
	<div class="d-flex justify-content-center">
		<img alt="사진" src="" id="preview" class="d-none mb-5">
	</div>
	
	<!-- 추가항목 -->
	<div id="subject" class="d-flex ml-2">
		<img alt="추가" src="/static/icons/plus.png" width="25px">
		<div class="ml-2">항목추가</div>
	</div>
	
	
	<div class="subjectPlus d-none m-3">
	
		<div class="mb-3">
			<div class="price text-secondary font-weight-bold">가격</div>
		</div>
		
		<div class="mb-3">
			<div class="testTime text-secondary font-weight-bold">소요시간</div>
		</div>
	
		<div class="mb-3">
			<div class="traffic text-secondary font-weight-bold">교통수단</div>
		</div>
		
		<div class="mb-3">
			<div class="images text-secondary font-weight-bold">사진</div>
		</div>
			<button type="button" class="commonBtn btn d-none">버튼</button>
	</div>
	
</div>

<script>
$(document).ready(function() {
	
	$('#memo').on('click', function() {
		$(this).val('');
	});
	
	$('#subject').on('click', function() {
		
		if ($('.subjectPlus').hasClass('d-none')) {
			$('.subjectPlus').removeClass('d-none');
			return;
		} else if ($('.subjectPlus').hasClass('d-none') == false) {
			$('.subjectPlus').addClass('d-none');
			return;
		}
		
		// 추가항목이 한개라도 없을경우 클릭이 안됨!!
		// 
	});
	
	// price
	$('.price').on('click', function() {
		$('.commonBtn').click();
		
		// alert("#####");
		
		$('.price').addClass('d-none');
		$('.priceBox').removeClass('d-none');
		$('#price').removeClass('d-none');
		$('#priceInput').removeClass('d-none');
		
	});
	
	$('#price').on('click', function() {
		$('.commonBtn').click();
		
		$('.price').removeClass('d-none');
		$('.priceBox').addClass('d-none');
		$('#price').addClass('d-none');
		$('#priceInput').addClass('d-none');
		
		$('#priceInput').val('');
	});
	
	$('#priceInput').on('keyup', function() {
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
	
	// 소요시간=> 분으로 마이너스 못하게하기!!
	$('.testTime').on('click', function() {
		$('.commonBtn').click();
		
		// alert("#####");
		
		$('.testTime').addClass('d-none');
		$('.testTimeBox').removeClass('d-none');
		$('#testTime').removeClass('d-none');
		$('#testTimeInput').removeClass('d-none');
		
	});
	
	$('#testTime').on('click', function() {
		$('.commonBtn').click();
		
		$('.testTime').removeClass('d-none');
		$('.testTimeBox').addClass('d-none');
		$('#testTime').addClass('d-none');
		$('#testTimeInput').addClass('d-none');
		
		$('#testTimeInput').val('');
	});
	
	$('.traffic').on('click', function() {
		$('.commonBtn').click();
		
		// alert("#####");
		
		$('.traffic').addClass('d-none');
		$('.trafficBox').removeClass('d-none');
		$('#traffic').removeClass('d-none');
		$('#trafficInput').removeClass('d-none');
		
	});
	
	$('#traffic').on('click', function() {
		$('.commonBtn').click();
		
		$('.traffic').removeClass('d-none');
		$('.trafficBox').addClass('d-none');
		$('#traffic').addClass('d-none');
		$('#trafficInput').addClass('d-none');
		
		$('#trafficInput').val('');
	});
	
	$('#imagesBtn').on('click', function() {
		$('#imagesInput').click();
	});
	 $('.images').on('click', function() {
		$('.commonBtn').click();
		
		// alert("#####");
		
		$('.images').addClass('d-none');
		$('.imagesBox').removeClass('d-none');
		$('#images').removeClass('d-none');
		$('#imagesBtn').removeClass('d-none');
		
	}); 
	 
	 $('#images').on('click', function() {
			$('.commonBtn').click();
			
			$('.images').removeClass('d-none');
			$('.imagesBox').addClass('d-none');
			$('#images').addClass('d-none');
			$('#imagesBtn').addClass('d-none');
			
			$('#imagesInput').val('');
		});
	 
	$('#imagesInput').on('change', function(e) {
		
		let tmp = e.target.files[0];
		let img = URL.createObjectURL(tmp);
		$('#preview').attr('src', img);
		$('#preview').removeClass('d-none');
		console.log("img: " + img);
		
		let file = $('#imagesInput').val(); // 파일의 경로만 가져온다.
		console.log(file);
		if (file != "") {
			let ext = file.split('.').pop().toLowerCase(); 
			// 파일 경로를 .으로 나누고 확장자가 있는 마지막 문자열을 가져온 후 모두 소문자로 변경
			if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
					// -1 (= false)
				alert("gif, png, jpg, jpeg파일만 업로드 할 수 있습니다.");
					// 파일을 비운다.
				$('#imagesInput').val('');
				$('#preview').addClass('d-none');	
				return;
			}
		}
		
	});
	
	$('#saveBtn').on('click', function() {
		
		var date = $(this).data('date');
		
		let placeName = $('#planName').val().trim();
		
		if (placeName == '') {
			alert("장소 입력을 해주세요.");
			return;
		}
		
		let time = $('#time').val();
		let location = $('#location').val();
		let memo = $('#memo').val().trim();
		
		// price
		let priceStr = $('#priceInput').val().trim();
		let price = priceStr.split(',').join("");
		
		let testTime = $('.testTimeInput').val();
		let traffic = $('.trafficInput').val();
		
		let file = $('#imagesInput').val(); // 파일의 경로만 가져온다.
		let travelId = ${travel.id};
		
		alert(date + placeName + time + location + memo + price + 
				testTime + traffic + file);
		
		let formData = new FormData();
		formData.append("travelId", ${travel.id});
		formData.append("date", date);
		formData.append("placeName", placeName);
		formData.append("time", time);
		formData.append("location", location);
		formData.append("memo", memo);
		formData.append("price", price);
		formData.append("testTime", testTime);
		formData.append("traffic", traffic);
		formData.append("file", $('#imagesInput')[0].files[0]);
		
		$.ajax({
			type:"POST"
			, url: "/plan/create"
			, data: formData
			, enctype: "multipart/form-data"
			, processData: false 
			, contentType: false
			, success: function(data) {
				if (data.result == "success") {
					alert(placeName + " 일정 저장");
					location.href = "/itinerary/create_view?travelId=${travel.id}"
				} else {
					alert("errorMessage");
				}
			}
			, error : function(e) {
				alert("일정 저장에 실패했습니다.");
			}
		});
		
		
	}); 
	
});

</script>
