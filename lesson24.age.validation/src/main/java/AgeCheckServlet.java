import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check-age")
public class AgeCheckServlet extends HttpServlet {

    private static final int LEGAL_AGE = 18;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        
        String ageParam = request.getParameter("age");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Результат проверки возраста</title></head>");
            out.println("<body>");
            int age = Integer.parseInt(ageParam);

            if (ageParam == null || ageParam.isEmpty()) {
                out.println("<h1>Ошибка: параметр 'age' не указан</h1>");
            }

            if (age<0){
                out.println("<h1>Ошибка: возраст не может быть отрицательным</h1>");
            }
            else {
                try {
                    if (age >= LEGAL_AGE) {
                        out.println("<h1>Результат: Совершеннолетний</h1>");
                    } else {
                        out.println("<h1>Результат: Несовершеннолетний</h1>");
                    }
                } catch (NumberFormatException e) {
                    out.println("<h1>Ошибка: параметр 'age' должен быть числом</h1>");
                }
            }

            out.println("<a href='index.jsp'>Проверить другой возраст</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}