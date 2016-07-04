<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>messageNoMedsInPharm</title>
<style type="text/css">
 @import "style.css"
</style>

</head>
<body>
<jsp:include page="/header.jsp" />
<jsp:include page="/pharmacyHeader.jsp" />
<div class="mainBlock">
<a href="#" onclick="history.back()" class="returnButton2"><img src="img/return.png" alt="Return" width="90" height="90"
								style="vertical-align: middle" title="return"></a>
<center>
<h4>Pharmacy "${pharmacy.title}" does'nt have medicines.</h4><%-- <br><input value="Return" type="button" onclick="history.back()">
--%>
</center>
</div>
</body>
</html>