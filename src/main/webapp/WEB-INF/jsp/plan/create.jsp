<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="ml-3 mt-2">
		
	<div class="d-flex justify-content-between mt-1">
		<h5 class="font-weight-bold ml-1" >${date}</h5>
		<button class="btn btn-info btn-sm">저장</button>
	</div>
	
	<div class="d-flex justify-content-around mt-5">
		<div class="font-weight-bold mt-1">장소</div>
		<input type="text" id="planName" class="form-control col-9" placeholder="장소">
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
		<textarea id="memo" class="form-control col-9">메모</textarea>
	</div>
	
	<div class="priceBoxd-flex justify-content-around mt-5">
		<div class="font-weight-bold text-secondary mt-1 d-none">가격</div>
		<input type="text" id="price" class="form-control col-9 d-none" placeholder="가격">
	</div>
	
	<div class="d-flex justify-content-around mt-5">
		<div class="font-weight-bold text-secondary mt-1 d-none">소요시간</div>
		<input type="text" id="testTime" class="form-control col-9 mr-2 d-none" placeholder="소요시간">
	</div>
	
	<div class="d-flex justify-content-around mt-5">
		<div class="font-weight-bold text-secondary mt-1 d-none">교통수단</div>
		<input type="text" id="traffic" class="form-control col-9 mr-2 d-none" placeholder="교통수단">
	</div>
	
	<div class="d-flex justify-content-around mt-5">
		<div class="font-weight-bold mt-1 text-secondary d-none">사진</div>
		<input type="file" class=" d-none">
	</div>
	
	<hr>
	<div class="d-flex ml-2">
		<img alt="추가" src="/static/icons/plus.png" width="25px">
		<div id="subject" class="ml-2">항목추가</div>
		<button type="button" class="subjectBtn btn d-none"></button>
	</div>
	
	<div class="subjectPlus d-none m-3">
	
		<div class="mb-3">
			<div class="text-secondary font-weight-bold">가격</div>
			<button type="button" class="price btn d-none">가격</button>
		</div>
		
		<div class="mb-3">
			<div class="text-secondary font-weight-bold">소요시간</div>
			<button type="button" class="testTime btn d-none">소요시간</button>
		</div>
	
		<div class="mb-3">
			<div class="text-secondary font-weight-bold">교통수단</div>
			<button type="button" class="traffic btn d-none">교통수단</button>
		</div>
		
		<div class="mb-3">
			<div class="text-secondary font-weight-bold">사진</div>
			<button type="button" class="images btn d-none">사진</button>
		</div>
	</div>
	
</div>