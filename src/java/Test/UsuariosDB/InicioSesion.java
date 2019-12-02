package Test.UsuariosDB;

import Database.UsuariosDB;
import java.sql.SQLException;

public class InicioSesion {
    public static void main(String[] args) {
        
        UsuariosDB usuaDB = new UsuariosDB();
        try {
            System.out.println(usuaDB.inicioSesion("Anthony69","1234"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }
}
