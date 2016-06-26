<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>producer</title>
<style type="text/css">
 @import "style.css"
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<jsp:include page="/producerHeader.jsp" />
	<center>
		<input type="hidden" name="id" value="${producer.id}" />
		<h4>Producer title: ${producer.title},
			counry: ${producer.country}</h4>

		<form action='EditProducer' method="get">
			<input type="hidden" name="id" value="${producer.id}" /> <input
				type="submit" value="Edit Producer" />
		</form><br>
		<input value="Return" type="button" onclick="history.back()">
		</center>
</body>
</html>