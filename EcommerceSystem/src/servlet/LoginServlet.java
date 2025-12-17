package servlet;

import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = UserDAO.validateUser(email, password);

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                if (user.getRole().equals("ADMIN"))
                    res.sendRedirect("adminDashboard.jsp");
                else if (user.getRole().equals("SELLER"))
                    res.sendRedirect("sellerDashboard.jsp");
                else
                    res.sendRedirect("buyerDashboard.jsp");
            } else {
                res.getWriter().println("Invalid Login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
