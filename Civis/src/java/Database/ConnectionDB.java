package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    
    Connection conn;
    
    public void openConnection() throws SQLException, ClassNotFoundException{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/voluntariobd?serverTimezone=UTC&useSSL=false", "root", "root");
    }

    public void closeConnection() throws SQLException{
            conn.close();
    }
}
