package Test.AyudanteDB;

import Database.AyudantesDB;
import Database.UsuariosDB;
import Entities.Ayudante;
import Entities.Usuario;
import java.sql.SQLException;
import javax.servlet.http.Cookie;

public class ConfirmarAyudante {

    public static void main(String[] args) {
        AyudantesDB ayDB = new AyudantesDB();
                Ayudante ayconfirmar = new Ayudante();
                Usuario uaux2 = new Usuario();
                UsuariosDB usToAy2 = new UsuariosDB();
                String nombreAyu = "";
                try {
                  
                    uaux2 = usToAy2.verUsuario("Anthony69");
                    ayconfirmar.setId_usuario(uaux2.getId_usuario());
                    ayconfirmar.setId_evento(1);
                    ayDB.confirmarAyudante(ayconfirmar);
                } catch(SQLException ex){
                    ex.printStackTrace();
                }
        
    }
}
