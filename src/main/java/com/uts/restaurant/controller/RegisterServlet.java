package com.uts.restaurant.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.uts.restaurant.model.dao.DBManager;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String fname = request.getParameter("fname");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");

        // Checks for bad input against the regex patterns in Utils.
        Boolean valid = true;
        try {
            if (valid) {
                manager.addCustomer(fname, surname, email, phone, password);
                request.getRequestDispatcher("homepage.jsp").include(request, response);
                response.sendRedirect("login.jsp");
            }
            else {
                request.getRequestDispatcher("register.jsp").include(request, response);
            }
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(SearchUsersServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
    }

}