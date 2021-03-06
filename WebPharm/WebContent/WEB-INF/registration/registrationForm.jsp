<%@page import="enums.PersonRole"%>
<%@page import="utils.Constants"%>
<%@page import="utils.TitlesDTO"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registrationForm</title>
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
	<jsp:include page="/registrationHeader.jsp" />
		<form name="myForm" action="Registration" method="post"
			onsubmit="return validateForm()">
			<table class="table1" border="0">
				<caption>
					Enter Registration data:<br>
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
					<td class="td1"><input id="frpassword" type="password"
						name="password" placeholder="length<=25" value="${password}" tabindex="2"/></td>
				</tr>

				<tr>
					<td class="td1"><div class="field">
							<label for="firstName">First name:</label>
						</div></td>
					<td class="td1"><input id="frname" type="text"
						name="firstName" placeholder="length<=20" value="${firstName}"
						tabindex="3" /></td>
				</tr>
				<tr>
					<td class="td1"><div class="field">
							<label for="lastName">Last name:</label>
						</div></td>
					<td class="td1"><input id="frname" type="text" name="lastName"
						placeholder="length<=20" value="${lastName}" tabindex="4" /></td>
				</tr>
				<tr>
					<td class="td1"><div class="field">
							<label for="dateOfBirthday">Date of BirthDay:</label>
						</div></td>
					<td class="td1"><input type="text" name="dateOfBirthday"
						value="${dateOfBirthday}"
						placeholder='format "<%= Constants.format %>"' tabindex="5" /></td>
				</tr>
				<tr>
					<td class="td1"><div class="field">
							<label for="role">Role:</label>
						</div></td>
					<td class="td1"><c:forEach items="<%=PersonRole.values()%>"
							var="role">
							<INPUT TYPE="radio" NAME="role"
							 ${role == 'USER' ? 'checked' : ''}
								VALUE="${role}"> ${role}
	       </c:forEach></td>
					<td class="td1"></td>
				</tr>
				
				<tr>
					<td class="td1"><div class="field">
							<label for="pharmacy">Pharmacy:</label>
						</div></td>
					<td class="td1">
					<select size="1" name="pharmacyTitle">
				<c:forEach items="<%=utils.TitlesDTO.pharmaciesTitles()%>"
									var="pharmacyTitle">
									<option value="${pharmacyTitle}">${pharmacyTitle}</option>
								</c:forEach>
									</select>
					</td>
				</tr>
				
			</table>

			<p>
				<input type="submit" value="Registration" />
		</form>

		<a href="AllPharmacies" class="returnButton"><img
			src="img/return.png" alt="allPharmacies" width="90" height="90"
			style="vertical-align: middle" title="all pharmacies"></a>


	</div>
</body>
</html>