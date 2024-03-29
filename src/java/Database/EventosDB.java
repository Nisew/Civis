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

public class EventosDB {

    Connection con;
    PreparedStatement ps;

    //Metodo para crear un evento
    public boolean crearEvento(Evento e) throws SQLException {

        boolean existe = false;
        con = ConnectionDB.conexion();

        ps = con.prepareStatement(
                "INSERT INTO eventos (titulo,ubicacion,hora_registro,fecha_registro, "
                + "hora_evento, fecha_evento, descripcion, num_ayudante,id_creador) "
                + "VALUES(?,?,?,?,?,?,?,?,?)");

        ps.setString(1, e.getTitulo());
        ps.setString(2, e.getUbicacion());
        ps.setTime(3, Time.valueOf(e.getHora_registro()));
        ps.setDate(4, Date.valueOf(e.getFecha_registro()));
        ps.setTime(5, Time.valueOf(e.getHora_evento()));
        ps.setDate(6, Date.valueOf(e.getFecha_evento()));
        ps.setString(7, e.getDescripcion());
        ps.setInt(8, e.getNum_ayudante());
        ps.setInt(9, e.getId_creador());

        existe = true;
        ps.executeUpdate();
        ps.close();
        con.close();
        return existe;
    }

    //Metodo para ver todos los eventos
    public ArrayList<Evento> mostrarEventos() throws SQLException {
        con = ConnectionDB.conexion();

        ArrayList<Evento> eventos = new ArrayList<>();

        ps = con.prepareStatement("SELECT * FROM eventos");

        ResultSet rs = ps.executeQuery();

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
        con.close();
        return eventos;
    }

    //Metodo para ver todos los eventos a los que un usuario esta inscrito
    public ArrayList<Evento> verEstadoInscripcion(Usuario u) throws SQLException {
        con = ConnectionDB.conexion();

        ArrayList<Evento> eventos = new ArrayList<>();

        ps = con.prepareStatement(
                "SELECT e.id_creador, usuario, e.id_evento, titulo, descripcion, ubicacion, fecha_evento, "
                + "hora_evento, aceptado, confirmado, hora_registro, fecha_registro, num_ayudante "
                + "FROM ayudantes a "
                + "JOIN eventos e ON a.id_evento = e.id_evento "
                + "JOIN usuarios u ON u.id_usuario = e.id_creador "
                + "WHERE a.id_usuario = ?");

        ps.setInt(1, u.getId_usuario());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            eventos.add(new Evento(
                    rs.getInt("id_creador"),
                    rs.getString("usuario"),
                    rs.getInt("id_evento"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("ubicacion"),
                    rs.getString("fecha_evento"),
                    rs.getString("hora_evento"),
                    rs.getBoolean("aceptado"),
                    rs.getBoolean("confirmado"),
                    rs.getString("fecha_registro"),
                    rs.getString("hora_registro"),
                    rs.getInt("num_ayudante")));
        }
        ps.close();
        con.close();
        return eventos;
    }

    //Metodo para listar todos los eventos que un usuario ha creado
    public ArrayList<Evento> listarEventosPropios(Usuario u) throws SQLException {
        con = ConnectionDB.conexion();

        ArrayList<Evento> eventos = new ArrayList<>();

        ps = con.prepareStatement("SELECT * FROM eventos WHERE id_creador = ?");
        ps.setInt(1, u.getId_usuario());

        ResultSet rs = ps.executeQuery();

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
        con.close();
        return eventos;
    }
}
