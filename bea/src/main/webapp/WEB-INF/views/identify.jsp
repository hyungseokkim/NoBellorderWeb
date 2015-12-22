<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html ng-app>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<title>IDENTIFY</title>
<style type='text/css'>

	a:link		{color:black;text-decoration:none;}
	a:visited	{color:black;text-decoration:none;}
	a:hover		{color:black;text-decoration:none;}
.data {
	-moz-box-shadow:inset 0px 1px 0px 0px #FFBB00;
	-webkit-box-shadow:inset 0px 1px 0px 0px #FFBB00;
	box-shadow:inset 0px 1px 0px 0px #FFBB00;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #FFBB00), color-stop(1, #FFBB00) );
	background:-moz-linear-gradient( center top, #FFBB00 5%, #FFBB00 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#FFBB00', endColorstr='#FFBB00');
	background-color:#FFBB00;
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
	color:#FFBB00;
	font-family:Arial;
	font-size:12px;
	font-weight:bold;
	font-style:normal;
	height:20px;
	line-height:20px;
	width:30px;
	text-color:black;
	text-decoration:none;
	text-align:center;;
}
.data:hover {
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #F29661), color-stop(1, #F29661) );
	background:-moz-linear-gradient( center top, #F29661 5%, #F29661 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#F29661', endColorstr='#F29661');
	background-color:#F29661;
}.data:active {
	position:relative;
	top:1px;
}

p {

	margin: 0px 0px 0px 0px;
	height: 50px;
	align:left;
	font-size: 14px;
	font-family: "맑은 고딕";
}

o {
	padding: 0px 10px 10px 0px;
	margin: 1px 1px 1px 1px;
	align: center;
	height: 20px;
	font-size: 14px;
	font-family: "맑은 고딕";
}

#padding-box { 
	width: 47%; 
	height:1px;
	border:0px solid; 
	float: left;

}

table{
	width: 100%;
	border-style: inherit;
	vertical-align: top;
}

th{	height: 35px;
	background-color: #4C4C4C;
	padding: 2px 2px 2px 2px;
	color:white;
	border-top:1px solid #e9e9e9;
	border-bottom:1px solid #e9e9e9;
	}
td{	height: 35px;
	color:black;
	background-color: #F6F6F6;
	text-align:center;
	}
</style>
 <script>
 var timer = setTimeout(alertStr, 500);

 function alertStr() {
 	if (document.identify.noup.value.length > 1) {
 		alert("이미 조리중 입니다.");
 		return true;
 	}

 }
 function CartController($scope) {
     $scope.selects = ${identifyhlist};
     $scope.totalbill = function(){
    	 var total = 0;
    	 for(var i=0, len=$scope.selects.length; i<len; i++){
    		 total = total + $scope.selects[i].check_discount;
    	 }
    	 return total;
     }
     $scope.remove = function(index) {
         $scope.selects.splice(index, 1);
     }
     
     $scope.$watch($scope.totalbill);
 }


	function check() {
		
		document.identify.order_etc.value = document.identify.order_etc.value;
		document.identify.order_grossvalue.value = document.identify.order_grossvalue.value;
 		document.identify.check_price.value = document.identify.check_price.value; 
		document.identify.check_discount.value = document.identify.check_discount.value;
		
		if(document.identify.order_state.value.length <1){
			alert("그지같아");	
			document.identify.order_state.value = 1;
		}else{
		document.identify.order_state.value = document.identify.order_state.value;
			alert("되거라");	
		}
		document.identify.action = 'orderinsert';
		document.identify.submit();
	}

	function identifydelete(check_number) {
/* 		document.identify.table.value = document.identify.table.value; */
		alert( "delete");
		document.identify.action = 'identifydelete';
		document.identify.submit();
	}
	
	 function identifyupdate(check_number) {
		 	/* 	document.identify.table.value = document.identify.table.value;  */
				alert( "update");
				document.identify.action = 'identifyupdate';
				document.identify.submit();
			} 
</script>
</head>

<body ng-controller="CartController">

    
<br><br>

	<form action="identify" name="identify" id="identify" method="post" onSubmit="return check()" enctype="form-data">	
	<input type="text" id="table_number" name="table_number" value="${identify[0].table_number}">
						<center>
			<div id="left-box" style="margin: 1px 1px 1px 1px;">
				<center>
					<input type="hidden" id="order" name="order" />
					<table width="95%" height="240" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th></th>
							<th>메뉴이름</th>
							<th>단가</th>
							<th>수량</th>
							<th>가격</th>
							<th></th>
						</tr>
				<div >
								<tr ng-repeat="result in selects">
								<td><input type="hidden" id="check_number" name="check_number" value="{{result.check_number}}" /></td>
								<td><input type="hidden" id="menu_number" name="menu_number" value="{{result.menu_number}}" /> {{result.menu_name}}</td>
								<td><input type="hidden" id="check_price" name="check_price" value="{{result.check_price}}" />{{result.check_price}}원</td>
								<td><input type="number" id="check_amount" name="check_amount" ng-model="result.check_amount" value="{{result.check_amount}}" size="1"/>
								<a href="identifyupdate?check_number={{result.check_number}}&table_number={{result.table_number}}&check_amount={{result.check_amount}}" class="data">수정</a></td>
							
								
								<td><input type="text" id="check_discount" name="check_discount" ng-model="result.check_discount" value="{{result.check_discount=result.check_price * result.check_amount}}"size="3"/></td>
							<td><a href="identifydelete?check_number={{result.check_number}}&table_number={{result.table_number}}" class="data">X</a></td>
							</tr>


						
						</div>

					</table>
					<div>
					------------------------------------<br>
					주문 비고사항 : <input type="text" id="order_etc" name="order_etc" path ="order_etc" /> <br>
---------------------------------------------<br>
						총가격 : {{totalbill()}} 원
						
						<input type="text" id="order_grossvalue" name ="order_grossvalue" value="{{totalbill()}}">
						</div>
				</center>

			</div>
		</center>
<input type="hidden" id="order_state" name ="order_state" value="${order[0].order_state}">
	<input type="hidden" id="noup" name ="noup" value="${noup}">
		
								<div style="text-align: center;  width:100%; height:10%">
		<%-- <a href="orderinsert?table_number=${identify[0].table_number}&order_grossvalue={{totalbill()}}">최종주문</a>
		 --%>		 
				<input type="submit" name = "submit" value="최종주문" class="writeBt"/>	 
				 </div>`
		

		
	</form>

</body>
</html>