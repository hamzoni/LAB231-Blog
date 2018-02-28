
package DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private DBConfig cf;
    
    public DBConnection() {
        try {
            DBConfig cf = new DBConfig();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlserver://" + cf.HOST + ":" + cf.PORT +  ";databaseName=" + cf.DBNAME,cf.USER, cf.PASSWORD);
    }
}