package Hyperlink;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get data from hyperlink (query string parameter)
        String user = request.getParameter("user");

        out.println("<html><body>");
        out.println("<h2>Hello from Servlet!</h2>");
        if (user != null) {
            out.println("<p>Welcome, <b>" + user + "</b></p>");
        } else {
            out.println("<p>No user information received.</p>");
        }
        out.println("</body></html>");
    }
}