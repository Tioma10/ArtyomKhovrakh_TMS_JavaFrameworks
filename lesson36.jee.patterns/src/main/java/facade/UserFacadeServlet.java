package facade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/user-facade")
public class UserFacadeServlet extends HttpServlet {
    private final UserServiceFacade facade = new UserServiceFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        User user = facade.getUserInfo(name != null ? name : "guest");
        req.setAttribute("user", user);
        req.getRequestDispatcher("/user-facade.jsp").forward(req, res);
    }
}
