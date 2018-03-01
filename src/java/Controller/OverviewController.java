
package Controller;

import Entities.Post;
import Model.Data;
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

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String page = "Overview";
        
        HashMap<Integer, HashMap<Integer, ArrayList<Post>>> posts = null;
        try {
            posts = Data.pst.listAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            page = "Error";
        }
        
        request.setAttribute("posts", posts);
        request.setAttribute("page", page);
        request.getRequestDispatcher("Main.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }
}