<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="header">
	<div class="registration">

		<c:set var="registration"
			value="<%=application.getAttribute(\"registration\")%>" />
		<c:choose>
			<c:when test="${'yes' == registration}">
				<h2><%=application.getAttribute("roleReg")%></h2>
				<a href="Logout">Logout</a>
			</c:when>
			<c:otherwise>
				<a href="RegistrationNew">RegistrNew</a>
				<a href="Registration">Registration</a>
				<a href="Enter">Enter</a>
			</c:otherwise>
		</c:choose>


	</div>
	<div class="center">
		<a href="index.jsp"><button class="home">
				<img src="img/home.png" alt="ToMain" width="47" height="47"
					style="vertical-align: middle">
			</button></a> <a href="AllPersons"><button class="button">All Persons</button></a>
		<a href="AllProducers"><button class="button">All
				Producers</button></a> <a href="AllMedicines"><button class="button">All
				Medicines</button></a> <a href="AllPharmacies"><button class="button">All
				Pharmacies</button></a>
	</div>
</div>
