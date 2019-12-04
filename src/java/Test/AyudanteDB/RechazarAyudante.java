package Test.AyudanteDB;

import Database.AyudantesDB;
import Entities.Ayudante;
import java.sql.SQLException;

public class RechazarAyudante {

    public static void main(String[] args) {
        
        Ayudante ayudante = new Ayudante(1, 1, false, false);

        AyudantesDB ayudanteDB = new AyudantesDB();
        try {
            ayudanteDB.rechazarAyudante(ayudante);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
