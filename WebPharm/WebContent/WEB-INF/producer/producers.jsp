<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>producers</title>
<style type="text/css">
 @import "style.css"
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<jsp:include page="/producerHeader.jsp" />
<div class="mainBlock">

<a href="AllProducers" class="reloadButton"><img src="img/reload.png" alt="ReloadProducers" width="100" height="100"
								style="vertical-align: middle" title="reload producers"></a>
	<a href="AddOrEditProducer?id=<c:out value="0"/>" class="addButton"><img src="img/add.png" alt="addProducer" width="100" height="100"
								style="vertical-align: middle" title="add producer"></a>
	
	<br><br><br><br><br><br><br><br>

	<%
 	application.setAttribute("fromAddMed", "no");
 %>
		
	<table class="table" border=1>
		<thead>
			<tr>
				<th class="th" bgcolor="silver"><h1>Id</h1></th>
				<th class="th" bgcolor="silver"><h1>Title</h1></th>
				<th class="th" bgcolor="silver"><h1>Country</h1></th>
				<th class="th" colspan=2 bgcolor="silver"><h1>Action</h1></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${producers}" var="producer">
				<tr>
					<td class="td" bgcolor="silver" style="text-align: center;"><h2>
							<c:out value="${producer.id}" />
						</h2></td>
					<td class="td" style="text-align: center;"><c:out
							value="${producer.title}" /></td>
					<td class="td" style="text-align: center;"><c:out
							value="${producer.country}" /></td>
					<td class="td" style="text-align: center;"><h3>
							<a href="AddOrEditProducer?id=<c:out value="${producer.id}"/>"><img src="img/update.png" alt="Edit" width="20" height="20" style="vertical-align: middle" title="Edit"></a>
						</h3></td>
					<td class="td" style="text-align: center;"><h3>
							<a href="DeleteProducer?id=<c:out value="${producer.id}"/>"><img src="img/delete.png" alt="Delete" width="20" height="20" style="vertical-align: middle" title="Delete"></a>
						</h3></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="AddOrEditProducer?id=<c:out value="0"/>" class="addButton2"><img src="img/add.png" alt="addProducer" width="100" height="100"
								style="vertical-align: middle" title="add producer"></a>
	</div>
</body>
</html>
