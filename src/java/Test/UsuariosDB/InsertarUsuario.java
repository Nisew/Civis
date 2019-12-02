package Test.UsuariosDB;

import Database.UsuariosDB;
import Entities.Usuario;
import java.sql.SQLException;

public class InsertarUsuario {

    public static void main(String[] args) {
        Usuario usuario = new Usuario(
                "PoolParty", "123456789", "Diego", "Maradona", "1980-04-04", "111111111", "DArmando@gmail.com");

        UsuariosDB usuaDB = new UsuariosDB();
        try {
            usuaDB.registroUsuario(usuario);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
