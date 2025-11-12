package DateTime;

import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/datetime")
public class DateTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get current date and time
        Date currentDate = new Date();

        // Print HTML output
        out.println("<html><body>");
        out.println("<h2>Current Date and Time</h2>");
        out.println("<p>" + currentDate.toString() + "</p>");
        out.println("</body></html>");
    }
}
