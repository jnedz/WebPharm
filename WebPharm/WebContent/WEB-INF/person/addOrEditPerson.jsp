<%@page import="enums.PersonRole"%>
<%@page import="utils.Constants"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addOrEditPerson</title>
<style type="text/css">
@import
"style.css"
</style>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<jsp:include page="/personHeader.jsp" />
	<div class="mainBlock">
	<br>
	<form action="PersonsServlet" method="POST">
	<button class="addButton3"><img src="img/add.png" alt="addPerson" width="100" height="100"
								style="vertical-align: middle" title=${id>0 ? "edit person" : "add person"}></button>
	
		<input type="hidden" name="id" value="${id}" /> <input type="hidden"
			name="selectedRole" value="${selectedRole}" />
		<table class="table1" border="0">
			<caption>
				Enter Person`s data:<br>
			</caption>
			<tr>
				<th class="th1"></th>
				<th class="th1"></th>
				<th class="th1"></th>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="firstName">First name:</label>
					</div></td>
				<td class="td1"><input type="text" name="firstName"
					placeholder="length>=20" value="${firstName}" tabindex="1" /></td>
				<td class="td1"><input class="hid"
					type=${firstNameErr == "" ? "hidden" : "text"} name="hid"
					value="${firstNameErr}" readonly tabindex="-1" /></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="lastName">Last name:</label>
					</div></td>
				<td class="td1"><input type="text" name="lastName"
					placeholder="length>=20" value="${lastName}" tabindex="2" /></td>
				<td class="td1"><input class="hid"
					type=${lastNameErr == "" ? "hidden" : "text"} name="hid"
					value="${lastNameErr}" readonly tabindex="-1" /></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="date">Date of BirthDay:</label>
					</div></td>
				<td class="td1"><input type="text" name="dateOfBirthday"
					value="${dateOfBirthday}"
					placeholder='format "<%= Constants.format %>"' tabindex="3" /></td>
				<td class="td1"><input class="hid"
					type=${dateErr == "" ? "hidden" : "text"} name="hid"
					value="${dateErr}" readonly tabindex="-1" /></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="role">Role:</label>
					</div></td>
				<td class="td1"><c:forEach items="<%=PersonRole.values()%>"
						var="role">
						<INPUT TYPE="radio" NAME="role"
							<c:choose>
    <c:when test="${id>0 }">
        ${role == selectedRole ? 'checked' : ''}
    </c:when>    
    <c:otherwise>
        ${role == 'USER' ? 'checked' : ''}
          </c:otherwise>
</c:choose>
							VALUE="${role}"> ${role}
	       </c:forEach></td>
				<td class="td1"></td>
			</tr>
		</table>
<%--		<input type="submit" value=${id>0 ? 'Edit' : 'Add'} />
		<p>
			<input value="Return" type="button" onclick="history.back()"> --%>
	</form>
	
	<a href="AllPersons" class="returnButton"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return to all persons"></a>
</div>
</body>
</html>