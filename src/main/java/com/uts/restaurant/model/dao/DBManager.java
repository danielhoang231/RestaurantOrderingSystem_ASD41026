package com.uts.restaurant.model.dao;

import java.sql.*;
import java.util.ArrayList;
import com.uts.restaurant.model.Customer;
import com.uts.restaurant.model.Staff;
import com.uts.restaurant.model.User;
import com.uts.restaurant.model.Users;

public class DBManager {
    Connection conn;

    public DBManager(Connection conn) throws SQLException {   
        this.conn = conn;    
    }

    public void temp() throws SQLException {
    }

    public boolean checkCustomer(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE customer_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return (rs.next());
    }

    private void addUser(String email, String password, String fname, String surname, String phoneNo) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (email, password, fname, surname, phoneNo, isactive) VALUES (?, ?, ?, ?, ?, ?)");
        ps.setString(1, email);
        ps.setString(2, password);
        ps.setString(3, fname);
        ps.setString(4, surname);
        ps.setString(5, phoneNo);
        ps.setInt(6, (int)1);
        ps.executeUpdate();
    }

    public void addCustomer(String email, String password, String fname, String surname, String phoneNo) throws SQLException {   
        addUser(email, password, fname, surname, phoneNo);
        ResultSet rs = conn.prepareStatement("select LAST_INSERT_ID()").executeQuery();
        if (rs.next()) {
            int id = rs.getInt(1);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Customers (customer_id) VALUES (?)");
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void addStaff(String email, String password, String fname, String surname, String phoneNo) throws SQLException {   
        addUser(email, password, fname, surname, phoneNo);
        ResultSet rs = conn.prepareStatement("select LAST_INSERT_ID()").executeQuery();
        if (rs.next()) {
            int id = rs.getInt(1);
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO Staff (staff_id) VALUES (?)");
            ps2.setInt(1, id);
            ps2.executeUpdate();
        }
    }

    public Users getUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        ResultSet rs = conn.prepareStatement("SELECT * FROM Users").executeQuery();
        while (rs.next()) {
            int id = rs.getInt("user_id");
            String email = rs.getString("email");
            String fname = rs.getString("fname");
            String surname = rs.getString("surname");
            String phoneNo = rs.getString("phoneno");
            Boolean isActive = rs.getBoolean("isactive");
            if (checkCustomer(id)) {
                users.add(new Customer(id, fname, surname, email, phoneNo, isActive));
            }
            else {
                users.add(new Staff(id, fname, surname, email, phoneNo, isActive));
            }
            
        }
        return new Users(users);
    }

    public boolean checkUser(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE userid=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return (rs.next());
    }
    public User getUser(String email, String password) throws SQLException { 
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE email=? AND password=?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            int id = rs.getInt("user_id");
            String fname = rs.getString("fname");
            String surname = rs.getString("surname");
            String phoneNo = rs.getString("phoneno");
            Boolean isActive = rs.getBoolean("isactive");
            if (checkCustomer(id)) {
                return new Customer(id, fname, surname, email, phoneNo, isActive);
            }
            else {
                return new Staff(id, fname, surname, email, phoneNo, isActive);
            }
        }
        return null;
    }

    public int getLastId() throws SQLException {
        ResultSet rs = conn.prepareStatement("SELECT last_insert_id()").executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        throw new SQLException();
    }

    
}