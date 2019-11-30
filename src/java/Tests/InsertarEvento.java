package Tests;

import Database.EventosDB;
import Entities.Evento;
import Entities.Usuario;
import java.sql.SQLException;

public class InsertarEvento {
    public static void main(String[] args) {
        Evento evento1 = new Evento(48, "pasear rinoceronte", "zoo", "12:03:12", "2019-12-05", "12:32:00", "2019-12-06", "Mi rinoceronte tiene hambre", 5, 3);
        Usuario usuario1 = new Usuario(2, "Fresita98", "1234", "Manolo", "Garcia", "1999-01-01", "111111111", "f@gmail.com");
        
        EventosDB eventDB = new EventosDB();
        try {
            eventDB.inscribirEvento(evento1, usuario1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }
}
