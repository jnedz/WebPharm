<%@page import="enums.PersonRole, utils.Constants"%> 

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


	<script type="text/javascript">
		function formAutoSubmit() {
			var frm = document.getElementById("userSelect");
			frm.submit();
		}
	</script>


	<%-- 		SortByFirstName: <a href="SortByFirstName?role=${role}&order=${order}"><button> --%>
	<%-- 

	<form>
		Enter Your Name: <input type="text" id="userName" />
	</form>
	<br>
	<br>

	<strong>Ajax Response</strong>:
	<div id="ajaxGetUserServletResponse"></div>

	${5-40} ${buttonRole}

 --%>

	<br>
	<br>
	<form action="SelectPersonByInput" method="post" id="form2">
		<fieldset>
			<legend> Enter Person`s Data for search: </legend>
			<table>
				<tr>
					<td>First name:</td>
					<td><input type="text" name="firstName" value="${firstName}"
						placeholder="length<=20 symbols"></td>
					<td><input class="hid"
						type=${firstNameErr == "" ? "hidden" : "text"} name="hid"
						value="${firstNameErr}" readonly /></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><input type="text" name="lastName" value="${lastName}"
						placeholder="length<=20 symbols"></td>
					<td><input class="hid"
						type=${lastNameErr == "" ? "hidden" : "text"} name="hid"
						value="${lastNameErr}" readonly /></td>
				</tr>
				<tr>
					<td>Date of birthday:</td>
					<td><input type="text" name="date" value="${date}"
						placeholder='format "<%= Constants.format %>"'></td>
					<td><input class="hid"
						type=${dateErr == "" ? "hidden" : "text"} name="hid"
						value="${dateErr}" readonly /></td>
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

	<%-- 		<button value="ASC" name="order">
				<img src="${buttonRole == 'WORKER' ?'img/22.jpg' : 'img/11.jpg'}"
					width="35" height="28" alt="Sort" style="vertical-align: middle">
			</button>
--%>
	<%-- 	</fieldset>--%>



	<%-- 	<br>
	
	
	<form action="addOrEditPerson.jsp" method="post">
		<input type="submit" value="Add Person" />
	</form>--%>

	<br>

	<%-- 	<a href="${pageContext.request.contextPath}/person/addOrEditPerson.jsp"><button>Add Person</button></a> --%>
	<a href="EditPerson?id=<c:out value="0"/>"><button>Add
			Person</button></a>


	<!-- 	<button value = "DESC" name = "order"><img src="img/22.jpg" width="35" height="28" alt="Sort"
					style="vertical-align: middle"></button>   -->

	<h4>
		<a href="AllPersons"><button class="sendsubmitC">
				<img src="img/search.png" alt="Search"
					style="vertical-align: middle" width=33px height=33px>
			</button></a>
	</h4>
	<table class="table">

		<thead>
			<tr>
				<%--	<th bgcolor="silver"><H1>Id</H1></th> --%>
				<th class="th" bgcolor="silver"><H1>
						First Name
						
<%-- <a href=${order == null ? 'SortByFirstNameByRole?order=ASC' : 'SortByFirstNameByRole?order="${order}"'} >  --%>

<c:choose>
    <c:when test="${order == null}">
        <a href="SortByFirstNameByRole?order=ASC" > 
    </c:when>    
    <c:otherwise>
        <a href="SortByFirstNameByRole?order=${order}" > 
          </c:otherwise>
</c:choose>
	
	<button name="order" id="userSelect">
			<img src="${order == 'ASC' ?'img/22.jpg' : 'img/11.jpg'}"
						width="35" height="28" alt="Sort"
						style="vertical-align: middle"/> 
							</button></a> 
							
							
						<%-- 	
						<form action="SortByRole" method="post" id="form1">
						<%--<a href="SortByFirstNameByRole?order ='ASC'"><button
								class="sendsubmitS">
								<img
									src="${buttonRole == 'WORKER' ?'img/22.jpg' : 'img/11.jpg'}"
									width="33" height="33" alt="Sort"
									style="vertical-align: middle">
							</button></a>
							 <select size="1" name="order">
				<option ${order == "NoSort" ? 'selected' : ''} value="NoSort">No
					Sort</option>
				<option ${order == "ASC" ? 'selected' : ''} value="ASC">A-Z</option>
				<option ${order == "DESC" ? 'selected' : ''} value="DESC">Z-A</option>
			</select>
				</form>	
						--%>



					</H1></th>
				<th class="th" bgcolor="silver"><H1>Last Name</H1></th>
				<th class="th" bgcolor="silver"><H1>Role</H1></th>
				<th class="th" bgcolor="silver"><H1>Date of BirthDay 
				
				
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
					<td class="td" style="text-align: center;"><c:out
							value="${person.role}" /></td>
					<td class="td" style="text-align: center;"><fmt:formatDate
							pattern="dd.MM.yyyy" value="${person.dateOfBirthday.time}" /></td>

					<td class="td" style="text-align: center;"><h3>
							<a href="EditPerson?id=<c:out value="${person.id}"/>"><button
									class="sendsubmitS">
									<img src="img/update.png" alt="Edit" width="35" height="35"
										style="vertical-align: middle">
								</button></a>
						</h3></td>

					<td class="td" style="text-align: center;"><h3>
							<a href="DeletePerson?id=<c:out value="${person.id}"/>"><img
								src="img/delete.png" alt="Delete" width="35" height="35"
								style="vertical-align: middle"></a>
						</h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>