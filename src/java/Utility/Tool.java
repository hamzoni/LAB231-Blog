
package Utility;

import javax.servlet.http.HttpServletRequest;

public class Tool {
    public static int toInt(String n) {
        try {
            return Integer.parseInt(n);
        } catch (Exception ex) {};
        return -1;
    }
    
    public static String getImageDir(HttpServletRequest request) {
        return request.getSession().getServletContext().getInitParameter("imgdir");
    }
}
