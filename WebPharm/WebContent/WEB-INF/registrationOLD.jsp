<%@page import="enums.PersonRole"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/registration.js" /></script>
</head>
<body>
		
<div class="registration">
<a href="#" onclick="show_form(); return false"><span id="sp_sel">Registration</span></a> 
<div id="div_form" style="display:none" > 
<form action="LoginPasswordPharmacy">

		<p>
			Login: <input type="text" maxlength="25" size="30" name="login">
		</p>
		<p>
			Password: <input type="password" maxlength="25" size="30"
				name="password">
		</p>
		<c:forEach items="<%=PersonRole.values()%>" var="role">
			<INPUT TYPE="radio" NAME="role" VALUE="${role}" checked="USER" > ${role}
	       </c:forEach>
		<input type="submit" value="Enter">
	</form> 
</div>
</div>
<br>
<div class="registration">

<a href="#" onclick="show_form2(); return false"><span id="sp_sel2">Enter</span></a> 
<div id="div_form2" style="display:none" > 
<form action="LoginPasswordPharmacy">
<input type="hidden" name="enter" value="yes">
		<p>
			Login: <input type="text" maxlength="25" size="30" name="login">
		</p>
		<p>
			Password: <input type="password" maxlength="25" size="30"
				name="password">
		</p>
		<c:forEach items="<%=PersonRole.values()%>" var="role">
			<INPUT TYPE="radio" NAME="role" VALUE="${role}" checked="USER"> ${role}
	       </c:forEach>
		<input type="submit" value="Enter">
	</form> 
</div>
</div>

</body>
</html>
