package Tests;

import Database.EventosDB;
import Entities.Usuario;
import java.sql.SQLException;

public class VerEstadoInscripcion {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario(1, "Fresita98", "1234", "Manolo", "Garcia", "1999-01-01", "111111111", "f@gmail.com");
        
        EventosDB eventDB = new EventosDB();
        try {
            System.out.println(eventDB.verEstadoInscripcion(usuario1));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }
}
