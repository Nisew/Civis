package Tests;

import Database.EventosDB;
import java.sql.SQLException;

public class MostrarEventos {
    public static void main(String[] args) {
        
        EventosDB eventDB = new EventosDB();
        try {
            System.out.println(eventDB.mostrarEventos());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }
}
