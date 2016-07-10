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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addMedicineFromPharmacy</title>
<style type="text/css">
 @import "style.css"
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/inputValidator.js" /></script>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="mainBlock">
<jsp:include page="/pharmacyHeader.jsp" />

<a href="#" onclick="history.back()" class="reloadButton"><img
			src="img/return.png" alt="Return" width="90" height="90"
			style="vertical-align: middle" title="return"></a>
			
<form action="AddMedicineFromPharmacy" method="post">
	<button class="addButton20"><img src="img/reload.png" alt="reload"
						width="100" height="100" style="vertical-align: middle"
						title="reload medicine"></button> 
		<input type="hidden" name="idPharm" value="${idPharm}" /> 						
								</form>
								
			<br>
	
	<h4><p>Pharmacy: ${pharmacy.title}<br></h4>
	<table  class="table">
	
		<thead>
			<tr>

				<th class="th" bgcolor="silver"><h1>Type</h1></th>
				<th class="th" bgcolor="silver"><h1>Title</h1></th>
				<th class="th" bgcolor="silver"><h1>Count</h1></th>
				<th class="th" colspan=1 bgcolor="silver"><h1>Enter count for order</h1></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${medicines}" var="medicine">
				<tr>
					<td class="td" style="text-align: center;"><c:out
							value="${medicine.type}" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${medicine.title}" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${medicine.count}" /></td>

					<td class="td" style="text-align: center;">
<form name="1"  action="DeliveryNewMedicine" method="post" onsubmit="return validateForm()"><h3>
<input type="hidden" name="idPharm" value="${idPharm}" />
<input type="text" name="idMed" value="${medicine.id}" /> 
<input type="hidden" name="way" value="toPharmacy" /> 

<input type="hidden" name="count" value="${medicine.count}" />

<input type="text" name="quantity" value="${quantity}"/>
<input type="submit" class="addMed" value="Add Medicine">
</h3></form>

						</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="AddMedicineFromPharmacy" method="post">
	<button class="addButton21"><img src="img/reload.png" alt="reload"
						width="100" height="100" style="vertical-align: middle"
						title="reload medicine"></button> 
		<input type="hidden" name="idPharm" value="${idPharm}" /> 						
								</form>
	</div>
</body>
</html>
