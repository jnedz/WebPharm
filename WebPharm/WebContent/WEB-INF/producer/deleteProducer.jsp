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
<div class="mainBlock">
<a href="AllProducers" class="returnButton2"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return to all producers"></a>
	<center>
	<h4>Do you really want to delete producer with title ${producer.title}?</h4>
	<a href="DeleteProducerYes?id=<c:out value="${producer.id}"/>"><button>YES</button></a>
	<a href="AllProducers"><button>NO</button></a>
	</center>
</div>
</body>
</html>