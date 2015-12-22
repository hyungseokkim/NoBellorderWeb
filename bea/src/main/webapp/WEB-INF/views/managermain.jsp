<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>매니저모드</title>
</head>
<jsp:include page="managertop.jsp" flush="true" ></jsp:include>
<body>
<br><br>
${m_shopnumber}매니저모드에 접근하셨습니다.

<a href="counter.do?shop_number=${m_shopnumber}">카운터화면</a>
<a href="kitchen.do?shop_number=${m_shopnumber}">주방화면</a>
<a href="noticelist.do?shop_number=${m_shopnumber}">공지사항</a>
</body>

</html>