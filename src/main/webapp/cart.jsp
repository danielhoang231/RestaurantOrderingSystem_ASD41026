<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.uts.restaurant.model.Product"%>
<%@page import="com.uts.restaurant.model.Cart"%>
<%@page import="com.uts.restaurant.model.dao.DBManagerDaniel" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="productStyles.css">
    <link rel="stylesheet" href="styles.css">

    <title>Your Cart</title>
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
    <table>
        <tr></tr>
            <td>ProductID</td>
            <td>Customisation Request</td>
            <td>Quantity</td>
            <td>Remove Product</td>      
        </tr>
        
        <tr>
            <td></td>
        </tr>
    <%
        ArrayList<Cart> cart = (ArrayList<Cart>) request.getSession().getAttribute("cart"); 
        if (cart != null && !cart.isEmpty()) { 
            for (Cart item : cart) {
    %>
        <tr>
            <td><%= item.getProductID() %></td>
            <td><%= item.getCustomisationRequest() %></td>
            <td><%= item.getQuantity() %></td>
            <td>
            
                <button type="submit">Remove item</button>
            </form>
            </td>    
        </tr>
    <%
            }
        } 
        else {
    %>
        <tr>
            <td colspan="5">No products in the cart</td>
        </tr>
    <%
        }
    %>
    </table>


</body>
</html>