
package ConexionBD;

/**
 *
 * @author moisibot
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static String URL = "jdbc:mysql://localhost:3306/biblioteca";

    public static String USER = "mav";
    public static String PASS = "zaxc";
    public static Connection conexion = null;
    
    public Conexion(){
    
    }
    
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion = DriverManager.getConnection(URL, USER, PASS);
          System.out.println("ci");
        } catch (SQLException ex) {
            System.err.println("error en conexion sql");
        } catch (ClassNotFoundException ex) {
            System.err.println("error en conexion calas name");

        }
        return conexion;

    }
    
    public void getCloseConexion(){
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
            }
            
        }
    }
}
    

