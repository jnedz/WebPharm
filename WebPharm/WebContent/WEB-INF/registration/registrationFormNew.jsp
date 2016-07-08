<%@page import="enums.PersonRole"%>
<%@page import="utils.Constants"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registrationFormNew</title>
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
	
	<table class="table">

		<thead>
			<tr>
				<th class="th" bgcolor="silver"><H1>
						First Name
					</H1></th>
				<th class="th" bgcolor="silver"><H1>Last Name
				</H1></th>
				<th class="th" bgcolor="silver"><H1>Date of Birthday 
				<th class="th" colspan=1 bgcolor="silver"><H1>Registration</H1></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${persons}" var="person">
				<tr>
					<td class="td" style="text-align: center;"><c:out
							value="${person.firstName}" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${person.lastName}" /></td>
					<td class="td" style="text-align: center;"><fmt:formatDate
							pattern="<%= Constants.format %>" value="${person.dateOfBirthday.time}" /></td>
					<td class="td" style="text-align: center;">
					<p>
					<form action="RegistrationNewStep2" method="post">
							<!-- <a href="Registration"> -->
							<button class="sendsubmitS1">
									<img src="img/registr.jpg" alt="registration" width="90" height="30"
										style="vertical-align: middle" title="registration here">
								</button>
								<input type="hidden" name="id" value="${person.id}"/>	 
						<%-- <input type="hidden" name="firstName" value="${person.firstName}"/>	 	
						<input type="hidden" name="lastName" value="${person.lastName}"/>	 	
						<input type="hidden" name="dateOfBirthday" value="${person.dateOfBirthday}"/>	 	
						<input type="hidden" name="role" value="${person.role}"/>	 	 --%>
					</form>			
					<br>			
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<a href="AllPharmacies" class="returnButton"><img
			src="img/return.png" alt="allPharmacies" width="90" height="90"
			style="vertical-align: middle" title="all pharmacies"></a>


	</div>
</body>
</html>