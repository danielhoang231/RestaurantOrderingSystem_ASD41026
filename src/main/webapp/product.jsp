<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.uts.restaurant.model.Product"%>
<%@page import="com.uts.restaurant.model.dao.DBManagerDaniel" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="productStyles.css">
        <link rel="stylesheet" href="styles.css">
        <title>Product Page</title>

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
<br>
<br>
<br>
<br>
<br>
<br>
<br>
        <% 
        Product product = (Product) request.getSession().getAttribute("product");
        %>
        <div>
            <div class="column-container">
                <div class ="column">
                    <img id="food-image" src="food1.jpg" alt="Placeholder Image">
                </div>

                <div class="column">
                    
                    <div class="food-details">

                        <h1><%= product.getProductName() %></h1>
                        <h3><%= product.getProductPrice() %></h3>
                        <p><%= product.getProductDescription() %></p>
                        
      
                    
                    </div>

                    <div class="food-customisation">
                        <h3>Customise Your Food</h3>
                        <form id="customisation-form" action="AddToCartServlet" method="post">
                            <input type="hidden" name="productID" value="<%= product.getProductID() %>">
                            <label for="customise">Requests:</label>
                            <textarea id="customise" name="customise" rows="10" cols="40" maxlength="100"></textarea>
                            <br>
                            <br>
                        
                            <select name="quantity" id="quantity">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>    
                            </select>
                            <br>
                            <br>

                            <button type="submit" class ="button" >Add to order</button>
                        </form>

                    </div>

                </div>  

            </div>

        </div>
        



    </body>
</html>