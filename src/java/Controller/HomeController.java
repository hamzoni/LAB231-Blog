
package Controller;

import Entities.Post;
import Model.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = "Home";
        
        ArrayList<Post> posts = new ArrayList<Post>();
        try {
            posts = Data.pst.listTop(3);
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
