package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/book")
public class BookDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String filePath = getServletContext().getRealPath("/uploadedBooks/test.pdf");
        File file = new File(filePath);

        if (!file.exists()) {
            resp.getWriter().println("Book not found!");
            return;
        }

        resp.setContentType("application/pdf");
        resp.setHeader("Content-Disposition", "attachment; filename=\"book.pdf\"");

        try (InputStream in = new FileInputStream(file);
             OutputStream out = resp.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}