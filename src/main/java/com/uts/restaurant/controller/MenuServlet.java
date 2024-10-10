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
import java.util.ArrayList;

public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManagerDaniel managerDaniel = (DBManagerDaniel) session.getAttribute("managerDaniel");
        
        try {
            ArrayList<Product> productList = managerDaniel.getAllProducts();
            session.setAttribute("productList", productList);
            request.getRequestDispatcher("menu.jsp").include(request, response);
        }
        catch (SQLException ex) {
            Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


