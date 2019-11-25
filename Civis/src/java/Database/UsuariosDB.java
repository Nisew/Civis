package Database;

import Entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosDB {
 
    Connection con;
    
    public boolean addUsuario(Usuario u) throws SQLException {
    
        boolean existe = false;
        
        String sqlInsert = "INSERT INTO usuarios (usuario, contrasenya, nombre, apellidos, fecha_nacimiento, telefono, correo) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps1 = con.prepareStatement(sqlInsert);
        
        String sqlSelect = "SELECT usuario FROM usuarios";
        PreparedStatement ps2 = con.prepareStatement(sqlSelect);
        
        ResultSet rs = ps2.executeQuery();
        
        while (rs.next()) {            
            if (u.getUsuario().equals(rs.getString("usuario"))) {
                existe = true;
            }
        }
        
        if (!existe) {
            ps1.setString(1, u.getUsuario());
            ps1.setString(2, u.getPasswd());
            ps1.setString(3, u.getNombre());
            ps1.setString(4, u.getApellidos());
            ps1.setDate(5, u.getFechaNacimiento());
            ps1.setInt(6, u.getTelefono());
            ps1.setString(7, u.getCorreo());
        
            ps1.executeUpdate();
        }
        return existe;
    }
    
    public void startSession(String usuario, String contrasenya) throws SQLException {
        
        String sql = "SELECT usuario, contrasenya FROM usuarios";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        
        if (usuario.equals(rs.getString("usuario")) && contrasenya.equals(rs.getString("contrasenya"))) {
            
        }
        
    }
}
