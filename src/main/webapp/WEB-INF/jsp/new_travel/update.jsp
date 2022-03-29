<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span class="font-weight-bold ml-3">PLAN</span>
	
	<div id="bgBox" class="border mt-3 ml-3">
			<div class="d-flex justify-content-between">
				<div class="font-weight-bold ml-3 mb-2 mt-3">travel name</div>
				<div>
					<img src="/static/icons/check.png" id="checkImg" width="20px" 
						class="mr-3 mt-3">
					<button type="button" id="travelSaveBtn" class="btn d-none"></button>
				</div>
			</div>
			
			<div class="d-flex justify-content-between">
			
				<input type="text" id="travelTitle" name="travelTitle" class="form-control col-6 ml-3 mb-4"
					maxlength="20" value="${travel.title}">
					
				 <div id="colorBox" class="d-flex">
				 
			      	<div id="redBox"></div>
			      	<input type="radio" name="colorRadio" class="redRadio d-none" value="#ed5d47">
			      	
			      	<label><div id="yellowBox"></div>
			      		<input type="radio" name="colorRadio" class="yellowRadio d-none" value="#ffcc85">
			      	</label>
			      	<div id="greenBox"></div>
			      	<input type="radio" name="colorRadio" class="greenRadio d-none" value="#ffcc85">
			      	
			      	<div id="skyBlueBox"></div>
			      	<input type="radio" name="colorRadio" class="skyBlueRadio d-none" value="#7BB0DB">
			      	
			      	<div id="pupleBox"></div>
			      	<input type="radio" name="colorRadio" class="pupleRadio d-none" value="#AEADCA">
			     </div> 
			</div>
			
			<!-- startDate와 endDate도 db에 넣어야한다. -->
			<div class="mx-3 mb-5">
				<div class="d-flex justify-content-around">
					<small id="star" class="m-1 font-weight-bold">Start Date</small>
					<small id="end" class="m-1 font-weight-bold">End Date</small>
				</div>
				<div class="d-flex">
					<input type="text" id="startDate" name="startDate" class="form-control mr-4" value="${travel.startDate}">
					<input type="text" id="endDate" name="endDate" class="form-control" value="${travel.startDate}">
				</div>
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
	$("#endDate").datepicker("setDate", new Date());
	
	
	$('#redBox').on('click', function() { // redBox 클깃시 redBtn이 클릭된다.
		$('.redRadio').click();
		// bgBox을 target으로 잡아 배경색으로 넣어준다.
		let target = document.getElementById("bgBox"); 
		var bgBox = target.style.backgroundColor = "#ed5d47";
	}); 
	
	$('#yellowBox').on('click', function() { // redBox 클깃시 redBtn이 클릭된다.
		$('.yellowRadio').click();
		// bgBox을 target으로 잡아 배경색으로 넣어준다.
		let target = document.getElementById("bgBox"); 
		var bgBox = target.style.backgroundColor = "#ffcc85";
	}); 
	$('#greenBox').on('click', function() { // redBox 클깃시 redBtn이 클릭된다.
		$('.greenRadio').click();
		// bgBox을 target으로 잡아 배경색으로 넣어준다.
		let target = document.getElementById("bgBox"); 
		var bgBox = target.style.backgroundColor = "#76af7b";
	}); 
	$('#skyBlueBox').on('click', function() { // redBox 클깃시 redBtn이 클릭된다.
		$('.skyBlueRadio').click();
		// bgBox을 target으로 잡아 배경색으로 넣어준다.
		let target = document.getElementById("bgBox"); 
		var bgBox = target.style.backgroundColor = "#7BB0DB";
	}); 
	$('#pupleBox').on('click', function() { // redBox 클깃시 redBtn이 클릭된다.
		$('.pupleRadio').click();
		// bgBox을 target으로 잡아 배경색으로 넣어준다.
		let target = document.getElementById("bgBox"); 
		var bgBox = target.style.backgroundColor = "#AEADCA";
	}); 
	
	
	$('#checkImg').on('click', function() {
		$('#travelSaveBtn').click();
		
		
		let title = $('#travelTitle').val().trim();
		
		if (title == '') {
			alert("여행 제목을 입력해 주세요.");
			return;
		}
		
		let color = $("input[name='colorRadio']:checked").val();
		
		if (color == null) {
			color = "#7BB0DB";
		} 
		
		let startDate = $('#startDate').val();
		let endDate = $('#endDate').val();
		
		// alert(${travel.id} + title + color + startDate + endDate);
		
		 $.ajax({
			type: "PUT"
			,url: "/new_travel/update"
			, data: {"travelId":${travel.id},"title":title, "color":color, "startDate":startDate, "endDate":endDate}
			, success: function(data) {
				if (data.result == 'success') {
					alert(title + "수정되었습니다.");
					location.href="/reservation/traffic_create_view?travelId=${travel.id}";
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