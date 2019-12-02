package Test.AyudanteDB;

import Database.AyudantesDB;
import Entities.Ayudante;
import java.sql.SQLException;

public class InscribirAyudante {

    public static void main(String[] args) {
        Ayudante ayudante = new Ayudante(4, 49, false, false);

        AyudantesDB ayudanteDB = new AyudantesDB();
        try {
            ayudanteDB.inscribirAyudante(ayudante);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
