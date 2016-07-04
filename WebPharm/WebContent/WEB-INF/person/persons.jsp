<%@page import="enums.PersonRole"%> 
<%@page import="utils.Constants"%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>persons</title>
<style type="text/css">
@import
"style.css"
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.0.0.js" /></script>
<script src="${pageContext.request.contextPath}/js/app-ajax.js"
	type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<jsp:include page="/personHeader.jsp" />
<div class="mainBlock">
	
		<a href="AllPersons" class="reloadButton"><img src="img/reload.png" alt="ReloadPersons" width="100" height="100"
								style="vertical-align: middle" title="reload persons"></a>
	<a href="EditPerson?id=<c:out value="0"/>" class="addButton"><img src="img/add.png" alt="addPerson" width="100" height="100"
								style="vertical-align: middle" title="add person"></a>
	
	<br><br><br><br><br><br><br><br>
	
	
	
	<form action="SelectPersonByInput" method="post" id="form2" class="selectPerson">
		<fieldset>
			<legend> Enter Person`s Data for search: </legend>
			<table>
				<tr>
					<td>First name:</td>
					<td><input type="text" name="firstNameForSeach" value="${firstNameForSeach}"
						placeholder="length<=20 symbols" tabindex="1"></td>
					<td><input class="hid"
						type=${firstNameErr == "" ? "hidden" : "text"} name="hid"
						value="${firstNameErr}" readonly tabindex="-1"/></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><input type="text" name="lastNameForSeach" value="${lastNameForSeach}"
						placeholder="length<=20 symbols" tabindex="2"></td>
					<td><input class="hid"
						type=${lastNameErr == "" ? "hidden" : "text"} name="hid"
						value="${lastNameErr}" readonly tabindex="-1"/></td>
				</tr>
				<tr>
					<td>Date of birthday:</td>
					<td><input type="text" name="dateForSeach" value="${dateForSeach}"
						placeholder='format "<%= Constants.format %>"' tabindex="3"></td>
					<td><input class="hid"
						type=${dateErr == "" ? "hidden" : "text"} name="hid"
						value="${dateErr}" readonly tabindex="-1"/></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><button class="sendsubmit">
							<img src="img/search.png" alt="Search"
								style="vertical-align: middle" width=33px height=33px>
						</button></td>
				</tr>
			</table>

		</fieldset>
	</form>

	<br>

	<form action="SortByFirstNameByRole" method="post" id="form1">
		<input type="hidden" value="${order}">
		<legend> Select persons role: </legend>
		<br> <select size="1" name="role" id="userSelect">
			<option ${selectRole == "AllPersons" ? 'selected' : ''}
				value="AllPersons">All Persons</option>
			<c:forEach items="<%=PersonRole.values()%>" var="role">
				<option
					${selectRole != "AllPersons" and role == selectRole ? 'selected' : ''}
					value="${role}">${role}S</option>
			</c:forEach>
		</select>
	</form>
<br>
	<input type="hidden" value="${criteria}" name="criteria"/>
	<table class="table">

		<thead>
			<tr>
				<%--	<th bgcolor="silver"><H1>Id</H1></th> --%>
				<th class="th" bgcolor="silver"><H1>
						First Name
						
<c:choose>
    <c:when test="${order == null || criteria != 'firstName'}">
        <a href="SortByFirstNameByRole?order=ASC&criteria=firstName&role=${selectRole}" > 
        <button class="buttonOrder" name="order" id="userSelect">
			<img src="img/noSort.png"
						width="25" height="25" alt="NoSort"
						style="vertical-align: middle"/> 
							</button></a>
    </c:when>    
    <c:otherwise>
        <a href="SortByFirstNameByRole?order=${order}&criteria=firstName&role=${selectRole}" > 
        <button class="buttonOrder" name="order" id="userSelect">
			<img src="${order == 'ASC' ?'img/za.png' : 'img/az.png'}"
						width="25" height="25" alt="Sort"
						style="vertical-align: middle"/> 
							</button></a>
          </c:otherwise>
</c:choose>
							
					</H1></th>
				<th class="th" bgcolor="silver"><H1>Last Name
				
	<c:choose>
    <c:when test="${order == null || criteria != 'lastName'}">
        <a href="SortByFirstNameByRole?order=ASC&criteria=lastName&role=${selectRole}" >
        <button class="buttonOrder" name="order" id="userSelect">
			<img src="img/noSort.png"
						width="25" height="25" alt="NoSort"
						style="vertical-align: middle"/> 
							</button></a>
    </c:when>    
    <c:otherwise>
        <a href="SortByFirstNameByRole?order=${order}&criteria=lastName&role=${selectRole}" > 
        <button class="buttonOrder" name="order" id="userSelect">
			<img src="${order == 'ASC' ?'img/za.png' : 'img/az.png'}"
						width="25" height="25" alt="Sort"
						style="vertical-align: middle"/> 
							</button></a>
          </c:otherwise>
</c:choose>
				
				</H1></th>
				<th class="th" bgcolor="silver"><H1>Date of Birthday 
	
	<c:choose>
    <c:when test="${order == null || criteria != 'dateOfBirthday'}">
        <a href="SortByFirstNameByRole?order=ASC&criteria=dateOfBirthday&role=${selectRole}" > 
        <button class="buttonOrder" name="order" id="userSelect">
			<img src="img/noSort.png"
						width="25" height="25" alt="NoSort"
						style="vertical-align: middle"/> 
							</button></a>
    </c:when>    
    <c:otherwise>
        <a href="SortByFirstNameByRole?order=${order}&criteria=dateOfBirthday&role=${selectRole}" > 
        <button class="buttonOrder" name="order" id="userSelect">
			<img src="${order == 'ASC' ?'img/za.png' : 'img/az.png'}"
						width="25" height="25" alt="Sort"
						style="vertical-align: middle"/> 
							</button></a>
          </c:otherwise>
</c:choose>			
				
				
				
				
				<th class="th" bgcolor="silver"><H1>Role</H1></th>
				
				
				</H1></th>
				<th class="th" colspan=2 bgcolor="silver"><H1>Action</H1></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${persons}" var="person">
				<tr>
					<%--		<td><input type="hidden" name="id" value="${person.id} " /></td>
				 	<td bgcolor="silver" style="text-align: center;"><h2>
							<c:out value="${person.id}" />
						</h2></td> --%>
					<td class="td" style="text-align: center;"><c:out
							value="${person.firstName}" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${person.lastName}" /></td>
					<td class="td" style="text-align: center;"><fmt:formatDate
							pattern="<%= Constants.format %>" value="${person.dateOfBirthday.time}" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${person.role}" /></td>

					<td class="td" style="text-align: center;"><h3>
							<a href="EditPerson?id=<c:out value="${person.id}"/>"><button
									class="sendsubmitS">
									<img src="img/update.png" alt="Edit" width="20" height="20"
										style="vertical-align: middle" title="Edit">
								</button></a>
						</h3></td>

					<td class="td" style="text-align: center;"><h3>
							<a href="DeletePerson?id=<c:out value="${person.id}"/>"><img
								src="img/delete.png" alt="Delete" width="20" height="20"
								style="vertical-align: middle" title="Delete"></a>
						</h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="EditPerson?id=<c:out value="0"/>" class="addButton2"><img src="img/add.png" alt="addPerson" width="100" height="100"
								style="vertical-align: middle" title="add person"></a>
	
	</div>
</body>
</html>