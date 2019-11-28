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
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventosDB {
    
    Connection con;
    
    //Metodo para crear un evento
    public boolean crearEvento(Evento e) throws SQLException {
        
        boolean existe = false;
        con = ConnectionDB.conexion();
                
        PreparedStatement ps = con.prepareStatement("INSERT INTO eventos (titulo,ubicacion,hora_registro,fecha_registro, hora_evento, fecha_evento, descripcion, num_ayudante,id_creador) VALUES(?,?,?,?,?,?,?,?,?)");
            
        
        String fe = "2013-09-04";
        
            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getUbicacion());
            ps.setTime(3, Time.valueOf(e.getHora_registro()));
            ps.setDate(4, Date.valueOf(fe));
            ps.setTime(5, Time.valueOf(e.getHora_evento()));
            ps.setDate(6,  Date.valueOf(fe));
            ps.setString(7, e.getDescripcion());
            ps.setInt(8, e.getNum_ayudante()); 
            ps.setInt(9, e.getId_creador());
            ps.executeUpdate();
            existe= true;
    
        return existe;
    }
    
    //Metodo para ver los eventos a los que estas escritos
    public ArrayList<Evento> mostrarEventosInscritos(Usuario u) throws SQLException {
        
        ArrayList<Evento> eventos = new ArrayList<>();
        
        String sql = "SELECT * FROM eventos e JOIN ayudantes a ON a.id_evento = e.id_evento "
                + "WHERE a.id_usuario = ? AND e.id_creador = a.id_usuario ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, u.getId_usuario());
        
        ResultSet rs = ps.executeQuery();
        
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
        return eventos;
    }
    
    public static void main(String[] args){
        
        Evento e = new Evento(1,"Dar de comer a perros ", "Calle falsa 123","iras a pasear m perro pendejo ", 2,1);
        
        EventosDB p = new EventosDB();
        
        try {
            if(p.crearEvento(e)){
                System.out.println("se creo");
            }else
                System.out.println("valiste");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
  
        
        
    }
}
