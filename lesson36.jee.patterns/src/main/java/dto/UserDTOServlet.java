package dto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/user-dto")
public class UserDTOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        UserDTO dto = new UserDTO("Alice", "alice@example.com", 30);
        req.setAttribute("user", dto);
        req.getRequestDispatcher("/user-dto.jsp").forward(req, res);
    }
}