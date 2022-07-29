<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="logoutNav d-flex justify-content-end">
	<a href="/travelplans/sign_out"> 
	<div class="font-weight-bold text-white mr-2">logout</div>
	</a>
</div>
<div class="mypageBox d-flex justify-content-between mt-1 mx-2">
	<div class="d-flex">
		<img src="/static/icons/airplan_skyBlue.png" alt="로고" width="25px"
			height="25px" class="mt-2 ml-2">
		<h4 class="font-weight-bold mt-2 mr-1">travel plans.</h4>
	</div>
	<!-- TODO: user의 nickname정보 넣기 -->
	<h6 class="font-weight-bold mt-2">${user.nickname} 님</h6>
</div>


