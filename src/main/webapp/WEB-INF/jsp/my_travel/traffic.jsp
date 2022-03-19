<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="traffic">
	<div class="d-flex justify-content-between mr-2 mb-4">
		<div></div>
		<div class="ml-5 mt-3 font-weight-bold">
			교통수단 예약정보 등록하기
		</div>
		<a href="#"><img src="/static/icons/plus_skyBlue.png" alt="추가"
			width="45px"></a>
	</div>

	<div class="traffic d-flex justify-content-center">
		<div>
		
			<div class="d-flex justify-content-center">
				<select class="custom-select mb-2">
					<option value="airplans" selected>비행기</option>
					<option value="train">기차</option>
					<option value="expressBus">고속버스</option>
					<option value="direct">직접입력</option>
				</select>
			</div>
			
			<div class="inputBox">
				<!-- 비행기 -->
				<div id="airplansInput" class="form-group">
					<div class="font-weight-bold ml-1 mb-1">이름</div>
					<input type="text" class="form-control mb-2" placeholder="이름">

					<div class="font-weight-bold ml-1 mb-1">출발</div>
					<input type="text" class="form-control mb-2" placeholder="출발">
					<!-- 데이터피커 -->
					<div class="d-flex mb-2">
						<input type="date" class="form-control mbt-2"> 
						<input type="time" class="form-control mbt-2">
					</div>

					<div class="font-weight-bold ml-1 mb-1">도착</div>
					<input type="text" class="form-control mb-2" placeholder="도착">
					<!-- 데이터 피커 -->
					<div class="d-flex mb-2">
						<input type="date" class="form-control mbt-2"> 
						<input type="time" class="form-control mbt-2">
					</div>

					<div class="font-weight-bold ml-1 mb-1">가격</div>
					<input type="text" class="form-control mb-2" placeholder="가격">

					<div class="font-weight-bold ml-1 mb-1">메모</div>
					<textarea rows="5" class="form-control mb-2"
						placeholder="메모(50자 이내)">
					</textarea>

					<button type="button" class="trfficBtn btn w-100 mt-2 mb-4">
						S A V E
					</button>
				</div>

				<!-- 기차 -->
				<div id="trainInput" class="form-group">
					<div class="font-weight-bold ml-1 mb-1">이름</div>
					<input type="text" class="form-control mb-2" placeholder="이름">

					<div class="font-weight-bold ml-1 mb-1">출발</div>
					<input type="text" class="form-control mb-2" placeholder="출발">
					<!-- 데이터피커 -->
					<div class="d-flex mb-2">
						<input type="date" class="form-control mbt-2"> 
						<input type="time" class="form-control mbt-2">
					</div>

					<div class="font-weight-bold ml-1 mb-1">도착</div>
					<input type="text" class="form-control mb-2" placeholder="도착">
					<!-- 데이터 피커 -->
					<div class="d-flex mb-2">
						<input type="date" class="form-control mbt-2"> 
						<input type="time" class="form-control mbt-2">
					</div>

					<div class="font-weight-bold ml-1 mb-1">가격</div>
					<input type="text" class="form-control mb-2" placeholder="가격">

					<div class="font-weight-bold ml-1 mb-1">메모</div>
					<textarea rows="5" class="form-control mb-2"
						placeholder="메모(50자 이내)">
					</textarea>

					<button type="button" class="trfficBtn btn w-100 mt-2 mb-4">
						S A V E
					</button>
				</div>
				
				<!-- 고속버스 -->
				<div id="expressBusInput" class="form-group">
					<div class="font-weight-bold ml-1 mb-1">이름</div>
					<input type="text" class="form-control mb-2" placeholder="이름">	
					
					<div class="font-weight-bold ml-1 mb-1">출발</div>
					<input type="text" class="form-control mb-2" placeholder="출발">
					<!-- 데이터피커 -->
					<div class="d-flex mb-2">
						<input type="date" class="form-control mbt-2"> 
						<input type="time" class="form-control mbt-2">
					</div>

					<div class="font-weight-bold ml-1 mb-1">도착</div>
					<input type="text" class="form-control mb-2" placeholder="도착">
					
					<!-- 데이터 피커 -->
					<div class="d-flex mb-2">
						<input type="date" class="form-control mbt-2"> 
						<input type="time" class="form-control mbt-2">
					</div>

					<div class="font-weight-bold ml-1 mb-1">가격</div>
					<input type="text" class="form-control mb-2" placeholder="가격">

					<div class="font-weight-bold ml-1 mb-1">메모</div>
					<textarea rows="5" class="form-control mb-2"
						placeholder="메모(50자 이내)">
					</textarea>

					<button type="button" class="trfficBtn btn w-100 mt-2 mb-4">
						S A V E
					</button>
				</div>
				
				<!-- 직접입력 direct-->
				<div id="directInput" class="form-group">
					<div class="font-weight-bold ml-1 mb-1">이름</div>
					<input type="text" class="form-control mb-2" placeholder="이름">
					
					<div class="font-weight-bold ml-1 mb-1">출발</div>
					<input type="text" class="form-control mb-2" placeholder="출발">
					
					<!-- 데이터피커 -->
					<div class="d-flex mb-2">
						<input type="date" class="form-control mbt-2"> 
						<input type="time" class="form-control mbt-2">
					</div>

					<div class="font-weight-bold ml-1 mb-1">도착</div>
					<input type="text" class="form-control mb-2" placeholder="도착">
					<!-- 데이터 피커 -->
					<div class="d-flex mb-2">
						<input type="date" class="form-control mbt-2"> 
						<input type="time" class="form-control mbt-2">
					</div>

					<div class="font-weight-bold ml-1 mb-1">가격</div>
					<input type="text" class="form-control mb-2" placeholder="가격">

					<div class="font-weight-bold ml-1 mb-1">메모</div>
					<textarea rows="5" class="form-control mb-2"
						placeholder="메모(50자 이내)">
					</textarea>

					<button type="button" class="trfficBtn btn w-100 mt-2 mb-4">
						S A V E
					</button>
				</div>
			</div>
		</div>
	</div>
</div>
