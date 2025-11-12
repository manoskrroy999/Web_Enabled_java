package Cookies;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/visit")
public class VisitCountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int visitCount = 0;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                }
            }
        }

        visitCount++;

        Cookie visitCookie = new Cookie("visitCount", Integer.toString(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24); // 1 day validity
        response.addCookie(visitCookie);

        // Display the count
        out.println("<h2>Welcome to the Visit Counter Servlet</h2>");
        out.println("<p>You have visited this page <b>" + visitCount + "</b> times.</p>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}