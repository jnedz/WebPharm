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
</head>
<body>
<jsp:include page="/header.jsp"/>
<jsp:include page="/pharmacyHeader.jsp" />
<div class="mainBlock">

	
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

					<td class="td" style="text-align: center;"><h3>
<form action="DeliveryNewMedicine"> 
<input type="hidden" name="idPharm" value="${idPharm}" />
<input type="hidden" name="idMed" value="${medicine.id}" /> 
<input type="hidden" name="way" value="toPharmacy" /> 
<input type="text" name="quantity"/>
<input type="submit" class="addMed" value="Add Medicine">
</form>
						</h3></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>
