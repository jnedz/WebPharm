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
<%-- <c:set var="yes" scope=<%=application.getAttribute("registration")%>> --%>
 <%-- <c:set var="yes" scope="registration" > 
 
				<form>
					<br> <a href="">Logout</a>
					<%
						application.setAttribute("registration", "no");
					%>
				</form>

</c:set> 
<c:set var="no" scope="registration" > 

				<a href="Registration">Registration</a>
				<br>
				<a href="Enter" >Enter</a>

</c:set>
<c:set var="" scope="registration"> 

				<a href="Registration">Registration</a>
				<br>
				<a href="Enter" >Enter</a>

 </c:set> --%>


			
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
