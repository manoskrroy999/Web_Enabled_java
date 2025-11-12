import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.regex.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form data
        String fname = request.getParameter("fname");
        String mname = request.getParameter("mname");
        String lname = request.getParameter("lname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String location = request.getParameter("location");
        String education = request.getParameter("education");
        String phone = request.getParameter("phone");

        // Validation patterns
        Pattern alphaPattern = Pattern.compile("^[A-Za-z]+$");
        Pattern passPattern = Pattern.compile("^(?=.*[0-9])(?=.*[!@#$%^&*]).{6,}$");

        // Validate mandatory fields
        if (fname == null || lname == null || login == null || password == null || cpassword == null
                || fname.isEmpty() || lname.isEmpty() || login.isEmpty() || password.isEmpty() || cpassword.isEmpty()) {
            out.println("<h3 style='color:red;'>Error: All mandatory fields (*) must be filled!</h3>");
            return;
        }

        // Validate name fields (only alphabets)
        if (!alphaPattern.matcher(fname).matches() || !alphaPattern.matcher(lname).matches()
                || (mname != null && !mname.isEmpty() && !alphaPattern.matcher(mname).matches())) {
            out.println("<h3 style='color:red;'>Error: Names must contain only alphabets!</h3>");
            return;
        }

        // Validate password rules
        if (!passPattern.matcher(password).matches()) {
            out.println("<h3 style='color:red;'>Error: Password must be at least 6 characters long, contain letters, numbers and a special character!</h3>");
            return;
        }

        // Confirm password check
        if (!password.equals(cpassword)) {
            out.println("<h3 style='color:red;'>Error: Passwords do not match!</h3>");
            return;
        }

        // Success message
        out.println("<h2 style='color:green;'>Registration Successful!</h2>");
        out.println("<p>Welcome, " + fname + " " + lname + " (" + login + ")</p>");
    }
}
