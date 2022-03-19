<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="accommodation">

	<div class="d-flex justify-content-between mr-2 mb-4">
		<div></div>
		<div class="ml-5 mt-3 font-weight-bold">
			숙소 예약정보 등록하기
		</div>
		<a href="#"><img src="/static/icons/plus_skyBlue.png" alt="추가"
			width="45px"></a>
	</div>
	<div class="accommodation d-flex justify-content-center">

		<div>
			<div class="inputBox">
				<div class="airplansInput">
					<div class="font-weight-bold ml-1 mb-1">숙소 이름</div>
					<input type="text" class="form-control mb-2" placeholder="숙소 이름">

					<div class="font-weight-bold ml-1 mb-1">위치</div>
					<input type="text" class="form-control mb-2" placeholder="위치">

					<div class="font-weight-bold ml-1 mb-1">날짜</div>
					<input type="text" class="form-control mb-2" placeholder="날짜">

					<div class="font-weight-bold ml-1 mb-1">가격</div>
					<input type="text" class="form-control mb-2" placeholder="가격">

					<div class="font-weight-bold ml-1 mb-1">메모</div>
					<textarea rows="5" class="form-control mb-2"
						placeholder="메모(50자 이내)"></textarea>

					<button type="button" class="accomSaveBtn btn w-100 mt-2">
					S A V E</button>
				</div>
			</div>

		</div>
	</div>
</div>