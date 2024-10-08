<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.uts.restaurant.model.Product"%>
<%@page import="com.uts.restaurant.model.dao.DBManagerDaniel" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Menu</title>
    <link rel="stylesheet" href="styles.css">

</head>
<body>
    <header>
        <div>
            <img src="placeholderimage.webp" alt="Logo" height="80px" width="80px">
        </div>
        <ul>
            <li><a class="active" href="homedirect.jsp">Home</a></li>
            <li><a href="MenuServlet">Menu</a></li>
            <li><a href="ViewCartServlet">Cart</a> </li>
            <li><a href=".">About</a></li>
            <li><a href=".">Contact</a></li>
        </ul>
    </header>

    <div class = "content">
        <h1>Food Menu</h1>
        
    <% 
        ArrayList<Product> productList = (ArrayList<Product>) request.getSession().getAttribute("productList");
            if(productList==null){
                response.sendRedirect("index.jsp"); 
            } 
            else {
                for (Product product : productList) {
    %>
                    <div>
                        <h3><a href="RetrieveProductServlet?id=<%=product.getProductID()%>"> <%= product.getProductName() %></h3>                   
                    </div>
    <%
                }
            }
    %>
    </div>
</body>
</html>
