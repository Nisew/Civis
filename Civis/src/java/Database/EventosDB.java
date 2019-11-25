package Database;

import Entities.Evento;
import Entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventosDB {
    
    Connection con;
    
    public boolean crearEvento(Evento e) throws SQLException {
        
        boolean existe = false;
        
        String sql = "INSERT INTO eventos(titulo, ubicacion, hora_registro, fecha_registro, "
                + "hora_evento, fecha_evento, descripcion, num_ayudante, id_creador) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {            
            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getUbicacion());
            ps.setTime(3, e.getHora_registro());
            ps.setDate(4, e.getFecha_registro());
            ps.setTime(5, e.getHora_evento());
            ps.setDate(6, e.getFecha_evento());
            ps.setString(7, e.getDescripcion());
            ps.setInt(8, e.getNum_ayudante());
            ps.setInt(9, e.getId_creador());
                    
            ps.executeUpdate();
        }
        return existe;
    }
    
    public ArrayList<Evento> mostrarEventosInscritos(Usuario u) throws SQLException {
        
        ArrayList<Evento> eventos = new ArrayList<>();
        
        String sql = "SELECT * FROM eventos e JOIN ayudantes a ON a.id_evento = e.id_evento "
                + "WHERE a.id_usuario = ? AND e.id_creador = a.id_usuario ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, u.getId_usuario());
        
        ResultSet rs = ps.executeQuery();
        
        return eventos;
    }
}
