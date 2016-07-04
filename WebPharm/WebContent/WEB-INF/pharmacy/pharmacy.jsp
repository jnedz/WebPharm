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
<title>Pharmacy</title>
<style type="text/css">
@import
"style.css"
</style>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<jsp:include page="/pharmacyHeader.jsp" />
	<div class="mainBlock">
					<input type=hidden name="idPharm" value="${idPharm}">
		<h4>
			<br> <input type="hidden" name="roleReg" value="${roleReg}">
			<c:choose>
				<c:when test="${WORKER == roleReg}">
				<a
						href="AddMedicineFromPharmacy?idPharm=<c:out value="${idPharm}"/>"
						class="addButton"><img src="img/add.png" alt="addMedicine"
						width="100" height="100" style="vertical-align: middle"
						title="add medicine"></a>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<a href="AllPharmacies" class="returnButton2"><img
				src="img/return.png" alt="Return" width="90" height="90"
				style="vertical-align: middle" title="return to all pharmacies"></a>
			<br>
			<br>
			<br>
			<br> Pharmacy: ${pharmacy.title}<br> Description:
			${pharmacy.description}
		</h4>

		<c:choose>
			<c:when test="${WORKER == roleReg}">
			
				<table class="table" border=1>
					<thead>
						<tr>
							<th class="th" bgcolor="silver"><h1>Type</h1></th>
							<th class="th" bgcolor="silver"><h1>Title</h1></th>
							<th class="th" bgcolor="silver"><h1>Date Of Manufacture</h1></th>
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
										value="${medicine.dateOfManufact.time}" /></td>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.term} mnth" /></td>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.price} UA" /></td>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.count}" /></td>

								<td class="td" style="text-align: center;"><h3>
										<a
											href="DeliveryMedicinesMessage?idMed=<c:out value="${medicine.id}"/>&way=toPharmacy&idPharm=<c:out value="${idPharm}"/>"><img
											src="img/plus.png" alt="toPharm" width="20" height="20"
											style="vertical-align: middle"
											title="delivery medicines TO pharmacy"></a>
									</h3></td>

								<td class="td" style="text-align: center;"><h3>
										<a
											href="DeliveryMedicinesMessage?idMed=<c:out value="${medicine.id}"/>&way=fromPharmacy&idPharm=<c:out value="${pharmacy.id}"/>"><img
											src="img/minus.png" alt="fromPharm" width="20" height="20"
											style="vertical-align: middle"
											title="delivery medicines FROM pharmacy"></a>
									</h3></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br><br><br><br>

			</c:when>
			<c:otherwise>
<table class="table" border=1>
					<thead>
						<tr>
							<th class="th" bgcolor="silver"><h1>Type</h1></th>
							<th class="th" bgcolor="silver"><h1>Title</h1></th>
							<th class="th" bgcolor="silver"><h1>Date Of Manufacture</h1></th>
							<th class="th" bgcolor="silver"><h1>Term</h1></th>
							<th class="th" bgcolor="silver"><h1>Price</h1></th>
							<th class="th" bgcolor="silver"><h1>Count</h1></th>
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
										value="${medicine.dateOfManufact.time}" /></td>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.term} mnth" /></td>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.price} UA" /></td>
								<td class="td" style="text-align: center;"><c:out
										value="${medicine.count}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
<br><br><br><br>

			</c:otherwise>
		</c:choose>


	</div>
</body>
</html>