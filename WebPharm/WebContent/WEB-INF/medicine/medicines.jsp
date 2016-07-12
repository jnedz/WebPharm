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
<title>Medicines</title>
<style type="text/css">
 @import "style.css"
</style>
<script type="text/javascript"
	src="js/jquery-3.0.0.js" /></script> 
<script type="text/javascript"
	src="js/app-ajax.js" /></script> 
<script type="text/javascript"
	src="js/pagination.js" /></script> 
	
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="mainBlock">
<jsp:include page="/medicineHeader.jsp" />

<a href="AllMedicines" class="reloadButton"><img src="img/reload.png" alt="ReloadMedicines" width="100" height="100"
								style="vertical-align: middle" title="reload medicines"></a>
	<a href="EditMedicine?id=<c:out value="0"/>" class="addButton"><img src="img/add.png" alt="addMedicin" width="100" height="100"
								style="vertical-align: middle" title="add medicine"></a>
	
	<br><br>



	<form action="SortMedByTypeAndTitle" method="post" class="selectPerson">
		<fieldset >
		  <legend><h4>Select medicines type and title:</h4></legend>
	Type:
			<select size="1" name="type">
				<option value="AllTypes">All Types</option>
				<c:forEach items="<%=MedicineType.values()%>" var="type">
					<option ${selectType != "AllTypes" and type == selectType ? 'selected' : ''} value="${type}">${type}</option>
				</c:forEach>
				</select>
			 Title: 
			<select size="1" name="title">
				<option value="AllTitles">All Titles</option>
				<c:forEach items="<%=TitlesDTO.titles()%>" var="title">
					<option ${selectTitle != "AllTitles" and title == selectTitle ? 'selected' : ''} value="${title}">${title}</option>
				</c:forEach>
				</select>
				<button class="sendsubmit"><img src="img/search.png" alt="Search" 
          style="vertical-align: middle" width=33px height=33px></button>
			<%--  <input type="submit" class="sendsubmit" value="submit" /> --%>
		</fieldset>
	</form>
	<br>
<br>




	<div class="table-responsive">
                            <table class="table table-bordered table-hover">
	<!-- <table class="paginated table"> -->
		<thead>
			<tr>

				<th class="th" bgcolor="silver" scope="col"><h1>Type</h1></th>
				<th class="th" bgcolor="silver" scope="col"><h1>Title</h1></th>
				<th class="th" bgcolor="silver" scope="col"><h1>Date Of Manufacture</h1></th>
				<th class="th" bgcolor="silver" scope="col"><h1>Term</h1></th>
				<th class="th" bgcolor="silver" scope="col"><h1>Price</h1></th>
				<th class="th" bgcolor="silver" scope="col"><h1>Count</h1></th>
				<th class="th" bgcolor="silver" scope="col"><h1>Producer</h1></th>
				<th class="th" colspan=2 bgcolor="silver" scope="col"><h1>Action</h1></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${medicines}" var="medicine">
				<tr class="${'NOTYPE' == medicine.type ? 'trRed' : 'tr'}">
				
				<td class="td" style="text-align: center;"><c:out
							value="${medicine.type}" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${medicine.title}" /></td>
					<td class="td" style="text-align: center;"><fmt:formatDate
							pattern="<%= Constants.format %>" value="${medicine.dateOfManufact.time}" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${medicine.term} mnth" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${medicine.price} UA" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${medicine.count}" /></td>

					<td class="td" style="text-align: center;"><a
						href="ProducerInfo?id=<c:out value="${medicine.producer.id}"/>">${medicine.producer.title}</a></td>

					<td class="td" style="text-align: center;"><h3>
							<a href="EditMedicine?id=<c:out value="${medicine.id}"/>"><img src="img/update.png" alt="Edit" width="20" height="20" style="vertical-align: middle" title="Edit"></a>
						</h3></td>

					<td class="td" style="text-align: center;"><h3>
							<a href="DeleteMedicine?id=<c:out value="${medicine.id}"/>"><img src="img/delete.png" alt="Delete" width="20" height="20" style="vertical-align: middle" title="Delete"></a>
						</h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div><div id="pagination"></div>
	<a href="EditMedicine?id=<c:out value="0"/>" class="addButton2"><img src="img/add.png" alt="addMedicin" width="100" height="100"
								style="vertical-align: middle" title="add medicine"></a>
	
		</div>
</body>
</html>
