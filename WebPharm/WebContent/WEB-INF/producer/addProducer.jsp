<%@page import="enums.Country"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addProducer</title>
<style type="text/css">
 @import "style.css"
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<jsp:include page="/producerHeader.jsp" />


	<div class="main">
		<div align="left" style="margin-top: 40px;">
			<h4>Add Producer:</h4>
		</div>
		<form action="producers" method="POST">
			<%-- 	<%session.setAttribute("fromAddMed", "AAAAAAAAAAAA");%>
		 --%>
			<div class="field">
				<label for="title">Title:</label> <input type="text" name="title" />
			</div>
			<div class="field">
				<label for="country">Country:</label> <select size="1"
					name="country">
					<c:forEach items="<%=Country.values()%>" var="country">
						<option value="${country}">${country}</option>
					</c:forEach>
				</select>
			</div>
			<p>
			<div class="field">
				<label for="t"></label> <input type="submit" name="submit" value="Add"/>
			</div>
		</form>
	</div>
</body>
</html>