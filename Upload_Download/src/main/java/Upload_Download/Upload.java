package Upload_Download;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/upload")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
    maxFileSize = 1024 * 1024 * 10,       // 10MB
    maxRequestSize = 1024 * 1024 * 50     // 50MB
)
public class Upload extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Upload directory path
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Get uploaded file
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();

        // Save file on server
        filePart.write(uploadPath + File.separator + fileName);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>File uploaded successfully: " + fileName + "</h3>");
        out.println("<a href='download?fileName=" + fileName + "'>Download File</a>");
    }
}