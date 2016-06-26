<%@page import="enums.MedicineType"%>
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
<title>Medicines</title>
<style type="text/css">
 @import "style.css"
</style>
</head>
<body>
<jsp:include page="/header.jsp"/>
<jsp:include page="/medicineHeader.jsp" />
<%--	<form action="SortByType" method="post">
		<select size="1" name="type">
			<option value="AllMedicines">All MEDICINES</option>
			<c:forEach items="<%=MedicineType.values()%>" var="type">
				<option value="${type}">${type}</option>
			</c:forEach>
		</select> <input type="submit" value="select">
	</form> --%>
	<form action="SortMedByTypeAndTitle" method="post">
		<fieldset >
		  <legend><h4>Select medicines type and title:</h4></legend>
			<select size="1" name="type">
				<option value="AllTypes">All Types</option>
				<c:forEach items="<%=MedicineType.values()%>" var="type">
					<option value="${type}">${type}</option>
				</c:forEach>
				</select>
			<select size="1" name="title">
				<option value="AllTitles">All Titles</option>
				<c:forEach items="<%=TitlesDTO.titles()%>" var="title">
					<option value="${title}">${title}</option>
				</c:forEach>
				</select>
				<button class="sendsubmit"><img src="img/search.png" alt="Search" 
          style="vertical-align: middle" width=33px height=33px></button>
			<%--  <input type="submit" class="sendsubmit" value="submit" /> --%>
		</fieldset>
	</form>
	<br>
	<a href="EditMedicine?id=<c:out value="0"/>"><button>Add Medicine</button></a>

	<h3>
			<a href="AllMedicines"><button class="sendsubmitC"><img src="img/search.png" alt="Search" 
          style="vertical-align: middle" width=33px height=33px></button></a> 
			
		</h3>
	<table  class="table">
		<thead>
			<tr>

				<th class="th" bgcolor="silver"><h1>Type</h1></th>
				<th class="th" bgcolor="silver"><h1>Title</h1></th>
				<th class="th" bgcolor="silver"><h1>Date Of Manufacture</h1></th>
				<th class="th" bgcolor="silver"><h1>Term</h1></th>
				<th class="th" bgcolor="silver"><h1>Price</h1></th>
				<th class="th" bgcolor="silver"><h1>Count</h1></th>
				<th class="th" bgcolor="silver"><h1>Producer</h1></th>
				<th class="th" colspan=2 bgcolor="silver"><h1>Action</h1></th>
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
							pattern="dd.MM.yyyy" value="${medicine.dateOfManufact.time}" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${medicine.term} mnth" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${medicine.price} UA" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${medicine.count}" /></td>

					<td class="td" style="text-align: center;"><a
						href="ProducerInfo?id=<c:out value="${medicine.producer.id}"/>">${medicine.producer.title}</a></td>

					<%-- 	<c:forEach items="${producers}" var="producer">
							<a
								href="EditPerson?id=<c:out value="${producer.title}"/>">${producer.title}</a>
						</c:forEach>
						</h3></td>
					--%>

					<td class="td" style="text-align: center;"><h3>
							<a href="EditMedicine?id=<c:out value="${medicine.id}"/>"><img src="img/update.png" alt="Edit" width="35" height="35" style="vertical-align: middle"></a>
						</h3></td>

					<td class="td" style="text-align: center;"><h3>
							<a href="DeleteMedicine?id=<c:out value="${medicine.id}"/>"><img src="img/delete.png" alt="Delete" width="35" height="35" style="vertical-align: middle"></a>
						</h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
