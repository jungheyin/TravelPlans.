<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span class="font-weight-bold ml-2">NEW PLAN</span>
	
	<div id="bgBox" class="bgBox border mt-3 ml-3">
		<div class="d-flex justify-content-between">
			<div class="font-weight-bold ml-3 mb-2 mt-3">travel name</div>
			<div>
				<img src="/static/icons/check.png" id="checkImg" width="20px" 
					class="mr-3 mt-3">
				<button id="tripSaveBtn" class="btn d-none">저장</button>
			</div>
		</div>
		<div class="d-flex justify-content-between">
			<input type="text" id="tripTitile" class="form-control col-6 ml-3 mb-5"
				placeholder="여행 제목">
		
			<div id="colorList" class="d-flex mr-5">
				<div class="redBox">
					<input type="button" class="redBtn d-none" value="redBox">
				</div>
				<div class="yellowBox mx-4"> 
					<input type="button" class="yellowBox d-none" value="yellowBox">
				</div>
				<div class="greenBox">
					<input type="button" class="greenBox d-none" value="greenBox">
				</div>
				<div class="skyBlueBox mx-4">
					<input type="button" class="skyBlueBox d-none" value="skyBlueBox">
				</div>
				<div class="pupleBox">
					<input type="button" class="pupleBox d-none" value="pupleBox">
				</div>
			</div>
		</div>
	</div>
<script>

$(document).ready(function() {
	
	
	
	$('#checkImg').on('click', function() {
		$('#tripSaveBtn').click();
		
		let tripTitle = $('#tripTitile').val().trim();
		
		if (tripTitle == '') {
			alert("여행이름을 적어주세요.");
		}
		
	
		
		alert( tripTitleredBox);
	});
	
	
});

</script>