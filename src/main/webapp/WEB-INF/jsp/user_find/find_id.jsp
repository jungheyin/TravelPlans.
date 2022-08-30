<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="d-flex justify-content-center w-100 mt-5">
	<div class="font-weight-bold">당신의 아이디는 </div>
</div>

<div class="d-flex justify-content-center w-100 mt-5">
	<div class="font-weight-bold loginId">
		<c:forEach items="${userList}" var="user">
			<h6 class="font-weight-bold">
				<c:set value="${fn:length(user.loginId)}" var="idLength"/>
				<c:set value="${fn:substring(user.loginId, idLength-3 , idLength)}" var="end" />
				${fn:replace(user.loginId, end, '***')}
			</h6>
		</c:forEach>
	</div>
</div>

<div class="d-flex justify-content-center w-100 mt-5">
	<div class="font-weight-bold">입니다.</div>
</div>
