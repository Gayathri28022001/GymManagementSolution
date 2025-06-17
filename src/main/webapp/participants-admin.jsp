<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="f" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link href="css/styles.css" rel="stylesheet"> -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Participant Admin Panel</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Your Custom Script for Tooltips -->
<script defer>
	document.addEventListener("DOMContentLoaded", function() {
        	const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]');
        	const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl));
    });
        
    </script>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f0f4f8;
	color: #333;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 700px;
	margin: 40px auto;
	padding: 30px;
	background-color: #ffffff;
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	color: #336699;
	font-weight: 700;
	margin-bottom: 25px;
}

form label {
	display: block;
	font-weight: 600;
	margin-top: 15px;
	color: #444;
}

form input, form select {
	width: 100%;
	padding: 12px;
	margin-top: 5px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 15px;
	background-color: #f9f9f9;
	transition: border-color 0.3s ease;
}

form input:focus, form select:focus {
	border-color: #66aaff;
	background-color: #fff;
	outline: none;
}

form button {
	display: block;
	width: 100%;
	padding: 12px;
	margin-top: 25px;
	background-color: #336699;
	color: #fff;
	border: none;
	border-radius: 6px;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

form button:hover {
	background-color: #27496d;
}

.success {
	color: #155724;
	background-color: #d4edda;
	border: 1px solid #c3e6cb;
	padding: 12px;
	border-radius: 6px;
	margin-top: 20px;
	text-align: center;
}

.error {
	color: #721c24;
	background-color: #f8d7da;
	border: 1px solid #f5c6cb;
	padding: 12px;
	border-radius: 6px;
	margin-top: 20px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Participant Management</h2>

		<!-- Section to Retrieve Participant by ID -->
		<div class="section">
			<h3>Retrieve Participant by ID</h3>
			<form action="FrontController" method="get">
				<input type="hidden" name="type" value="participants"> <label
					for="retrievePid">Participant ID:</label> <input type="number"
					id="retrievePid" name="pid" value="${param.id}" required>
				<button type="submit">Submit</button>

				<br></br>

			</form>
		</div>
		<c:if test="${not empty successMessage}">
			<div class="alert alert-info" role="alert">${successMessage}</div>
		</c:if>
		<!-- Section to Add a New Participant -->
		<div class="section">
			<h3>Add a New Participant</h3>
			<form action="FrontController" method="post">

				<input type="hidden" name="type" value="createParticipant">
				<!-- Participant Name -->
				<label for="addName" class="tooltip-trigger"
					data-bs-toggle="tooltip"
					title="Enter full name of the participant."> Participant
					Name: </label> <input type="text" id="addName" name="participantName"
					value="${param.participantName}" required>
				<!-- Participant Phone -->
				<label for="addPhone" class="tooltip-trigger"
					data-bs-toggle="tooltip" title="10-digit mobile number.">
					Participant Phone: </label> <input type="text" id="addPhone"
					name="participantPhone" value="${param.participantPhone}">
				<!-- Participant Email -->
				<label for="addEmail" class="tooltip-trigger"
					data-bs-toggle="tooltip" title="Enter valid email address.">
					Participant Email: </label> <input type="email" id="addemail"
					name="participantEmail" value="${param.participantEmail}" required>
				<!-- Batch ID -->
				<label for="addBatchId" class="tooltip-trigger"
					data-bs-toggle="tooltip" title="Specify the batch ID.">
					Batch ID: </label> <input type="number" id="addBatchId" name="batchId"
					value="${param.BatchId}"> <br></br>

				<button type="submit">Add Participant</button>

				<br></br>
			</form>
		</div>
		<!-- Section to Update an Existing Participant -->
		<div class="section">
			<h3>Update an Existing Participant</h3>
			<form action="FrontController" method="post">
				<input type="hidden" name="type" value="updateParticipant">
				<input type="hidden" id="updatePid" name="pid" value="${param.pid}">

				<label for="updateName">Participant Name:</label> <input type="text"
					id="updateName" name="participantName"
					value="${param.participantName}" required> <label
					for="updatePhone">Participant Phone:</label> <input type="text"
					id="updatePhone" name="participantPhone"
					value="${param.participantPhone}"> <label for="updateEmail">Participant
					Email:</label> <input type="email" id="updateEmail" name="participantEmail"
					value="${param.participantEmail}" required> <label
					for="updateBatchId"> Batch ID:</label> <input type="number"
					id="updateBatchId" name="batchId" value="${param.batchId}" required>

				<br></br>

				<button type="submit">Update Participant</button>

				<br></br>
			</form>
		</div>
		<!-- Display Error and Success Messages -->
		<div class="messages">
			<c:if test="${not empty errorMessage}">
				<p class="error">${errorMessage}</p>
			</c:if>
			<c:if test="${not empty successMessage}">
				<div class="alert alert-primary" role="alert">${successMessage}</div>
			</c:if>
		</div>
	</div>
</body>
</html>