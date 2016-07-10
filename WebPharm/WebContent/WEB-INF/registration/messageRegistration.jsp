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
<script src="${pageContext.request.contextPath}/js/app-ajax.js"
	type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="mainBlock">
	<jsp:include page="/registrationHeader.jsp" />
	<input type="hidden" name="login" value="${login}">
	<input type="hidden" name="userIsExist" value="${userIsExist}">
<center><h4>
<c:choose>
    <c:when test="${userIsExist == 'true'}">
       User with your registration data already exists!
       <a href="#" onclick="history.back()" class="returnButton2"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return"></a>
    </c:when>    
    <c:otherwise>
      Thank you for registration! <br><br>Your login: ${login}, role: ${role} 
      <br>Enter in program for continue, please. <br><br>
      <a href="Enter"><img src="img/enter.png" alt="Enter" width="90" height="90"
								style="vertical-align: middle" title="enter"></a>
          </c:otherwise>
</c:choose>

<%-- <p><a href="AllPharmacies"><button>Return</button></a>  --%>

</h4></center>

</div>
</body>
</html>