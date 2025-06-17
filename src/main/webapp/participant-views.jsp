<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="f" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Participant View</title>
</head>
<body>
	<h2>Participant View JSTL</h2>

	<!-- Display success message -->
	<c:if test="${not empty successMessage}">
		<p style="color: green;">${successMessage}</p>
	</c:if>
	<!-- Display participant details -->
	<c:if test="${not empty participant}">
		<p>
			<strong>Participant Name:</strong> ${participant.name}
		</p>
		<p>
			<strong>Participant Phone:</strong> ${participant.phone}
		</p>
		<p>
			<strong>Participant Email:</strong> ${participant.email}
		</p>
		<p>
			<strong>Participant Batch ID:</strong> ${participant.bid}
		</p>
	</c:if>
</body>
</html>