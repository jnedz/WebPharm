<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>deleteMedicine</title>
<style type="text/css">
 @import "style.css"
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<jsp:include page="/medicineHeader.jsp" />
	<center>
	<h4>Do you really want to delete medicine with title ${medicine.title}?</h4>
	<a href="DeleteMedicineYes?id=<c:out value = "${medicine.id}"/>"><button>YES</button></a>
	<a href="AllMedicines"><button>NO</button></a>
	</center>
</body>
</html>