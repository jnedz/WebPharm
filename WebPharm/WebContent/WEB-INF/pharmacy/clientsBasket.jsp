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
<title>clientsBasket</title>
<style type="text/css">
@import
"style.css"
</style>
<script type="text/javascript" src="js/jquery-3.0.0.js" /></script>
<script type="text/javascript" src="js/inputValidator.js" /></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="mainBlock">
	<jsp:include page="/pharmacyHeader.jsp" />
	
	<c:set var="idPharmApplication"
			value="<%=application.getAttribute(\"idPharm\")%>" />
	
			<h4>
			<a href="#" onclick="history.back()" class="returnButton2"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return"></a>
				
			<br><br><br>
			<br> Pharmacy: ${pharmacy.title}<br> Description:
			${pharmacy.description}
		</h4>
		
<table class="table" border=1>
					<thead>
						<tr>
							<th class="th" bgcolor="silver"><h1>Title</h1></th>
							<th class="th" bgcolor="silver"><h1>Count</h1></th>
						</tr>
					</thead>
					<tbody>
					<%-- 	<c:forEach items="${medsBasket}" var="medBasket"> --%>
							<tr>
								<td class="td" style="text-align: center;"><c:out
										value="${medBasket.title}" /></td>
								<td class="td" style="text-align: center;"><c:out
										value="${medBasket.count}" /></td>
							</tr>
						<%-- </c:forEach> --%>
					</tbody>
				</table>


	</div>
</body>
</html>