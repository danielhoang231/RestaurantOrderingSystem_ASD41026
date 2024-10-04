<%@page import="com.uts.restaurant.model.User"%>
<%@page import="com.uts.restaurant.model.Customer"%>
<%@page import="com.uts.restaurant.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
		<title>Restaurant | Home</title>
		<link rel="stylesheet" href="styles.css">
	</head>
		<% 
        User user = (User)request.getSession().getAttribute("user");
			if(user == null){
				response.sendRedirect("homedirect.jsp");
				return;
			}
			String fname = user.getFname();
			String email = user.getEmail();
		%>
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
			<div>
				<h1 class="heading-text">Welcome Back <%= fname%>!</h1>
			</div>
            <br>

			<% if (user instanceof Customer) { %>
				<div>
					<h1 class="subheading-text">You are logged in as: </h2>
					
					<h1 class="email-text"><%= email%></h2>
					<br>
					<button type="submit"><a href="logout" method="post">Logout</a></button>
					<br><br><br><br>
				</div>
				<% } else if (user instanceof Staff) { %>
				<div>
					<h1 class="subheading-text">You are logged in as staff: </h2>
					
					<h1 class="email-text"><%= email%></h2>
					<br>
					<button class="logout-btn"><a href="logout" class="login-text">Logout</a></button>
					<br><br><br><br>
				</div>
				<% } else { out.println("User class: " + user.getClass().getName());%>
				<div>
					<div>
						<h1 class="subheading-text">You are logged in as system admin: </h2>
						<br><br><br><br>
					</div>
			  
					  <form class="admin-content" action="view-users">
						<button type="submit" class="admin-btn">View Users</button>
					</form>
					<br><br><br><br>
					<button class="logout-btn"><a href="logout" class="login-text">Logout</a></button>
					<br><br><br><br>
				</div>
				<% } %>

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
