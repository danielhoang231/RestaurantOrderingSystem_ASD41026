package com.uts.restaurant.controller;

import com.uts.restaurant.model.dao.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnServletDaniel extends HttpServlet{
    private DBConnectorDaniel db;
    private DBManagerDaniel managerDaniel;
    private Connection conn;

    @Override
    public void init() {
        try {
            db = new DBConnectorDaniel();
        } 
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        conn = db.openConnection();       
        try {
            managerDaniel = new DBManagerDaniel(conn);
            session.setAttribute("managerDaniel", managerDaniel);

        } 
        catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //session.setAttribute("managerDaniel", managerDaniel);           
    }   

    @Override
     public void destroy() {
        try {
            db.closeConnection();
        } 
        catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}