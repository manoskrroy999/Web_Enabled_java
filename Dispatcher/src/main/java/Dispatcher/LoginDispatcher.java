package Dispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginDispatcher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String password = request.getParameter("password");

        if ("Servlet".equals(password)) {
            // Forward to WelcomeServlet
            RequestDispatcher rd = request.getRequestDispatcher("/welcome");
            rd.forward(request, response);
        } else {
            // Stay on index.html and show error message
            out.println("<h3 style='color:red;'>Invalid Password! Try again.</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
            rd.include(request, response);
        }
    }
}
