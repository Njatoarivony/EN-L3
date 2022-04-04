
package univ;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Conn {
    
    private static String servername = "localhost";
    private static String dbname = "login";
    private static String username ="root";
    private static Integer portnumber=3306;        
    private static String password ="";   //no password
    
    
    // create a function to get the connection
    public static Connection getTheConnection(){
    Connection connection = null;
    MysqlDataSource datasource = new MysqlDataSource();
    
    datasource.setServerName(servername);
    datasource.setUser(username);
    datasource.setDatabaseName(dbname);
    datasource.setPortNumber(portnumber);
    datasource.setPassword(password);
    
        try {
            connection = (Connection) datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
    return connection;
    }
}
