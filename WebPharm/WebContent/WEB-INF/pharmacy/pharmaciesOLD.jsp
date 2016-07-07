<%@page import="enums.PersonRole"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pharmacies</title>
<style type="text/css">
@import
"style.css"
</style>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<jsp:include page="/pharmacyHeader.jsp" />
<div class="mainBlock">

<a href="#" onclick="history.back()" class="reloadButton"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return"></a>
<a href="AllPharmacies" class="addButton"><img src="img/reload.png" alt="ReloadPharmacies" width="100" height="100"
								style="vertical-align: middle" title="reload pharmacies"></a>
<%--	<a href="AddOrEditPharmacy?id=<c:out value="0"/>" class="addButton"><img src="img/add.png" alt="addPharmacy" width="100" height="100"
								style="vertical-align: middle" title="add pharmacy"></a> --%>
	
	<br><br><br><br><br><br><br><br>

<br>

	<table class="table" border=1>
	
		<thead>
			<tr>
				<th class="th" bgcolor="silver"><H1>Id</h1></th>
				<th class="th" bgcolor="silver"><H1>Title</H1></th>
				<th class="th" bgcolor="silver"><H1>Description</H1></th>
				<th class="th" colspan=2 bgcolor="silver"><H1>Action</H1></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pharmacies}" var="pharmacy">
				<tr>
					<td class="td" bgcolor="silver" style="text-align: center;"><h2>
							<c:out value="${pharmacy.id}" />
						</h2></td>
					<td class="td" style="text-align: center;">
						<!--href="PharmaciesServlet?idPharm=<c:out value='${pharmacy.id}'/>"  -->
						<%-- title="${pharmacy.title}: ${pharmacy.description}">${pharmacy.title}</a></td> --%>
					
					
					<form action="PharmaciesServlet">
						<%-- <a	href="PharmaciesServlet">${pharmacy.title}</a> --%>
						<button>${pharmacy.title}</button>
	<input type="hidden" name=idPharm value="${pharmacy.id}">
	<input type="hidden" name=title value="${pharmacy.title}">	
	<input type="hidden" name=gescription value="${pharmacy.description}">
	</form>
	
					<td class="td" style="text-align: center;"><c:out
							value="${pharmacy.description}" /></td>
					<td class="td" style="text-align: center;"><h3>
							<a
								href="UserController?action=edit&userId=<c:out value="${user.uname}"/>"><img
								src="img/update.png" alt="Edit" width="20" height="20"
								style="vertical-align: middle" title="Edit"></a>
						</h3></td>
					<td class="td" style="text-align: center;"><h3>
							<a
								href="UserController?action=delete&userId=<c:out value="${user.uname}"/>"><img
								src="img/delete.png" alt="Delete" width="20" height="20"
								style="vertical-align: middle" title="Delete"></a>
						</h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>
