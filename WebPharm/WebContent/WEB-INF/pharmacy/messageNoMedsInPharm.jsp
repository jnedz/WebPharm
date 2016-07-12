<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>messageNoMedsInPharm</title>
<style type="text/css">
 @import "style.css"
</style>

</head>
<body>
<jsp:include page="/header.jsp" />
<div class="mainBlock">
<jsp:include page="/pharmacyHeader.jsp" />

<a href="#" onclick="history.back()" class="returnButton2"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return"></a>
			
			
			<c:set var="idPharmApplication"
			value="<%=application.getAttribute(\"idPharm\")%>" />
	
			<input type="hidden" name="roleReg" value="${roleReg}">					

		<c:choose>
			<c:when test="${'WORKER' == roleReg && pharmacy.id == idPharmApplication}">
			<center>
<h4>Pharmacy "${pharmacy.title}" does'nt have medicines.<br> You can add medicines from Storage.</h4><%-- <br><input value="Return" type="button" onclick="history.back()">
--%>
</center>
			<br><br>
			<form action="AddMedicineFromPharmacy" method="post">
	<button class="addButtonLeft"><img src="img/add.png" alt="addMedicine"
						width="100" height="100" style="vertical-align: middle"
						title="add medicine"></button> 
		<input type="hidden" name="idPharm" value="${idPharm}" /> 						
								</form>
								
			</c:when>
			<c:otherwise>

<center>
<h4>Pharmacy "${pharmacy.title}" does'nt have medicines.</h4>
</center>

			</c:otherwise>
		</c:choose>
								
</div>
</body>
</html>