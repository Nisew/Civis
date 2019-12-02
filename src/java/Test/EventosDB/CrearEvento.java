package Test.EventosDB;

import Database.EventosDB;
import Entities.Evento;
import java.sql.SQLException;

public class CrearEvento {
    public static void main(String[] args) {
        
        Evento evento = new Evento("Mudanza", "Barcelona Centro", "10:00:00", 
                "2019-11-30", "08:00:00", "2019-12-01", "Necesito subir sofa 3 pisos", 2, 3);
      
        EventosDB eventDB = new EventosDB();
        try {
            System.out.println(eventDB.crearEvento(evento));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }
}
