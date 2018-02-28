
package Controller;

import Entities.About;
import Utility.FileIO;
import Utility.Tool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutController extends HttpServlet {

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fp = Tool.getFileDir(request) + "/about.dat";
        FileIO.<About>write(fp, new About());
        About about = FileIO.<About>read(fp);

        request.setAttribute("about", about);
        request.setAttribute("page", "About");
        request.getRequestDispatcher("Main.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }
}