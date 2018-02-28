
package Utility;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class Tool {
    public static int toInt(String n) {
        try {
            return Integer.parseInt(n);
        } catch (Exception ex) {};
        return -1;
    }
    
    public static String getFileDir(HttpServletRequest request) {
        ServletContext ctx = request.getSession().getServletContext();
        String dir = ctx.getInitParameter("filedir");
        return ctx.getRealPath(dir);
    }
    
    public static String getImageDir(HttpServletRequest request) {
        return request.getSession().getServletContext().getInitParameter("imgdir");
    }
}
