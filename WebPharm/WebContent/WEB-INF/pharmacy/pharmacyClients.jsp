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
<title>pharmacyClients</title>
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
	
			<input type="hidden" name="roleReg" value="${roleReg}">
			
			
			<a href="AllPharmacies" class="returnButton2"><img
				src="img/return.png" alt="Return" width="90" height="90"
				style="vertical-align: middle" title="return to all pharmacies"></a>
				
			<form action="ClientsBasket"  method="post">
			<input type="hidden" name="idPharm" value="${idPharm}" />
			<input type="hidden" name="medBasketTitle" value="${medBasketTitle}" />
			<input type="hidden" name="medBasketCount" value="${medBasketCount}" />
			<button class="basket"><h4>orders quantity ${counter}</h4><img src="img/basket.png" alt="basket" width="150" height="150"
					style="vertical-align: middle" title="Clients Basket">
			</button>
		</form>
		
			<br><br><br>
			<br><h4> Pharmacy: ${pharmacy.title}<br> Description:
			${pharmacy.description}
		</h4>
		
<table class="table" border=1>
					<thead>
						<tr>
							<th class="th" bgcolor="silver"><h1>Type</h1></th>
							<th class="th" bgcolor="silver"><h1>Title</h1></th>
							<th class="th" bgcolor="silver"><h1>Date Of Manufacture</h1></th>
							<th class="th" bgcolor="silver"><h1>Term</h1></th>
							<th class="th" bgcolor="silver"><h1>Price</h1></th>
							<th class="th" bgcolor="silver"><h1>Count</h1></th>
							<th class="th" bgcolor="silver"><h1>Select</h1></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${medicines}" var="medicine" varStatus="loop">
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
								<td class="td" style="text-align: center;">
								<form id="F${loop.index }" name="F${loop.index }" action="ClientsOrder" method="post" onsubmit = "return false">
								<h3>
									<input type="hidden" name="idPharm" value="${idPharm}" /> 
									<input type="hidden" name="counter" value="${counter}" />  <input
										type="hidden" name="titleMed" value="${medicine.title}" /> 
										<input type="hidden" name="count" value="${medicine.count}" /> <input
										type="text" name="quantity" value="${quantity}" tabindex=1 class="quantity"/> <input
										type="submit" class="addMed" name="${loop.index}"
										id="${loop.index}" value="Clients Order"
										onClick="getdetails(this)">
								</h3>
							</form>
							</tr>
						</c:forEach>
					</tbody>
				</table>
<form action="WorkWithClients" method="post">
				<input type="hidden" name=idPharm value="${pharmacy.id}"> 
						<input type="hidden" name=title value="${pharmacy.title}"> 
						<input type="hidden" name=gescription value="${pharmacy.description}">
	<button class="WorkWithRightBottom"><img src="img/reload.png" alt="ReloadClientsOrder" width="90" height="90"
								style="vertical-align: middle" title="Reload Clients Order"></button></form>	
	</div>
	
	
	
	<form id="Fp"  action="ClientsOrder" method="post" >
		<c:forEach items="${medicines}" var="medicine" varStatus="loop">
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
								<td class="td" style="text-align: center;">
								
								<h3>
									<input type="hidden" name="idPharm" value="${idPharm}" /> 
									<input type="hidden" name="${'counter'+loop.index}" value="${counter}" />  <input
										type="hidden" name="titleMed" value="${medicine.title}" /> 
										<input type="hidden" name="count" value="${medicine.count}" /> <input
										type="text" name="quantity" value="${quantity}" tabindex=1 class="quantity"/> <input
										type="submit" class="addMed" name="${loop.index}"
										id="${loop.index}" value="Clients Order"
										onClick="getdetails(this)">
								</h3>
							
							</tr>
						</c:forEach>
						
						</form>
	
</body>
</html>