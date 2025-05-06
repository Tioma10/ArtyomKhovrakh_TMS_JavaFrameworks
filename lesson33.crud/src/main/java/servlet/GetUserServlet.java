package servlet;
import dao.UserDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/get")
public class GetUserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Optional<User> user = userDAO.getUserById(id);
            if (user.isPresent()) {
                resp.getWriter().println("User: " + user.get().getLogin());
            } else {
                resp.getWriter().println("User not found");
            }
           } catch (SQLException e) {
            resp.getWriter().println("Database error");
        }
    }
}

