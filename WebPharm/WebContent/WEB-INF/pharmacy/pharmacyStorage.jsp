<%@page import="enums.MedicineType"%>
<%@page import="utils.Constants"%>
<%@page import="utils.TitlesDTO"%>
<%@page import="model.MedicineDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>pharmacyStorage</title>
<style type="text/css">
@import
"style.css"
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.0.0.js" /></script>
<script src="${pageContext.request.contextPath}/js/app-ajax.js"
	type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="mainBlock">
	<jsp:include page="/pharmacyHeader.jsp" />
	
	<c:set var="idPharmApplication"
			value="<%=application.getAttribute(\"idPharm\")%>" />
			
			<h4>
			<a href="AllPharmacies" class="returnButton2"><img
				src="img/return.png" alt="Return" width="90" height="90"
				style="vertical-align: middle" title="return to all pharmacies"></a>
			<br><br>
			<br> Pharmacy: ${pharmacy.title}<br> Description:
			${pharmacy.description}
		</h4>

		
			<form action="AddMedicineFromPharmacy" method="post">
	<button class="addButton20"><img src="img/add.png" alt="addMedicine"
						width="100" height="100" style="vertical-align: middle"
						title="add medicine"></button> 
		<input type="hidden" name="idPharm" value="${idPharm}" /> 						
								</form>
				<table class="table" border=1>
					<thead>
						<tr>
							<th class="th" bgcolor="silver"><h1>Type</h1></th>
							<th class="th" bgcolor="silver"><h1>Title</h1></th>
							<th class="th" bgcolor="silver"><h1>Date of Manufacture 
							
						<c:choose>
    <c:when test="${order == null || order == 'NoSort'}">
    <form action="SortByDate" method="post">
        <input type="hidden" name="idPharm" value="${idPharm}"> 
         <input type="hidden" name="order" value="ASC"> 
        <button class="buttonOrder" name="order" id="form1">
			<img src="img/noSort.png"
						width="25" height="25" alt="NoSort"
						style="vertical-align: middle"/> 
							</button></form>
    </c:when>    
    <c:otherwise>
       <form action="SortByDate" method="post">
        <input type="hidden" name="idPharm" value="${idPharm}"> 
        <input type="hidden" name="order" value="${order}"> 
        <button class="buttonOrder" name="order" id="form1">
			<img src="${order == 'ASC' ?'img/za.png' : 'img/az.png'}"
						width="25" height="25" alt="Sort"
						style="vertical-align: middle"/> 
							</button></form>
          </c:otherwise>
</c:choose>
				
						</h1></th>
							<th class="th" bgcolor="silver"><h1>Term</h1></th>
							<th class="th" bgcolor="silver"><h1>Price</h1></th>
							<th class="th" bgcolor="silver"><h1>Count</h1></th>
							<th class="th" colspan=2 bgcolor="silver"><h1>Delivery</h1></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${medicines}" var="medicine">
							<tr>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.type}" /></td>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.title}" /></td>
								<td class="td" style="text-align: center;"><fmt:formatDate
										pattern="<%= Constants.format %>"
										value="${medicine.dateOfManufact.time}" /> </td>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.term} mnth" /></td>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.price} UA" /></td>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.count}" /></td>

								<td class="td" style="text-align: center;">
								<form action="DeliveryMedicinesMessage" method="post"><h3>
										<button class="unvisible"><img
											src="img/plus.png" alt="toPharm" width="20" height="20"
											style="vertical-align: middle"
											title="delivery medicines TO pharmacy"></button>
						<input type="hidden" name=idPharm value="${pharmacy.id}"> 
						<input type="hidden" name=idMed value="${medicine.id}"> 
						<input type="hidden" name=way value="toPharmacy"> 
									</h3></form></td>

								<td class="td" style="text-align: center;">
								<form action="DeliveryMedicinesMessage" method="post"><h3>
										<button class="unvisible"><img
											src="img/minus.png" alt="fromPharm" width="20" height="20"
											style="vertical-align: middle"
											title="delivery medicines FROM pharmacy"></button>
						<input type="hidden" name=idPharm value="${pharmacy.id}"> 
						<input type="hidden" name=idMed value="${medicine.id}"> 
						<input type="hidden" name=way value="fromPharmacy"> 
									</h3></form></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<%-- <form action="SortByDate" method="post">
			<input type="hidden" name=idPharm value="${pharmacy.id}"> 
	<button class="SortByDate" method="post"><img src="img/date.png" alt="Sort Medicines by Date" width="90" height="90"
								style="vertical-align: middle" title="Sort Medicines by Date"></button> </form>
						 --%>
		<form action="WorkWithStorage" method="post">	
		<input type="hidden" name=idPharm value="${pharmacy.id}"> 
						<input type="hidden" name=title value="${pharmacy.title}"> 
						<input type="hidden" name=gescription value="${pharmacy.description}">			 
	<button class="bottonLeft"><img src="img/reload.png"
			alt="ReloadPharmacy" width="100" height="100"
			style="vertical-align: middle" title="reload pharmacy"></button>
			</form>
			
			
				<form action="AddMedicineFromPharmacy" method="post">
	<button class="addButton21"><img src="img/add.png" alt="addMedicine"
						width="100" height="100" style="vertical-align: middle"
						title="add medicine"></button> 
		<input type="hidden" name="idPharm" value="${idPharm}" /> 						
								</form>
				<br><br>

	</div>
</body>
</html>