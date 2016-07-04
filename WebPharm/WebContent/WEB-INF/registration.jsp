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
				<input type="hidden" name="roleReg" value="${roleReg}"> 


		<c:choose>
			<c:when
				test="${'yes' == application.getAttribute('registration')}">
				<form>
					<br> <a href="">Logout</a>
					<%
						application.setAttribute("registration", "no");
					%>
				</form>

			</c:when>
			<c:otherwise>
			
			<a href="Registration" method="get">Registration</a>
				<br>
				<a href="Enter" method="get">Enter</a>




			</c:otherwise>
		</c:choose>


	</div>

</body>
</html>
