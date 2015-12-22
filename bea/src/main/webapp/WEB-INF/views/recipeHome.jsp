<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/button.css" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<title>MENU</title>
<style type='text/css'>

	a:link		{color:black;text-decoration:none;}
	a:visited	{color:black;text-decoration:none;}
	a:hover		{color:black;text-decoration:none;}
.data {
	-moz-box-shadow:inset 0px 1px 0px 0px #FFBB00;
	-webkit-box-shadow:inset 0px 1px 0px 0px #FFBB00;
	box-shadow:inset 0px 1px 0px 0px #FFA7A7;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #F29661), color-stop(1, #F29661) );
	background:-moz-linear-gradient( center top, #F29661 5%, #F29661 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#F29661', endColorstr='#F29661');
	background-color:#F29661;
	-moz-border-radius-topleft:10px;
	border-top-left-radius:10px;
	-webkit-border-top-right-radius:10px;
	-moz-border-radius-topright:10px;
	border-top-right-radius:10px;
	-webkit-border-bottom-right-radius:10px;
	-moz-border-radius-bottomright:10px;
	border-bottom-right-radius:10px;
	-webkit-border-bottom-left-radius:10px;
	-moz-border-radius-bottomleft:10px;
	border-bottom-left-radius:10px;
	text-indent:0px;
	border:1px solid #dcdcdc;
	display:inline-block;
	color:#F29661;
	font-family:Arial;
	font-size:12px;
	font-weight:bold;
	font-style:normal;
	height:35px;
	line-height:35px;
	width:61px;
	text-decoration:none;
	text-align:center;
	
}
.data:hover {
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ffbb00), color-stop(1, #ffbb00) );
	background:-moz-linear-gradient( center top, #ffbb00 5%, #ffbb00 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffbb00', endColorstr='#ffbb00');
	background-color:#ffbb00;
}.data:active {
	position:relative;
	top:1px;
}

div1 {
        background-image: url( "lego-500x300.png" );
      }
      
p {
	padding: 10px 10px 10px 10px;
	margin: 0px 0px 0px 0px;
	height: 20px;
	font-size: 14px;
	font-family: "맑은 고딕";
	background-color: rgba( 25, 25, 25, 0.5 );
}


</style>
<script type="text/javascript">
function recipedetail(recipeNo) {
	document.recipeVo.recipeNo.value = recipeNo;
	document.recipeVo.action = 'detailform.do';
	document.recipeVo.submit();
}
</script>
</head>
<body>

<div style="overflow-y:scroll; width:100%; height:60px; position: relative; top:20px;">
	<a href="#" class="data" data-url="./recipeform1?table_number=${table_number}">돈까스</a>
	<a href="#" class="data" data-url="./recipeform2?table_number=${table_number}">파스타</a>
	<a href="#" class="data" data-url="./recipeform3?table_number=${table_number}">피자</a>
	<a href="#" class="data" data-url="./recipeform4?table_number=${table_number}">샐러드</a>
	<a href="#" class="data" data-url="./recipeform5?table_number=${table_number}">음료/주류</a>


</div>
<!-- jquery 를 사용하기 위해 jquery 파일을 로드 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script>
$(document).ready(function(e) {
/* a요소를 클릭 했을 시 */
    $('a').click(function(){
/* iframe 요소의 src 속성값을 a 요소의 data-url 속성값으로 변경 */ 
        $('.iframe').attr('src',$(this).attr('data-url'));
        })
});
</script>

<center>
<iframe class="iframe" width="98%" height="400px" src="./recipeform1?table_number=${table_number}" style="overflow-y:scroll; border: 0px"
></iframe> 

<div style="overflow-y:scroll; width:100%; height:10%;">
	<a href="./identifylist.do?table_number=${table_number}"class ="data">주문표가기</a>
	



</div>
</center>
</body>
</html>