<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>messageIsEqualsProd</title>
<style type="text/css">
 @import "style.css"
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<div class="mainBlock">
<jsp:include page="/producerHeader.jsp" />
<a href="#" onclick="history.back()" class="returnButton2"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return"></a>
<center>
<h4>Producer "${producerTitle}" (country ${country}) already exists.</h4>
</center>
</div>
</body>
</html>