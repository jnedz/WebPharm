<%@page import="enums.MedicineType, utils.Constants"%>
<%@page import="utils.TitlesDTO"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addOrEditMedicine</title>
<style type="text/css">
@import
"style.css"
</style>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<jsp:include page="/medicineHeader.jsp" />
	<c:set var="types" value="<%=MedicineType.values()%>">
	</c:set>

	<form action="AllMedicines" method="POST">
		<input type="hidden" name="id" value="${id}" /> <input type="hidden"
			name="selectedType" value="${selectedType}" /> <input type="hidden"
			name="selectedTitle" value="${selectedTitle}" />
		<table class="table1" border="0">
			<caption>Enter Medicine`s data:</caption>
			<tr>
				<th class="th1"></th>
				<th class="th1"></th>
				<th class="th1"></th>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="title">Title:</label>
					</div></td>
				<td class="td1"><input type="text" name="title"
					placeholder="length<=20 symbols" value="${title}" /></td>
				<td class="td1"><input class="hid"
					type=${titleErr == "" ? "hidden" : "text"} name="hid"
					value="${titleErr}" readonly /></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="dateOfManufact">Date of Manufacture: </label>
					</div></td>
				<td class="td1"><input type="text" name="dateOfManufact"
					value="${dateOfManufact}" placeholder='format "<%= Constants.format %>"' /></td>
				<td class="td1"><input class="hid"
					type=${dateErr == "" ? "hidden" : "text"} name="hid"
					value="${dateErr}" readonly /></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="term">Term:</label>
					</div></td>
				<td class="td1"><input type="text" name="term" value="${term}"
					placeholder="number of months validity" /></td>
				<td class="td1"><input class="hid"
					type=${termErr == "" ? "hidden" : "text"} name="hid"
					value="${termErr}" readonly /></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="price">Price:</label>
					</div></td>
				<td class="td1"><input type="text" name="price"
					value="${price}" placeholder="format '0.00'" /></td>
				<td class="td1"><input class="hid"
					type=${priceErr == "" ? "hidden" : "text"} name="hid"
					value="${priceErr}" readonly /></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="count">Count:</label>
					</div></td>
				<td class="td1"><input type="text" name="count"
					value="${count}" placeholder="medicine count" /></td>
				<td class="td1"><input class="hid"
					type=${countErr == "" ? "hidden" : "text"} name="hid"
					value="${countErr}" readonly /></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="producerTitle">${id >0 ? 'Producer titile:' : 'Select producer:'}</label>
					</div></td>
				<td class="td1">
				<select size="1" name="producerTitle">
				<%-- 		<c:forEach items="<%=TitlesDTO.producersTitles()%>"
							var="producerTitle"> 
							<option ${producerTitle == selectedTitle ? 'selected' : ''}
							--%>
							
						
  <option>${selectedTitle}
							
							<%-- ${id>0 ? 'disabled' : ''}
								value="${producerTitle}">${producerTitle} --%></option>
				<%-- 		</c:forEach> --%>
				</select></td>
				<td class="td1"><h5>
			
	<%-- 					or <a href="<c:out value = "${pageContext.request.contextPath}"/>/producer/addProducer.jsp">Add Producer</a> 
	 --%> 					${id > 0 ? "" : '<a href="${pageContext.request.contextPath}/producer/addProducer.jsp">or Add Producer</a>'}
					</h5> <%
 	session.setAttribute("fromAddMed", "yes");
 %></td>
			</tr>
			<tr>
				<td class="td1"><div class="field">
						<label for="type">Medicine Type:</label>
					</div></td>
				<td class="td1"><select size="1" name="type">
						<c:forEach items="<%=MedicineType.values()%>" var="type">
							<option ${type == selectedType ? 'selected' : ''} value="${type}">${type}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Add data" />
	</form>
</body>
</html>