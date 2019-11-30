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
    PreparedStatement ps;
    
    //Metodo para crear un evento
    public boolean crearEvento(Evento e) throws SQLException {
        
        boolean existe = false;
        con = ConnectionDB.conexion();
                
         ps = con.prepareStatement("INSERT INTO eventos (titulo,ubicacion,hora_registro,fecha_registro, hora_evento, fecha_evento, descripcion, num_ayudante,id_creador) VALUES(?,?,?,?,?,?,?,?,?)");
            
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
            ps.close();
        return existe;
    }
    
    //Metodo para ver los eventos a los que estas escritos
    public ArrayList<Evento> mostrarEventosInscritos(Usuario u) throws SQLException {
        con = ConnectionDB.conexion();
        ArrayList<Evento> eventos = new ArrayList<>();
        ResultSet rs= null;
        
        ps = con.prepareStatement("SELECT * FROM eventos e JOIN ayudantes a ON a.id_evento = e.id_evento WHERE a.id_usuario = ? AND e.id_creador = a.id_usuario");
        ps.setInt(1, u.getId_usuario());
        
        rs = ps.executeQuery();
        
        while (rs.next()) {            
                         eventos.add(new Evento(
                        rs.getInt("id_evento"),
                        rs.getString("titulo"),
                        rs.getString("ubicacion"),
                        rs.getString("hora_registro"),
                        rs.getString("fecha_registro"),
                        rs.getString("hora_evento"),
                        rs.getString("fecha_evento"),
                        rs.getString("descripcion"),
                        rs.getInt("num_ayudante"),
                        rs.getInt("id_creador")));
            }
        ps.close();
        return eventos;
    }
    
//   //PROBANDO EL METODO LISTAR EVENTOS
//    public static void main(String[] args) {
//        
//        
//        
//        EventosDB b1 = new EventosDB();
//        Usuario u = new Usuario();
//        u.setId_usuario(1);
//        
//        try {
//           ArrayList<Evento> eventos = b1.mostrarEventosInscritos(u);
//           
//           for(int i=0;i<eventos.size();i++){
//                
//               System.out.println(eventos.get(i));
//           }
//          
//        } catch (SQLException ex) {
//         
//            ex.printStackTrace();
//        }
//        
//        
//    }

    
    
    
}
