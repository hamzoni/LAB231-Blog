
package Controller;

import Entities.Post;
import Model.Data;
import Utility.Tool;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OverviewController  extends HttpServlet {
    
    public static final int total = 100;

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String page = "Overview";
        int count = -1;
        int pageIndex = Tool.toInt(request.getParameter("page"));
        if (pageIndex == -1) pageIndex = 1;
        
        ArrayList<Post> posts = null;
        try {
            posts = Data.pst.listAll(pageIndex - 1, total);
            count = Data.pst.countAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            page = "Error";
        }
        
        request.setAttribute("posts", posts);
        request.setAttribute("count", count / total);
        request.setAttribute("page", page);
        request.getRequestDispatcher("Main.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }
}