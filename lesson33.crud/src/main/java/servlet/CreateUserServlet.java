package servlet;
import dao.UserDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/create")
public class CreateUserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        try {
            userDAO.createUser(new User(login));
            resp.getWriter().println("User created");
        } catch (SQLException e) {
            e.printStackTrace(); // В консоль Tomcat
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "DB ERROR: " + e.getMessage());
        }
    }
}