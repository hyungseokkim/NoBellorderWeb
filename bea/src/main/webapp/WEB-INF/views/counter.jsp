<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Counter</title>

</head>
<body>
<jsp:include page="managertop.jsp" flush="true"></jsp:include>
<!-- jquery 를 사용하기 위해 jquery 파일을 로드 -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script>
var timer=setTimeout(alertStr, 15000);
function identifycheck() {

}

function alertStr(){

	location.href="./counter?shop_number=${m_shopnumber}";
	
	}


$(document).ready(function(e) {
/* a요소를 클릭 했을 시 */
    $('a').click(function(){
/* iframe 요소의 src 속성값을 a 요소의 data-url 속성값으로 변경 */ 
        $('#iframe').attr('src',$(this).attr('data-url'));
        })
});
</script>

	<c:choose>
		<c:when test="${empty m_shopnumber}">
	로그인해라
		</c:when>
		<c:otherwise>
		
	<table>
<tr>
<td valign="top" style="width:50%; height:780px">
<iframe name="iframe" src="./counterorderlist?table_number=1" style="width:100%; height:70%;  border: 0px"></iframe>
</td>
<td valign="top" style="width:50%; height:70%">
<a href="./counterorderlist?table_number=1" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=1" style="width:20%;  border: 0px"></iframe></a>
<a href="./counterorderlist?table_number=2" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=2" style="width:20%;  border: 0px"></iframe></a>
<a href="./counterorderlist?table_number=3" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=3" style="width:20%;  border: 0px"></iframe></a>
<a href="./counterorderlist?table_number=4" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=4" style="width:20%;  border: 0px"></iframe></a> <br>
<a href="./counterorderlist?table_number=5" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=5" style="width:20%;  border: 0px"></iframe></a> 
<a href="./counterorderlist?table_number=6" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=6" style="width:20%;  border: 0px"></iframe></a> 
<a href="./counterorderlist?table_number=7" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=7" style="width:20%;  border: 0px"></iframe></a> 
<a href="./counterorderlist?table_number=8" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=8" style="width:20%;  border: 0px"></iframe></a> <br>
<a href="./counterorderlist?table_number=9" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=9" style="width:20%;  border: 0px"></iframe></a> 
<a href="./counterorderlist?table_number=10" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=10" style="width:20%;  border: 0px"></iframe></a> 
<a href="./counterorderlist?table_number=10" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=11" style="width:20%;  border: 0px"></iframe></a> 
<a href="./counterorderlist?table_number=10" class="data" target="iframe"><iframe class="iframess"   src="./countertables?table_number=12" style="width:20%;  border: 0px"></iframe></a> 

</td>
</tr>

</table>

</c:otherwise>
	</c:choose>



</body>
</html>