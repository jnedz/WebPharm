<%@page import="enums.PersonRole"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pharmacies</title>
<style type="text/css">
@import
"style.css"
</style>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="mainBlock">
	<jsp:include page="/pharmacyHeader.jsp" />

		<a href="#" onclick="history.back()" class="reloadButton"><img
			src="img/return.png" alt="Return" width="90" height="90"
			style="vertical-align: middle" title="return"></a> 
		<a href="AllPharmacies" class="addButton" ><img src="img/reload.png"
			alt="ReloadPharmacies" width="100" height="100"
			style="vertical-align: middle" title="reload pharmacies"></a> <br>
		<br> <br> 



		<c:forEach items="${pharmacies}" var="pharmacy">

			<p>
			<form action="PharmaciesServlet" method="post">
				<h4>
					<button class="signIn" title="SignIn"></button>${pharmacy.title},
					${pharmacy.description} 
					<input type="hidden" name=idPharm value="${pharmacy.id}"> 
						<input type="hidden" name=title value="${pharmacy.title}"> 
						<input type="hidden" name=gescription value="${pharmacy.description}">
				</h4>
			</form>

		</c:forEach>

		<a href="AllPharmacies" class="addButton2"><img
			src="img/reload.png" alt="ReloadPharmacies" width="100" height="100"
			style="vertical-align: middle" title="reload pharmacies"></a>
	</div>
</body>
</html>
