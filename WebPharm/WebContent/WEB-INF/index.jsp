<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="/header.jsp" />
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<style type="text/css">
 @import "style.css"
</style>
</head>
<body>

	<br>
	<form action="AllPersons" method="post">
		<input type="submit" value="All Persons" />
	</form>
	<br>
	<form action="AllProducers" method="post">
		<input type="submit" value="All Producers" />
	</form>
	<br>
	<form action="AllMedicines" method="post">
		<input type="submit" value="All Medicines" />
	</form>
	<br>
	<form action="AllPharmacies" method="post">
		<input type="submit" value="All Pharmacies" />
	</form>
	<br>
</body>
</html>