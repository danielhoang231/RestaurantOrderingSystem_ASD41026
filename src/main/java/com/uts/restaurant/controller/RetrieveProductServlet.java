package com.uts.restaurant.controller;

import com.uts.restaurant.model.dao.DBManagerDaniel;
import com.uts.restaurant.model.Product;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger; 

public class RetrieveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManagerDaniel managerDaniel = (DBManagerDaniel) session.getAttribute("managerDaniel");
        
        try {
            //String productID = request.getParameter("id");
            int ID = Integer.parseInt(request.getParameter("id"));
            Product product = managerDaniel.getProduct(ID);
            session.setAttribute("product", product);
            request.getRequestDispatcher("product.jsp").include(request, response);
        }
        catch (SQLException ex) {
            Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}