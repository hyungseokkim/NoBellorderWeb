<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="/bea/menu">Menu</a>
<a href="/bea/recipeHome?table_number=1&shop_number=1&member_phone=01033311111">Tab</a>
<a href="/bea/event">Event</a>
<a href="/bea/noticewriteform?shop_number=1">noticewriteform</a>
<a href="/bea/noticelist?shop_number=1">noticelist</a>
<a href="/bea/shopmain?shop_number=1">shopmain</a>
<a href="/bea/counter.do?shop_number=1">counter</a>
</body>
</html>
