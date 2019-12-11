package Test.AyudanteDB;

import Database.AyudantesDB;
import Entities.Ayudante;
import java.sql.SQLException;

public class AceptarAyuda {

    public static void main(String[] args) {

        int usuarioArechazar = 1;
        int eventoArechazar = 1;

        Ayudante ayudRec = new Ayudante();
        AyudantesDB recDB = new AyudantesDB();

        try {
            ayudRec = recDB.verAyudante(usuarioArechazar, eventoArechazar);
            recDB.rechazarAyuda(ayudRec);
            
            System.out.println(ayudRec.getAceptado());
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
