<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	margin: 0;
	padding: 0;
	background: linear-gradient(to right, #ffecd2, #fcb69f);
	color: #333;
}

.header {
	background: linear-gradient(to right, #00c6ff, #0072ff);
	color: white;
	padding: 30px 0;
	text-align: center;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.header h1 {
	margin: 0;
	font-size: 32px;
	letter-spacing: 1px;
}

.container {
	max-width: 1000px;
	margin: 40px auto;
	padding: 40px;
	background: #ffffff;
	border-radius: 16px;
	box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.container h2 {
	color: #ff6f61;
	font-size: 28px;
	margin-bottom: 15px;
}

.container p {
	font-size: 18px;
	color: #666;
	margin-bottom: 30px;
}

.nav-buttons {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	gap: 20px;
}

.nav-buttons a {
	display: inline-block;
	padding: 14px 28px;
	background: linear-gradient(to right, #43cea2, #185a9d);
	color: white;
	text-decoration: none;
	font-weight: bold;
	border-radius: 8px;
	transition: transform 0.3s ease, box-shadow 0.3s ease;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
}

.nav-buttons a:hover {
	transform: translateY(-4px);
	box-shadow: 0 6px 16px rgba(0, 0, 0, 0.2);
	background: linear-gradient(to right, #ff416c, #ff4b2b);
}

.footer {
	margin-top: 60px;
	text-align: center;
	font-size: 15px;
	color: #555;
	padding-bottom: 20px;
}
</style>
</head>
<body>
	<h2>Welcome to Gym Management Solution</h2>

	<p>
		<a href="${pageContext.request.contextPath}/participants-admin.jsp">Go
			to Participants Admin Page</a>
	</p>
	<p>
		<a href="participants-admin.jsp">Static Link to admin Participants</a>
	</p>

	<p>

		<a href="${pageContext.request.contextPath}/batch-admin.jsp">Go to
			Batch Admin Page</a>
	</p>
	<p>
		<a href="batch-admin.jsp">Static Link to admin Batch</a>
	</p>
</body>
</html>
