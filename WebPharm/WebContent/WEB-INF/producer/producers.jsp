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
<p>


<br>
	<a href="AddOrEditProducer?id=<c:out value="0"/>"><button>Add Producer</button></a>
<%-- <form action="addProducer.jsp" method="post">--%>	
	<%
 	application.setAttribute("fromAddMed", "no");
 %>
	<%--	<input type="submit" value="Add Producer" />
	</form>--%>	
		<h4>
			<b><a href="AllProducers"><button class="sendsubmitC"><img src="img/search.png" alt="Search" 
          style="vertical-align: middle" width=33px height=33px></button></a></b> 
		</h4>
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
</body>
</html>
