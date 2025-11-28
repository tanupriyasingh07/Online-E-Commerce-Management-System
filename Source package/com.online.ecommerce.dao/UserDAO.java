package com.online.ecommerce.dao;

import com.online.ecommerce.model.Admin;
import com.online.ecommerce.model.Buyer;
import com.online.ecommerce.model.Seller;
import com.online.ecommerce.model.User;

import java.sql.*;

public class UserDAO {

    public User login(String email, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String role = rs.getString("role");
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    if ("ADMIN".equalsIgnoreCase(role)) {
                        return new Admin(id, name, email, password);
                    } else if ("SELLER".equalsIgnoreCase(role)) {
                        return new Seller(id, name, email, password);
                    } else {
                        return new Buyer(id, name, email, password);
                    }
                }
            }
        }
        return null;
    }

    public boolean registerBuyer(String name, String email, String password) throws SQLException {
        String sql = "INSERT INTO users(name, email, password, role) VALUES(?,?,?, 'BUYER')";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            return ps.executeUpdate() > 0;
        }
    }
}
