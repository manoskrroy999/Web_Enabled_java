package Session_creation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout")
public class LogoutSession extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false); // don't create if not exists
        if (session != null) {
            session.invalidate(); // destroy session
            out.println("<h2>Session destroyed successfully.</h2>");
        } else {
            out.println("<h2>No active session found.</h2>");
        }

        out.println("<p><a href='sessionDemo'>Go back to session demo</a></p>");
    }
}