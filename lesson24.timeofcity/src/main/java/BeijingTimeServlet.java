import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/beijing")
public class BeijingTimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String time = TimeHelper.getCurrentTime("Beijing", "Asia/Shanghai");

        out.println("<html>");
        out.println("<head><title>Beijing Time</title></head>");
        out.println("<body>");
        out.println("<h1>" + time + "</h1>");
        out.println("<a href='./'>Back to home</a>");
        out.println("</body>");
        out.println("</html>");
    }
}