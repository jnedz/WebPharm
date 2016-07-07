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
	<a href="PharmaciesServlet?idPharm=<c:out value='${idPharm}'/>"" class="returnButton2"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return"></a>
	<br><br><br><br><br>
	<form action="DeliveryMedicines?idMed=<c:out value="${idMed}"/>&way=<c:out value="${way}"/>&idPharm=<c:out value="${idPharm}"/>" method="get">
	<input type="hidden" name="idPharm" value="${idPharm}" /> 
		<input type="hidden" name="idMed" value="${idMed}" /> 
		<input type="hidden" name="way" value="${way}" /> 
		<input type="hidden" name="medicine" value="${medicine}" />
		<input type="hidden" name="count" value="${count}" />
		<input type="hidden" name="countAll" value="${countAll}" />
		<input type="hidden" name="pharmacy" value="${pharmacy}" />
		<br><h4> Pharmacy "${pharmacy.title}" has ${count} packs of
		${medicine.title}.  Pharmacies have ${countAll} packs of
		${medicine.title}.<br>Enter quantity for delivery ${way == "toPharmacy" ? "to pharmacy" : "from pharmacy"}:
		</h4>
		<input type="text" name="quantity" placeholder="quantity>0"
			tabindex="1" /> 
			<input class="hid"
			type=${quantityErr == "" ? "hidden" : "text"} name="hid"
			value="${quantityErr}" readonly tabindex="-1" />
			<input type="submit" value="Delivery"> 
		</form>
		</div>	
</body>
</html>