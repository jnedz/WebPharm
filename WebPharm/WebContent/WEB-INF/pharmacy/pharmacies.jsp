<%@page import="enums.PersonRole"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pharmacies</title>
<style type="text/css">
@import
"style.css"
</style>

</head>
<body>
	<jsp:include page="/header.jsp" />
	<jsp:include page="/pharmacyHeader.jsp" />




<a href="#" onclick="show_form(); return false"><span id="sp_sel"><h2>Registration</h2></span></a> 
<div id="div_form" style="display:none" > 
<form action="LoginPasswordPharmacy">

		<p>
			Login: <input type="text" maxlength="25" size="30" name="login">
		</p>
		<p>
			Password: <input type="password" maxlength="25" size="30"
				name="password">
		</p>
		<c:forEach items="<%=PersonRole.values()%>" var="role">
			<INPUT TYPE="radio" NAME="role" VALUE="${role}"> ${role}
	       </c:forEach>
		<input type="submit" value="Enter">
	</form> 
</div>
<script type="text/javascript"> 
function show_form() 
{ 
var d = document;  
var a = d.getElementById('div_form').style.display; 
d.getElementById('div_form').style.display = (a == 'none')?'block':'none'; 
d.getElementById('sp_sel').innerHTML = (a == 'none')?'close':'<h2>Registration</h2>';  
} 
</script> 

<a href="#" onclick="show_form2(); return false"><span id="sp_sel2"><h2>Enter</h2></span></a> 
<div id="div_form2" style="display:none" > 
<form action="LoginPasswordPharmacy">
<input type="hidden" name="enter" value="yes">
		<p>
			Login: <input type="text" maxlength="25" size="30" name="login">
		</p>
		<p>
			Password: <input type="password" maxlength="25" size="30"
				name="password">
		</p>
		<c:forEach items="<%=PersonRole.values()%>" var="role">
			<INPUT TYPE="radio" NAME="role" VALUE="${role}"> ${role}
	       </c:forEach>
		<input type="submit" value="Enter">
	</form> 
</div>
<script type="text/javascript"> 
function show_form2() 
{ 
var d = document;  
var a = d.getElementById('div_form2').style.display; 
d.getElementById('div_form2').style.display = (a == 'none')?'block':'none'; 
d.getElementById('sp_sel2').innerHTML = (a == 'none')?'close':'<h2>Enter</h2>';  
} 
</script> 
<br>

	<table class="table" border=1>
		<thead>
			<tr>
				<th class="th" bgcolor="silver"><H1>Id</h1></th>
				<th class="th" bgcolor="silver"><H1>Title</H1></th>
				<th class="th" bgcolor="silver"><H1>Description</H1></th>
				<th class="th" colspan=2 bgcolor="silver"><H1>Action</H1></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pharmacies}" var="pharmacy">
				<tr>
					<td class="td" bgcolor="silver" style="text-align: center;"><h2>
							<c:out value="${pharmacy.id}" />
						</h2></td>
					<td class="td" style="text-align: center;"><a
						href="PharmaciesServlet?idPharm=<c:out value='${pharmacy.id}'/>"
						title="${pharmacy.title}: ${pharmacy.description}">${pharmacy.title}</a></td>
					<td class="td" style="text-align: center;"><c:out
							value="${pharmacy.description}" /></td>
					<td class="td" style="text-align: center;"><h3>
							<a
								href="UserController?action=edit&userId=<c:out value="${user.uname}"/>"><img
								src="img/update.png" alt="Edit" width="20" height="20"
								style="vertical-align: middle" title="Edit"></a>
						</h3></td>
					<td class="td" style="text-align: center;"><h3>
							<a
								href="UserController?action=delete&userId=<c:out value="${user.uname}"/>"><img
								src="img/delete.png" alt="Delete" width="20" height="20"
								style="vertical-align: middle" title="Delete"></a>
						</h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
