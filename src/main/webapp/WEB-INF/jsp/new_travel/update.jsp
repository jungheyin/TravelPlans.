<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span class="font-weight-bold ml-3">TRAVEL</span>
	
	<div id="bgBox" class="border mt-3 ml-3">
			<div class="d-flex justify-content-between">
				<div class="font-weight-bold ml-3 mb-2 mt-3">TRAVEL NAME</div>
				<div>
					<img src="/static/icons/airplan_skyBlue.png" id="checkImg" width="30px" 
						class="mr-3 mt-3">
					<button type="button" id="travelSaveBtn" class="btn d-none"></button>
				</div>
			</div>
			
			<input type="text" id="travelTitle" name="travelTitle" class="form-control col-6 ml-3 mb-4"
				maxlength="20" value="${travel.title}">
			
			<!-- startDate와 endDate도 db에 넣어야한다. -->
			
			<div class="d-flex ml-3">
					<div id="star" class="m-1 font-weight-bold mr-5 pr-5">START DATE</div>
					<div class="mr-5 pr-5"></div>
					<div id="end" class="m-1 font-weight-bold ml-5 pl-5">END DATE</div>
				</div>
				
				<div class="d-flex mb-5">
					<input type="text" id="startDate" name="startDate" class="form-control mx-3" value="${travel.startDate}">
					<input type="text" id="endDate" name="endDate" class="form-control mx-3" value="${travel.endDate}">
				</div>
	</div>
<script>

$(document).ready(function() {
	
	$.datepicker.setDefaults({
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
		, dateFormat: 'yy-mm-dd'
		, showButtonPanel: true
		, currentText: '오늘 날짜'
		, minDate: 0
	});
	 $.datepicker._gotoToday = function(id) {
         $(id).datepicker('setDate', new Date()).datepicker('hide').blur();
     };

	$('#startDate').datepicker({
		onSelect:function(dateText) {
            $('#endDate').datepicker('option', 'minDate', dateText);
         }
	});
	$("#startDate").datepicker("setDate", new Date());
	
	$("#endDate").datepicker();
	
	$('#checkImg').on('click', function() {
		$('#travelSaveBtn').click();
		
		
		let title = $('#travelTitle').val().trim();
		
		if (title == '') {
			alert("여행 제목을 입력해 주세요.");
			return;
		}
		
		let startDate = $('#startDate').val();
		let endDate = $('#endDate').val();
		
		 $.ajax({
			type: "PUT"
			, url: "/new_travel/update"
			, data: {"travelId":${travel.id},"title":title, "startDate":startDate, "endDate":endDate}
			, success: function(data) {
				if (data.result == 'success') {
					alert(title + " 수정되었습니다.");
					location.href="/itinerary/traffic_info_view?travelId=${travel.id}";
				} else if (data.result == 'error'){
					alert(errorMessage);
				}
			}
			, error: function(e) {
				alert("실패했습니다");
			}
		}); 
		
	
	});
	
});

</script>