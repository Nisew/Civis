package Database;

import Entities.Evento;
import Entities.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuariosDB {
 
    Connection con;
    PreparedStatement ps;
    
    //Metodo para registrarse
    public void registroUsuario(Usuario u) throws SQLException {
    
        boolean existe = false;
        con = ConnectionDB.conexion();
        
        String sqlInsert = "INSERT INTO usuarios (usuario, contrasenya, nombre, "
                + "apellidos, fecha_nacimiento, telefono, correo) "
                + "VALUES (?,?,?,?,?,?,?)";
        
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
            ps1.setString(2, u.getContrasenya());
            ps1.setString(3, u.getNombre());
            ps1.setString(4, u.getApellidos());
            ps1.setDate(5, Date.valueOf(u.getFechaNacimiento()));
            ps1.setString(6, u.getTelefono());
            ps1.setString(7, u.getCorreo());
        
            ps1.executeUpdate();
        }
        
        ps1.close();
        ps2.close();
        con.close();
    }
    
    //Metodo para iniciar sesion
    public boolean inicioSesion(String user, String pass) throws SQLException {
        Usuario usuarioLogin = new Usuario();
        
        con = ConnectionDB.conexion();
        boolean logueado = false;
        
        ps = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ?");
        ps.setString(1, user);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.first()) {
            if (pass.equals(rs.getString("contrasenya"))) {                
               /* 
                usuarioLogin.setUsuario(rs.getString("usuario"));
                usuarioLogin.setContrasenya(rs.getString("contrasenya"));
                usuarioLogin.setNombre(rs.getString("nombre"));
                usuarioLogin.setApellidos(rs.getString("apellidos"));
                usuarioLogin.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                usuarioLogin.setTelefono(rs.getString("telefono"));
                usuarioLogin.setCorreo(rs.getString("correo"));
                */
                
                logueado = true;
            }
            //ERROR - CONTRASEÑA NO CORRECTA
        }
        ps.close();
        con.close();
        return logueado;
    }
    
    //Metodo para mostrar perfil de un usuario
    public void verUsuario(Usuario u) throws SQLException {
        con = ConnectionDB.conexion();
        
        ps = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ?");
        ps.setString(1, u.getUsuario());
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            u.setId_usuario(rs.getInt("id_usuario"));
            u.setUsuario(rs.getString("usuario"));
            u.setContrasenya(rs.getString("contrasenya"));
            u.setNombre(rs.getString("nombre"));
            u.setApellidos(rs.getString("apellidos"));
            u.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            u.setTelefono(rs.getString("telefono"));
            u.setCorreo(rs.getString("correo"));
        }
        System.out.println("" + u);
        
        ps.close();
        con.close();
    } 
}
