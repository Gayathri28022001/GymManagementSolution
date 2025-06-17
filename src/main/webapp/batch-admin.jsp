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
<title>Batch Management</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Your Custom Script for Tooltips -->
<script defer>
	document.addEventListener("DOMContentLoaded", function () {
        const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]');
        const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl));
    });
    </script>
<style>
/* Page background and font */
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f0f4f8;
	color: #333;
	margin: 0;
	padding: 0;
}

/* Centered container with padding and shadow */
.container {
	max-width: 700px;
	margin: 40px auto;
	padding: 30px;
	background-color: #ffffff;
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

/* Heading style */
h2 {
	text-align: center;
	color: #336699;
	font-weight: 700;
	margin-bottom: 25px;
}

/* Form layout */
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

/* Submit button */
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

/* Success/Error messages */
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
		<h2>Batch Management</h2>

		<!-- Section to Retrieve Batch by ID -->
		<div class="section">
			<h3>Retrieve Batch by ID</h3>
			<form action="FrontController" method="get">
				<input type="hidden" name="type" value="batch"> <label
					for="searchBid">Batch ID:</label> <input type="number"
					id="searchBid" name="bid" value="${param.bid}" required> <br></br>

				<button type="submit" class="btn btn-info">Search</button>

				<br></br>
			</form>
		</div>
		<c:if test="${not empty successMessage}">
			<div class="alert alert-info" role="alert">${successMessage}</div>
		</c:if>

		<!-- Section to Add a New Batch -->
		<div class="section">
			<h3>Add New Batch</h3>
			<form action="FrontController" method="post">
				<input type="hidden" name="type" value="createBatch">
				<!-- Batch Name -->
				<label for="addBatchName" class="tooltip-trigger"
					data-bs-toggle="tooltip" title="Morning or Evening Batch">
					Batch Name: </label> <input type="text" id="addBatchName" name="batchName"
					value="${param.batchName}" required>

				<!-- Batch TimeSlot -->
				<label for="addTimeSlot" class="tooltip-trigger"
					data-bs-toggle="tooltip" title="e.g., 7.00 AM - 8.00 AM">
					Batch Time Slot: </label> <input type="text" id="addTimeSlot"
					name="batchTimeSlot" value="${param.batchTimeSlot}">

				<!-- Batch Trainer Name -->
				<label for="addTrainer" class="tooltip-trigger"
					data-bs-toggle="tooltip" title="Trainer assigned to this batch">Trainer
					Name: </label> <input type="text" id="addTrainer" name="batchTrainerName"
					value="${param.batchTrainerName}"> <br></br>


				<button type="submit" class="btn btn-primary">Add Batch</button>

				<br></br>

			</form>
		</div>

		<!-- Section to Update an Existing Batch -->
		<div class="section">
			<h3>Update an Existing Batch</h3>
			<form action="FrontController" method="post">
				<input type="hidden" name="type" value="updateBatch"> <input
					type="hidden" name="batchId" value="${batch.bid}"> <label
					for="updateBatchName">Batch Name:</label> <input type="text"
					id="updateBatchName" name="batchName" value="${param.batchName}"
					required> <label for="updateTimeSlot">Batch Time
					Slot:</label> <input type="text" id="updateTimeSlot" name="batchTimeSlot"
					value="${param.batchTimeSlot}"> <label for="updateTrainer">Trainer
					Name:</label> <input type="text" id="updateTrainer" name="batchTrainerName"
					value="${param.batchTrainerName}"> <br></br>

				<button type="submit" class="btn btn-warning">Update Batch</button>

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