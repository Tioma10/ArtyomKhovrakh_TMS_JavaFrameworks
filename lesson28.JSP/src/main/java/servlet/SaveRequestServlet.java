package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/save-request")
public class SaveRequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String requestText = request.getParameter("requestText");

        boolean hasErrors = false;

        if (name == null || name.trim().isEmpty()) {
            hasErrors = true;
        }
        if (email == null || email.trim().isEmpty()) {
            hasErrors = true;
        }
        if (requestText == null || requestText.trim().isEmpty()) {
            hasErrors = true;
        }

        if (hasErrors) {
            response.sendRedirect("save-request.jsp");
            return;
        }

        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("requestText", requestText);
        request.getRequestDispatcher("success.jsp").forward(request, response);
    }
}