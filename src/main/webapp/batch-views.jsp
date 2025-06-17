<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="f" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Batch View</title>
</head>
<body>
	<h2>Batch View JSTL</h2>

	<!-- Display success message -->
	<c:if test="${not empty successMessage}">
		<p style="color: green;">${successMessage}</p>
	</c:if>
	<!-- Display batch details -->
	<c:if test="${not empty batch}">
		<p>
			<strong>Batch Name:</strong> ${batch.batchName}
		</p>
		<p>
			<strong>Batch Time Slot:</strong> ${batch.timeSlot}
		</p>
		<p>
			<strong>Batch Trainer Name:</strong> ${batch.trainerName}
		</p>
	</c:if>
</body>
</html>