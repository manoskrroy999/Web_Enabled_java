package Upload_Download;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/download")
public class Download extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.equals("")) {
            response.getWriter().println("File Name can't be null or empty");
            return;
        }

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File file = new File(uploadPath, fileName);

        if (!file.exists()) {
            response.getWriter().println("File not found: " + fileName);
            return;
        }

        // Set content type and header
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        // Stream file to client
        FileInputStream inStream = new FileInputStream(file);
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
    }
}