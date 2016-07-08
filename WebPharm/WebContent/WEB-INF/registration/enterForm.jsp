<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>enterForm</title>
<style type="text/css">
@import
"style.css"
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/registrationValidator.js" /></script>
</head>
<body>
<jsp:include page="/header.jsp" />
	<div class="mainBlock">
	<form name="myForm" action="Enter" method="post" onsubmit="return validateForm()">
<%--	<button name="Submit" class="addButton3"><img src="img/add.png" alt="registration" width="100" height="100"
								style="vertical-align: middle" title="registration"></button>
	
	<%--	<input type="hidden" name="id" value="${id}" /> <input type="hidden"
			name="selectedRole" value="${selectedRole}" />
		 --%>	
			
		<table class="table1" border="0">
			<caption>
				Enter login and password:<br>
			</caption>
			<tr>
				<th class="th1"></th>
				<th class="th1"></th>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="login">Login:</label>
					</div></td>
				<td class="td1"><input type="text" name="login" id="frlogin"
					value="${login}" placeholder="length<=20" tabindex="1" /></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="password">Password:</label>
					</div></td>
				<td class="td1"><input id="frpassword" type="password" name="password"
					placeholder="length<=20" value="${password}" /></td>
			</tr>
		
		</table>
<%--		<input type="submit" value=${id>0 ? 'Edit' : 'Add'} />
		<p>
			<input value="Return" type="button" onclick="history.back()"> --%>
			
			<p><input type="submit" value="Enter" />  
	</form>
	
	<a href="AllPharmacies" class="returnButton"><img src="img/return.png" alt="allPharmacies" width="90" height="90"
								style="vertical-align: middle" title="all pharmacies"></a>
	
	
</div>
</body>
</html>