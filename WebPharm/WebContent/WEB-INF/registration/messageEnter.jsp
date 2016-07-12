<%@page import="service.PharmacyService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>messageEnter</title>
<style type="text/css">
@import
"style.css"
</style>
<script src="${pageContext.request.contextPath}/js/app-ajax.js"
	type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="mainBlock">
	<jsp:include page="/registrationHeader.jsp" />
	
				<center>
  <h4>   Your registrations data was not found.<br>Try again, please.<br>
						<a href="#" onclick="history.back()" class="returnButton2"><img
							src="img/return.png" alt="Return" width="90" height="90"
							style="vertical-align: middle" title="return"></a>
			</h4>
		</center>
				
	</div>
</body>
</html>