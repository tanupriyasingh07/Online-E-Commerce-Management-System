package com.online.ecommerce.servlet;

import com.online.ecommerce.dao.OrderDAO;
import com.online.ecommerce.model.CartItem;
import com.online.ecommerce.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart");
            return;
        }

        double total = 0.0;
        for (CartItem item : cart.values()) {
            total += item.getTotalPrice();
        }

        OrderDAO orderDAO = new OrderDAO();
        try {
            int orderId = orderDAO.createOrder(user.getId(), total);
            if (orderId > 0) {
                for (CartItem item : cart.values()) {
                    orderDAO.addOrderItem(orderId, item.getProduct().getId(), item.getQuantity(), item.getProduct().getPrice());
                }
                session.removeAttribute("cart");
                response.sendRedirect("buyer-dashboard.jsp");
            } else {
                response.sendRedirect("cart");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
