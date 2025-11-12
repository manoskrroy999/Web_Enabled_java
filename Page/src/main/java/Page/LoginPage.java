package Page;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get user input
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String correctUsername = "admin";
        String correctPassword = "1234";

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            out.println("<h2>Hello admin</h2>");
        } else {
            out.println("<h2 style='color:red;'>Login Failed</h2>");
        }
    }
}