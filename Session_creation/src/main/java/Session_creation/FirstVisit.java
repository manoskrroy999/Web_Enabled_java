package Session_creation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/sessionDemo")
public class FirstVisit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get or create session
        HttpSession session = request.getSession(true);

        // Check if new session
        if (session.isNew()) {
            out.println("<h2>Welcome, this is your FIRST visit!</h2>");
            session.setAttribute("visitCount", 1);
        } else {
            // Retrieve and update visit count
            Integer count = (Integer) session.getAttribute("visitCount");
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            session.setAttribute("visitCount", count);

            out.println("<h2>Welcome back!</h2>");
            out.println("<p>You have visited this page <b>" + count + "</b> times in this session.</p>");
        }

        // Show session details
        out.println("<hr>");
        out.println("<p><b>Session ID:</b> " + session.getId() + "</p>");
        out.println("<p><b>Creation Time:</b> " + new java.util.Date(session.getCreationTime()) + "</p>");
        out.println("<p><b>Last Accessed Time:</b> " + new java.util.Date(session.getLastAccessedTime()) + "</p>");

        // Add logout link
        out.println("<p><a href='logout'>Logout (Destroy Session)</a></p>");
    }
}
