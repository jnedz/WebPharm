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
 @import "style.css"
</style>

</head>
<body>
<jsp:include page="/header.jsp" />
<jsp:include page="/pharmacyHeader.jsp" />
	<H4  style="text-align: left;"><a href="UserController?action=insert"><button>Add Pharmacy</button></a></H4>
	<h4><a href="AllPharmacies">All Pharmacies</a></h4>
	<table  class="table" border=1>
		<thead>
			<tr>
				<th  class="th" bgcolor="silver"><H1>Id</h1></th>
				<th class="th" bgcolor="silver"><H1>Title</H1></th>
				<th class="th" bgcolor="silver"><H1>Description</H1></th>
				<th class="th" colspan=2 bgcolor="silver"><H1>Action</H1></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pharmacies}" var="pharmacy">
				<tr>
					<td class="td" bgcolor="silver" style="text-align: center;"><h2><c:out value="${pharmacy.id}" /></h2></td>
					<td class="td" style="text-align: center;">
					<a href="PharmaciesServlet?idPharm=<c:out value='${pharmacy.id}'/>">${pharmacy.title}</a></td>
					<td class="td" style="text-align: center;"><c:out value="${pharmacy.description}" /></td>
					<td class="td" style="text-align: center;"><h3><a
						href="UserController?action=edit&userId=<c:out value="${user.uname}"/>"><img src="img/update.png" alt="Edit" width="20" height="20" style="vertical-align: middle" title="Edit"></a></h3></td>
					<td class="td" style="text-align: center;"><h3><a
						href="UserController?action=delete&userId=<c:out value="${user.uname}"/>"><img src="img/delete.png" alt="Delete" width="20" height="20" style="vertical-align: middle" title="Delete"></a></h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
