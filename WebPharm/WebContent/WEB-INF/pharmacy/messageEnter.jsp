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
</head>
<body>
	<jsp:include page="/header.jsp" />
	<jsp:include page="/pharmacyHeader.jsp" />
	<div class="mainBlock">
	<input type="hidden" name="login" value="${login}">
	<input type="hidden" name="userIsExist" value="${userIsExist}">

<c:choose>
    <c:when test="${userIsExist == 'true'}">
    <a href="AllPharmacies" class="returnButton2"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return"></a>
      <center><h4> User with your registration data successfully founded!<br>Your login: ${login}, role: ${role}</h4></center>
    </c:when>    
    <c:otherwise>
    <a href="#" onclick="history.back()" class="returnButton2"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return"></a>
     <center><h4> User with your registration data was not found. <br>Please try again. </h4> </center>
          </c:otherwise>
</c:choose>

<%--<p><a href="AllPharmacies"><button>Return</button></a>  --%> 

</div>
</body>
</html>