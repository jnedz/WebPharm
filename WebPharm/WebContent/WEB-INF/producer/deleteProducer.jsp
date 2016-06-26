<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>deleteProducer</title>
<style type="text/css">
 @import "style.css"
</style>
</head>
<body>
<jsp:include page="/header.jsp" />
<jsp:include page="/producerHeader.jsp" />
	<center>
	<h4>Do you really want to delete producer with title ${producer.title}?</h4>
	<a href="DeleteProducerYes?id=<c:out value="${producer.id}"/>"><button>YES</button></a>
	<a href="AllProducers"><button>NO</button></a>
	</center>
</body>
</html>