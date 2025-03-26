package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("LoggingFilter is init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("[" + LocalDateTime.now() + "] Request: " +
                httpRequest.getMethod() + " " + httpRequest.getRequestURI());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}