package Test.AyudanteDB;

import Database.AyudantesDB;
import Database.UsuariosDB;
import Entities.Ayudante;
import Entities.Usuario;
import java.sql.SQLException;
import javax.servlet.http.Cookie;

public class InscribirAyudante {

    public static void main(String[] args) {
        int id_evento_inscribir = 1;

        AyudantesDB ay_inscrito = new AyudantesDB();
        UsuariosDB usToAy = new UsuariosDB();
        Usuario uaux = new Usuario();
        Ayudante ayinscribir = new Ayudante();

        try {
            uaux = usToAy.verUsuario("Anthony69");
            ayinscribir.setId_usuario(uaux.getId_usuario());
            ayinscribir.setId_evento(id_evento_inscribir);
            ay_inscrito.inscribirAyudante(ayinscribir);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
