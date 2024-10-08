package com.uts.restaurant.controller;

import com.uts.restaurant.model.dao.DBManager;
import com.uts.restaurant.model.dao.DBManagerDaniel;
import com.uts.restaurant.model.Cart;
import com.uts.restaurant.model.Product;
import com.uts.restaurant.model.User;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger; 


public class ViewCartServlet extends HttpServlet {

    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManagerDaniel managerDaniel = (DBManagerDaniel) session.getAttribute("managerDaniel");
        
        try {
            ArrayList<Cart> cart = managerDaniel.getCart();

            session.setAttribute("cart", cart);
            request.getRequestDispatcher("cart.jsp").include(request, response);
        }
        catch (SQLException ex) {
            Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
