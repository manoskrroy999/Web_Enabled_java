package Page;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/calculate")
public class simplecalculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form parameters
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");

        double result = 0;
        String opSymbol = "";

        switch (operation) {
            case "add":
                result = num1 + num2;
                opSymbol = "+";
                break;
            case "sub":
                result = num1 - num2;
                opSymbol = "-";
                break;
            case "mul":
                result = num1 * num2;
                opSymbol = "×";
                break;
            case "div":
                if (num2 != 0) {
                    result = num1 / num2;
                    opSymbol = "÷";
                } else {
                    out.println("<h3 style='color:red;'>Error: Division by zero is not allowed!</h3>");
                    return;
                }
                break;
        }

        // Display result
        out.println("<html><body>");
        out.println("<h2>Calculation Result</h2>");
        out.println("<p>" + num1 + " " + opSymbol + " " + num2 + " = <b>" + result + "</b></p>");
        out.println("<a href='index.html'>Back to Calculator</a>");
        out.println("</body></html>");
    }
}
