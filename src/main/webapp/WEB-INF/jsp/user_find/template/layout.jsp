<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travel plans:아이디/비밀번호 찾기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/static/css/user/find_user.css">
</head>
<body>
	
	<div id="wrap" class="container">
		<div class="travelPlansVar">
			<a href="/travelplans/travelplans_view/">
				<div class="font-weight-bold text-white ml-3">travel plans.</div>
			</a>
		</div>
		<header>
			<jsp:include page="../include/gnb.jsp" />
		</header>
		<section class="content">
			<jsp:include page="../${findUserView}.jsp"></jsp:include>
		</section>
		<footer class="d-flex justify-content-center">
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>