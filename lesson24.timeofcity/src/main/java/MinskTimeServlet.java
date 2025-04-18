import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/minsk")
public class MinskTimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String time = TimeHelper.getCurrentTime("Minsk", "Europe/Minsk");

        out.println("<html>");
        out.println("<head><title>Minsk Time</title></head>");
        out.println("<body>");
        out.println("<h1>" + time + "</h1>");
        out.println("<a href='./'>Back to home</a>");
        out.println("</body>");
        out.println("</html>");
    }
}