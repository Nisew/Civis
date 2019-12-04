package Database;

import Entities.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosDB {

    Connection con;
    PreparedStatement ps;

    //Metodo para registrarse
    public void registroUsuario(Usuario u) throws SQLException {

        //Primero me aseguro de que no exista el usuario que quiero registrar
        con = ConnectionDB.conexion();
        boolean existe = false;
        ps = con.prepareStatement("SELECT usuario FROM usuarios");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            if (u.getUsuario().equals(rs.getString("usuario"))) {
                existe = true;
                System.out.println("El usuario que quiere ingresar ya existe");
            }   
        }
        
        ps.clearBatch();
        ps.clearParameters();
        ps.clearWarnings();
        ps.close();

        //Si no existe inserto el nuevo usuario
        if (!existe) {

            ps = con.prepareStatement(
                    "INSERT INTO usuarios (usuario, contrasenya, nombre, "
                    + "apellidos, fecha_nacimiento, telefono, correo) "
                    + "VALUES (?,?,?,?,?,?,?)");

            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getContrasenya());
            ps.setString(3, u.getNombre());
            ps.setString(4, u.getApellidos());
            ps.setDate(5, Date.valueOf(u.getFechaNacimiento()));
            ps.setString(6, u.getTelefono());
            ps.setString(7, u.getCorreo());

            ps.executeUpdate();
        }

        ps.close();
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

        //Consultamos si el usuario existe y si la contrasenya es correcta
        if (rs.first()) {
            if (pass.equals(rs.getString("contrasenya"))) {
                logueado = true;
            }    
        }
        //Si la contrasenya esta mal o el usuario no existe, devuelve false
        ps.close();
        con.close();
        return logueado;
    }

    //Metodo para mostrar perfil de un usuario
    public Usuario verUsuario(String usuario) throws SQLException {
        con = ConnectionDB.conexion();
        Usuario u = new Usuario();

        ps = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ?");
        ps.setString(1, usuario);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            u.setId_usuario(rs.getInt("id_usuario"));
            u.setUsuario(rs.getString("usuario"));
            u.setContrasenya(rs.getString("contrasenya"));
            u.setNombre(rs.getString("nombre"));
            u.setApellidos(rs.getString("apellidos"));
            u.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            u.setTelefono(rs.getString("telefono"));
            u.setCorreo(rs.getString("correo"));
        }

        ps.close();
        con.close();
        return u;
    }
    
    //Metodo para mostrar perfil de un usuario
    public Usuario verUsuarioId(int id) throws SQLException {
        con = ConnectionDB.conexion();
        Usuario u = new Usuario();

        ps = con.prepareStatement("SELECT * FROM usuarios WHERE id_usuario = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            u.setId_usuario(rs.getInt("id_usuario"));
            u.setUsuario(rs.getString("usuario"));
            u.setContrasenya(rs.getString("contrasenya"));
            u.setNombre(rs.getString("nombre"));
            u.setApellidos(rs.getString("apellidos"));
            u.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            u.setTelefono(rs.getString("telefono"));
            u.setCorreo(rs.getString("correo"));
        }

        ps.close();
        con.close();
        return u;
    }
}
