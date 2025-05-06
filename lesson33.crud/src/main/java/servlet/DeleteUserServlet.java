package servlet;
import dao.UserDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            userDAO.deleteUser(id);
            resp.getWriter().println("User deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(500, "DB error: " + e.getMessage());
        }
    }
}
