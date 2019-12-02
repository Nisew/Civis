package Test.UsuariosDB;

import Database.UsuariosDB;
import java.sql.SQLException;

public class VerUsuario {
    public static void main(String[] args) {
        
        UsuariosDB usuaDB = new UsuariosDB();
        try {
            System.out.println(usuaDB.verUsuario("Anthony69"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }
}
