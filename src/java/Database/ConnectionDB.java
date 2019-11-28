package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    
    public static final String URL = "jdbc:mysql://localhost:3306/voluntariobd?useSSL=false&serverTimezone=UTC";
    public static final String usuario = "root";
    public static final String contraseña = "root";

    public static Connection conexion() {

        try {
  
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, usuario, contraseña);
            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
