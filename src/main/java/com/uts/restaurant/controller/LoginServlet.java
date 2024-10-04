package com.uts.restaurant.controller;

import com.uts.restaurant.model.User;
import com.uts.restaurant.model.dao.DBManager;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String dbPassword = "";

        User user;

        try {
            user = manager.getUser(email, password);

            if (user != null) {
                session.setAttribute("user", user);
                request.getRequestDispatcher("homepage.jsp").include(request, response);
            } 
            else {
                session.setAttribute("loginErr", "Email or password is incorrect!");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
            
        } 
        catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
