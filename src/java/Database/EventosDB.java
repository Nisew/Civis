package Database;

import Entities.Evento;
import Entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventosDB {
    
    Connection con;
    
    //Metodo para crear un evento
    public boolean crearEvento(Evento e) throws SQLException {
        
        boolean existe = false;
        con = ConnectionDB.conexion();
                
        PreparedStatement ps = con.prepareStatement("INSERT INTO eventos (titulo,ubicacion,hora_registro,fecha_registro, hora_evento, fecha_evento, descripcion, num_ayudante,id_creador) VALUES(?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getUbicacion());
            ps.setTime(3, Time.valueOf(e.getHora_registro()));
            ps.setDate(4, Date.valueOf(e.getFecha_registro()));
            ps.setTime(5, Time.valueOf(e.getHora_evento()));
            ps.setDate(6,  Date.valueOf(e.getFecha_evento()));
            ps.setString(7, e.getDescripcion());
            ps.setInt(8, e.getNum_ayudante()); 
            ps.setInt(9, 1);
           
            existe= true;      
            ps.executeUpdate();
        return existe;
    }
    
    //Metodo para ver los eventos a los que estas escritos
    public ArrayList<Evento> mostrarEventosInscritos(Usuario u) throws SQLException {
        
        ArrayList<Evento> eventos = new ArrayList<>();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM eventos e JOIN ayudantes a ON a.id_evento = e.id_evento + WHERE a.id_usuario = ? AND e.id_creador = a.id_usuario ");
        ps.setInt(1, u.getId_usuario());
        
        ResultSet rs = ps.executeQuery();
        /*
        while (rs.next()) {            
            if (u.getId_usuario() == rs.getInt("a.id_usuario")) {
                eventos.add(new Evento(
                        rs.getInt("id_usuario"),
                        rs.getString("titulo"),
                        rs.getString("ubicacion"),
                        rs.getString("hora_registro"),
                        rs.getString("fecha_registro"),
                        rs.getString("hora_evento"),
                        rs.getString("fecha_evento"),
                        rs.getString("descripcion"),
                        rs.getInt("num_ayudantes"),
                        rs.getBoolean("inscrito"),
                        rs.getBoolean("aceptado"),
                        rs.getBoolean("confirmado"),
                        rs.getInt("id_creador")));
            }
        }
        */
        return eventos;
    }
    
    /*PROBAR METODOS.
    public static void main(String[] args) {
        
        Evento evento1 = new Evento();
        
        SimpleDateFormat formatoHora = new SimpleDateFormat("yyyy-MM-dd");
        String fecha= formatoHora.format(12-05-2010);
        
        evento1.setTitulo("SAlir");
        evento1.setHora_evento("10:20:30");
        evento1.setFecha_evento(fecha);
        
        EventosDB b1 = new EventosDB();
        
        System.out.println(Evento.horaActual());
        System.out.println(evento1.getFecha_registro());
        
        
       
        try {
            b1.crearEvento(evento1);
            System.out.println("bien");
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        
    }
    */
    
    
    
}
