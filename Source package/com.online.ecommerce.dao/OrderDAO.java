package com.online.ecommerce.dao;

import com.online.ecommerce.model.Order;
import com.online.ecommerce.model.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO {

    public int createOrder(int buyerId, double totalAmount) throws SQLException {
        String sql = "INSERT INTO orders(buyer_id, order_date, status, total_amount) VALUES(?, NOW(), 'PENDING', ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, buyerId);
            ps.setDouble(2, totalAmount);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public void addOrderItem(int orderId, int productId, int quantity, double price) throws SQLException {
        String sql = "INSERT INTO order_items(order_id, product_id, quantity, price) VALUES(?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.executeUpdate();
        }
    }

    public List<Order> getOrdersByBuyer(int buyerId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE buyer_id = ? ORDER BY order_date DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, buyerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Order o = new Order();
                    o.setId(rs.getInt("id"));
                    o.setBuyerId(buyerId);
                    o.setOrderDate(new Date(rs.getTimestamp("order_date").getTime()));
                    o.setStatus(rs.getString("status"));
                    o.setTotalAmount(rs.getDouble("total_amount"));
                    orders.add(o);
                }
            }
        }
        return orders;
    }
}
