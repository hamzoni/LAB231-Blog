
package Controller;

import Entities.Post;
import Model.Data;
import Utility.Tool;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailController extends HttpServlet {

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String page = "Detail";
        
        int id = Tool.toInt(request.getParameter("id"));
        Post post = null;
        
        try {
            post = Data.pst.show(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            page = "Error";
        }

        request.setAttribute("post", post);
        request.setAttribute("page", page);
        request.getRequestDispatcher("Main.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }
}