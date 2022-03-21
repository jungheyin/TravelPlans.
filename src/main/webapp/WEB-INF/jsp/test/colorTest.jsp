<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<link rel="stylesheet" type="text/css" href="/static/css/colortest.css">
</head>
<body>
   <div id="box" class="box">
      <div id="colorList">
        
      </div>
    </div>
</body>
</html>

<script>
var selectedColor;

window.onload = function(){
  init();
}

function init(){
  
  var colorChip = ["#ed5d47", "#ffcc85","#76af7b","#7BB0DB", "#b191bd"];  //색상코드를 원하는 만큼 넣어주세요~!
  var tag = "";
  for(i=0; i<colorChip.length; i++){  
      tag += "<div id="+colorChip[i]+" class='colorBox' onclick='colorSet(this)'></div>";
  }

  document.getElementById("colorList").innerHTML = tag;

  var colorBoxList = document.getElementsByClassName("colorBox");
  for(i=0; i<colorBoxList.length; i++){
    colorBoxList[i].style.background = colorBoxList[i].id; 
  }
}


function colorSet(colorPick){
  document.querySelector("body").style.background = colorPick.id; 
  

  if(selectedColor != null){  
    document.getElementById(selectedColor).className = document.getElementById(selectedColor).className.replace(" selected", "");
  }
  document.getElementById(colorPick.id).className += " selected";
  selectedColor = colorPick.id;
}

</script>