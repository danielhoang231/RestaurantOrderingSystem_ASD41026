<%@page contentType="text/html" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
		<title>Restaurant | Home</title>
		<link rel="stylesheet" href="styles.css">
	</head>

	<body>
		<jsp:include page="/ConnServlet" />

		<header>
			<div>
				<img src="" alt="Logo">
			</div>
			<ul>
				<li><a class="active" href="homedirect.jsp">Home</a></li>
				<li><a href=".">Menu</a></li>
				<li><a href=".">About</a></li>
				<li><a href=".">Contact</a></li>
			</ul>
		</header>

		<div class="content">
			<div>
				<h1>Welcome to the Restaurant Online Ordering System!</h1>
                <h1>What would you like to eat?</h1>
			</div>
			<img src="" alt="Food" style="width:50vw;height:50vh;">
			<div class="dashboard">
			</div>
		</div>

		<footer>
			<ul>
				<li><a href="homedirect.jsp">Home</a></li>
				<li><a href=".">Menu</a></li>
				<li><a href=".">About</a></li>
				<li><a href=".">Contact</a></li>
			</ul>
			<p>By Group 6 | University of Technology | Spring 2024</p>
		</footer>
	</body>

	</html>