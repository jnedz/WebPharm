<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration</title>
</head>
<body>
	<div class="registration">

 <%-- <c:set var="registration" scope="sessia" value="<%=application.getAttribute("registration")%>"/>  --%>
 <%-- <c:set var="registration" value="${application.getAttribute('registration')}"/>
 reg: ${registration}
 
<c:choose>
    <c:when test="${'yes' == registration}">
        <h2><%=application.getAttribute("roleReg")%></h2>
				<a href="Logout">Logout</a>
    </c:when>    
    <c:otherwise>
        		<a href="RegistrationNew">RegistrNew</a>
				<a href="Registration">Registration</a>
				<a href="Enter" >Enter</a>
          </c:otherwise>
</c:choose>
				

 --%>


		 <% if ("yes".equals(application.getAttribute("registration"))){%>
		<h2><%=application.getAttribute("roleReg")%></h2>
				<a href="Logout">Logout</a>
		<%}else{%>
				<a href="RegistrationNew">RegistrNew</a>
				<a href="Registration">Registration</a>
				<a href="Enter" >Enter</a>
		<%}%> 
		
	</div>
</body>
</html>
