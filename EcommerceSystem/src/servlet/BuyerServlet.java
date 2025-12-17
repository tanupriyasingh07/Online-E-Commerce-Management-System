package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BuyerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.getWriter().println("Buyer Controller Working");
    }
}
