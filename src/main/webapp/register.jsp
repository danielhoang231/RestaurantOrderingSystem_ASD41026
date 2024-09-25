<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.uts.restaurant.model.User" %>
<%@page import="com.uts.restaurant.model.dao.DBManager" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
    <title>Restaurant | Login</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>

<%  
    DBManager manager = (DBManager) request.getSession().getAttribute("manager"); 
    if(manager==null){
        response.sendRedirect("index.jsp"); 
    } 
%>

        <header>
            <div>
                <img src="" alt="Logo">
            </div>
            <ul>
                <li><a href="homedirect.jsp">Home</a></li>
                <li><a href=".">Menu</a></li>
                <li><a href=".">About</a></li>
                <li><a href=".">Contact</a></li>
            </ul>
        </header>

        <div>
            <div id="center">
                <form action="register" , method="post" class="form">
                    <h1>Register</h1>
                    <label for="fname"><b>First Name</b></label>
                    <input type="text" placeholder="Enter first name" name="fname" required>

                    <label for="surname"><b>Surname</b></label>
                    <input type="text" placeholder="Enter surname" name="surname" required>

                    <label for="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter email" name="email" required>

                    <label for="phone"><b>Phone number</b></label>
                    <input type="text" placeholder="Enter phone number" name="phone" required>

                    <label for="password"><b>Password</b></label>
                    <input type="text" placeholder="Enter Password" name="password" required>
                    <button type="submit">Register</button>
                    <div class="container">
                        <a class="cancelbtn" href="index.jsp">Cancel</a>
                        <span>Already have an <a href="login.jsp">account?</a></span>
                    </div>
                </form>
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