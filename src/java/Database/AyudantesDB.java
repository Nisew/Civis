package Database;

import Entities.Ayudante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AyudantesDB {

    Connection con;
    PreparedStatement ps;

    //Metodo para inscribirs a un ayudante
    public void inscribirAyudante(Ayudante a) throws SQLException {

        con = ConnectionDB.conexion();

        ps = con.prepareStatement(
                "INSERT INTO ayudantes (id_usuario, id_evento, aceptado, confirmado) "
                + "VALUES (?, ?, ?, ?)");
        ps.setInt(1, a.getId_usuario());
        ps.setInt(2, a.getId_evento());
        ps.setBoolean(3, a.getAceptado());
        ps.setBoolean(4, a.getConfirmado());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    //CONFIRMAR AYUDANTE
    public void confirmarAyudante(Ayudante a) throws SQLException {

        con = ConnectionDB.conexion();

        ps = con.prepareStatement("UPDATE ayudantes SET confirmado = 1 WHERE id_usuario = ? and id_evento = ? ");
        ps.setInt(1, a.getId_usuario());
        ps.setInt(2, a.getId_evento());

        ps.executeUpdate();

        ps.close();
        con.close();

    }

    //RECHAZAR AYUDANTE
    public void rechazarAyudante(Ayudante a) throws SQLException {

        con = ConnectionDB.conexion();

        ps = con.prepareStatement("UPDATE ayudantes SET confirmado = 0 WHERE id_usuario = ? and id_evento = ? ");
        ps.setInt(1, a.getId_usuario());
        ps.setInt(2, a.getId_evento());

        ps.executeUpdate();

        ps.close();
        con.close();

    }

    //ACEPTAR AYUDA
    public void aceptarAyuda(Ayudante a) throws SQLException {

        con = ConnectionDB.conexion();

        ps = con.prepareStatement("UPDATE ayudantes SET aceptado = 1 WHERE id_usuario = ? and id_evento = ? ");
        ps.setInt(1, a.getId_usuario());
        ps.setInt(2, a.getId_evento());

        ps.executeUpdate();

        ps.close();
        con.close();

    }

    //Listar  nombres de usuarios inscritos a un evento
    public ArrayList<Ayudante> listInscritos(int id_evento) throws SQLException {
        con = ConnectionDB.conexion();

        ArrayList<Ayudante> listaAyudantes = new ArrayList<>();

        ps = con.prepareStatement("SELECT u.id_usuario, u.usuario as usuario, a.id_evento "
                + "FROM ayudantes a JOIN usuarios u "
                + "ON a.id_usuario = u.id_usuario "
                + "WHERE id_evento = ?");
        ps.setInt(1, id_evento);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            listaAyudantes.add(new Ayudante(
                    rs.getInt("id_usuario"),
                    rs.getString("usuario"),
                    rs.getInt("id_evento")));
        }
        ps.close();
        con.close();
        return listaAyudantes;

    }

    //Metodo para mostrar perfil de un ayudante
    public Ayudante verAyudante(int idUser, int idEvento) throws SQLException {
        con = ConnectionDB.conexion();

        Ayudante ay = new Ayudante();

        ps = con.prepareStatement("SELECT * FROM ayudantes WHERE id_usuario = ? AND id_evento = ?");
        ps.setInt(1, idUser);
        ps.setInt(2, idEvento);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ay.setId_usuario(rs.getInt("id_usuario"));
            ay.setId_evento(rs.getInt("id_evento"));
            ay.setAceptado(rs.getBoolean("aceptado"));
            ay.setConfirmado(rs.getBoolean("confirmado"));
        }

        ps.close();
        con.close();

        return ay;
    }
}
