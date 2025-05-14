package front;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/controller")
public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String page = req.getParameter("page");
        String view = "/front.jsp";
        if ("hello".equalsIgnoreCase(page)) {
            req.setAttribute("message", "Hello from Front Controller!");
        }
        req.getRequestDispatcher(view).forward(req, res);
    }
}