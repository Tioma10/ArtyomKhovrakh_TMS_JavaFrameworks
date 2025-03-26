package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/load-book")
@MultipartConfig
public class BookUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String uploadPath = getServletContext().getRealPath("/uploadedBooks");

        new File(uploadPath).mkdirs();

        filePart.write(uploadPath + File.separator + fileName);
        resp.getWriter().println("Book " + fileName + " downloaded");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("""
            <form method="post" action="load-book" enctype="multipart/form-data">
                <input type="file" name="file" required>
                <button type="submit">Загрузить</button>
            </form>
            """);
    }
}