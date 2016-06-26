<%@page import="enums.Country"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>editProducer</title>
<style type="text/css">
 @import "style.css"
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<jsp:include page="/producerHeader.jsp" />
<div class="main">
		<div align="left" style="margin-top: 40px;">
		<h4>Edit Producer:</h4>
		</div>
		<form action="EditProducer" method="POST">
		<input type="hidden" name="id" value="${producer.id}" />
		
		<div class="field">
				<label for="title">Title:</label> <input type="text"
					name="title" value="${producer.title}"/>
			</div>
			<div class="field">
				<label for="country">Country:</label> 
				<c:forEach items="<%=Country.values()%>" var="country">
					<INPUT TYPE="radio" NAME="country" ${country == producer.country ? 'checked' : ''}
					VALUE="${country}"> ${country}
         </c:forEach>
			</div>
		<%-- <h2>(last country was "${producer.country}")</h2> --%>	
			<p>
			<div class="field">
				<label for="t"></label> <input type="submit" name="submit" value="Edit" />
			</div>
		</form>
	</div>
</body>
</html>