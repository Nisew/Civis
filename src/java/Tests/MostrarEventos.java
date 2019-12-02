package Tests;

import Database.EventosDB;
import Entities.Evento;
import java.sql.SQLException;
import java.util.ArrayList;

public class MostrarEventos {
    public static void main(String[] args) {
        
        EventosDB eventDB = new EventosDB();
        
        ArrayList<Evento> listaeventos = new ArrayList<>();
        try {
            listaeventos = eventDB.mostrarEventos();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
        System.out.println(listaeventos);
    }
}
