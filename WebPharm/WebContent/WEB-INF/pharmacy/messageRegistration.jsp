<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>messageRegistration</title>
<style type="text/css">
@import
"style.css"
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.0.0.js" /></script>
<script src="${pageContext.request.contextPath}/js/app-ajax.js"
	type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<jsp:include page="/pharmacyHeader.jsp" />
	<input type="hidden" name="login" value="${login}">
	<input type="hidden" name="userIsExist" value="${userIsExist}">
<center><h4>
<c:choose>
    <c:when test="${userIsExist == 'true'}">
       User with your regestration data already exists!
    </c:when>    
    <c:otherwise>
      Thank you for registering! <br><br>Your login: ${login}, role: ${role}  
          </c:otherwise>
</c:choose>

<p><a href="AllPharmacies"><button>Return</button></a>  

</h4></center>


</body>
</html>