package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SellerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.getWriter().println("Seller Controller Working");
    }
}
