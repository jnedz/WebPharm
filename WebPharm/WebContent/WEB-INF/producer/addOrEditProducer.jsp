<%@page import="enums.Country"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addOrEditProducer</title>
<style type="text/css">
 @import "style.css"
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<jsp:include page="/producerHeader.jsp" />
<div class="mainBlock">



	<div class="main">
		<div align="left" style="margin-top: 40px;">
			<h4>Add Producer`s Data:</h4>
		</div>
		
	

	<form action="AllProducers" method="POST">
 	<button class="addButton3"><img src="img/add.png" alt="addProducer" width="100" height="100"
								style="vertical-align: middle" title=${id>0 ? "edit producer" : "add producer"}></button>	 
		<input type="hidden" name="id" value="${id}" /> 
		<input type="hidden" name="selectedCountry" value="${selectedCountry}" />
		<table class="table1" border="0">
			<caption>
				Enter Producer`s data:<br>
			</caption>
			<tr>
				<th class="th1"></th>
				<th class="th1"></th>
				<th class="th1"></th>
			</tr>
			<tr>
				<td class="td1"><div class="field">
				<label for="producerTitle">Title:</label>
			</div>
			</td>
				<td class="td1"><input type="text" name="producerTitle" placeholder="length<=20 symbols" 
					value="${producerTitle}" tabindex="1" /></td>
				<td class="td1"><input class="hid"
					type=${producerTitleErr == "" ? "hidden" : "text"} name="hid"
					value="${producerTitleErr}" readonly tabindex="-1" /></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="country">Country:</label>
					</div></td>
				<td class="td1"><select size="1"
					name="country">
					<c:forEach items="<%=Country.values()%>" var="country">
						<option  ${country == selectedCountry ? 'selected' : ''} value="${country}">${country}</option>
					</c:forEach>
				</select></td>
				<td class="td1"></td>
			</tr>
		</table>
	<%--	<input type="submit" value=${id>0 ? 'Edit' : 'Add'} />
		<p><input value="Return" type="button" onclick="history.back()"> --%>
	</form>
	<br>
	<a href="#" onclick="history.back()" class="returnButton"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return"></a>
</div>	
</div>	
</body>
</html>