package com.uts.restaurant.controller;

import com.uts.restaurant.model.dao.DBManagerDaniel;
import com.uts.restaurant.model.Cart;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger; 

public class AddToCartServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int productID = Integer.parseInt(request.getParameter("productID"));
        String customisation = request.getParameter("customise");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        DBManagerDaniel managerDaniel = (DBManagerDaniel) session.getAttribute("managerDaniel");    
    
        try {
            managerDaniel.addToCart(productID, customisation, quantity);
            request.getRequestDispatcher("menu.jsp").include(request, response);
        }

        catch (SQLException ex) {
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
