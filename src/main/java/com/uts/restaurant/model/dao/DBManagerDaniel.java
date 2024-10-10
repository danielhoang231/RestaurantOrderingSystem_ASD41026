package com.uts.restaurant.model.dao;

import java.sql.*;
import java.util.ArrayList;

import com.uts.restaurant.model.Product;
import com.uts.restaurant.model.Cart;



public class DBManagerDaniel {
    Connection conn;

    public DBManagerDaniel(Connection conn) throws SQLException {   
        this.conn = conn;    
    }

    public void temp() throws SQLException {
    }

    public ArrayList<Product> getAllProducts() throws SQLException {
        ArrayList<Product> productList = new ArrayList<>();
        ResultSet rs = conn.prepareStatement("SELECT * FROM products").executeQuery();
        while (rs.next()) {
            int id = rs.getInt("product_ID");
            String name = rs.getString("product_name");
            double price = rs.getDouble("product_price");
            String description = rs.getString("product_description");               
            
            Product product = new Product(id, name, price, description);
            productList.add(product);
        }
        return productList;
    }

    public Product getProduct(int id) throws SQLException { 
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM products WHERE product_ID=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Product product = null;
        
        if (rs.next()) {
            int productID = rs.getInt("product_ID");
            String name = rs.getString("product_name");
            double price = rs.getDouble("product_price");
            String description = rs.getString("product_description");    

            product = new Product(productID, name, price, description);
        }
        return product;
    }

    public void addToCart(int productID, String customisation, int quantity) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Cart (product_ID, CustomisationRequest, Quantity) VALUES (?, ?, ?)");
       // ps.setInt(1, id);
        ps.setInt(1, productID);
        ps.setString(2, customisation);
        ps.setInt(3, quantity);
        ps.executeUpdate();
    } 

    public ArrayList<Cart> getCart() throws SQLException {
        ArrayList<Cart> cart = new ArrayList<>();
        ResultSet rs = conn.prepareStatement("SELECT * FROM Cart").executeQuery();
        while (rs.next()) {
            //int id = rs.getInt("CartItemID");
            int productID = rs.getInt("product_ID");
            String customisation = rs.getString("CustomisationRequest");
            int quantity = rs.getInt("Quantity");               
            
            Cart item = new Cart(productID, customisation, quantity);
            cart.add(item);
        }
        return cart;
    }


}