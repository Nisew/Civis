package Database;

import Entities.Ayudante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
