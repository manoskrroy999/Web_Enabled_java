package RefreshPage;

import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RefreshServlet")
public class RefreshServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set content type
        response.setContentType("text/html");

        // Auto refresh every 5 seconds
        response.setHeader("Refresh", "5");

        PrintWriter out = response.getWriter();

        // Print current time
        Date now = new Date();

        out.println("<html><body>");
        out.println("<h2>Auto Refresh Page Example</h2>");
        out.println("<p>Current Time: " + now.toString() + "</p>");
        out.println("<p>This page will refresh every 5 seconds.</p>");
        out.println("</body></html>");
    }
}