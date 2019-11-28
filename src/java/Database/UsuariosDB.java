package Database;

import Entities.Evento;
import Entities.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UsuariosDB {
 
    Connection con;
    
    //Metodo para registrarse
    public boolean crearUsuario(Usuario u) throws SQLException {
    
        boolean existe = false;
        con = ConnectionDB.conexion();
        
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
            ps1.setString(2, u.getContrasenya());
            ps1.setString(3, u.getNombre());
            ps1.setString(4, u.getApellidos());
            ps1.setDate(5, u.getFechaNacimiento());
            ps1.setInt(6, u.getTelefono());
            ps1.setString(7, u.getCorreo());
        
            ps1.executeUpdate();
        }
        return existe;
    }
    
    //Metodo para iniciar sesion
    public boolean iniciarSesion(Usuario u) throws SQLException {
        
        boolean logueado = false;
        
        String sql = "SELECT usuario WHERE usuario = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, u.getUsuario());
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            if (u.getContrasenya().equals(rs.getString("contrasenya"))) {
                
                u.setUsuario(rs.getString("usuario"));
                u.setContrasenya(rs.getString("contrasenya"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                u.setTelefono(rs.getInt("telefono"));
                u.setCorreo(rs.getString("correo"));
                
                logueado = true;
            }
        }
        return logueado;
    }
    
    //Metodo para listar todos los eventos por nombre de usuario
    public ArrayList<Evento> listarEventos(Usuario u) throws SQLException {
        
        ArrayList<Evento> eventos = new ArrayList<>();
        
        String sql = "SELECT evento WHERE id_usuario = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, u.getId_usuario());
        
        ResultSet rs = ps.executeQuery();
        
        
//        while (rs.next()) {            
//            eventos.add(new Evento(
//                    rs.getInt("id_evento"),
//                    rs.getString("titulo"),
//                    rs.getString("ubicacion"),
//                    rs.getString("hora_resgistro"),
//                    rs.getString("fecha_registro"),
//                    rs.getString("hora_evento"),
//                    rs.getString("fecha_evento"),
//                    rs.getString("descripcion"),
//                    rs.getInt("num_ayudante"),
//                    rs.getBoolean("inscrito"),
//                    rs.getBoolean("aceptado"),
//                    rs.getBoolean("confirmado"),
//                    rs.getInt("id_creador")));
//        }
        return eventos;
    }  
    
    //Metodo para inscribirse en un evento
    public void inscribirEvento(Evento e,Usuario u) throws SQLException {
    
        String sql = "insert into ayudantes(id_usuario,id_evento) values(?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, u.getId_usuario());
        ps.setInt(2, e.getId_evento());
        
        ps.executeQuery();
    }
    
    //Metodo para ver el estado de la inscripcion a un evento
    public ArrayList<Evento> verEstadoInscripcion(Usuario u) throws SQLException {
    
        ArrayList<Evento> eventos = new ArrayList<>();
        //HACE FALTA HACER UN JOIN 
        //ID AYUDANTE = ID EVENTO
        String sql = "select * from ayudantes where id_usuario = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, u.getId_usuario());
        
        ResultSet rs = ps.executeQuery();
        
//         while (rs.next()) {            
//            eventos.add(new Evento(
//                    rs.getInt("id_evento"),
//                    rs.getString("titulo"),
//                    rs.getString("ubicacion"),
//                    rs.getString("hora_resgistro"),
//                    rs.getString("fecha_registro"),
//                    rs.getString("hora_evento"),
//                    rs.getString("fecha_evento"),
//                    rs.getString("descripcion"),
//                    rs.getInt("num_ayudante"),
//                    rs.getBoolean("inscrito"),
//                    rs.getBoolean("aceptado"),
//                    rs.getBoolean("confirmado"),
//                    rs.getInt("id_creador")));
//        }
        return eventos;        
    }
    
    //Metodo para mostrar perfil de un usuario
    public void verUsuario(Usuario u) throws SQLException {
        
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, u.getId_usuario());
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            rs.getInt("id_usuario");
            rs.getString("usuario");
            rs.getString("contrasenya");
            rs.getString("nombre");
            rs.getString("apellidos");
            rs.getDate("fecha_nacimiento");
            rs.getInt("telefono");
            rs.getString("correo");
        }        
    }
   // El main es un ejemplo de como ejecutar. 
    /*
    public static void main(String[] args) {
       
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        java.util.Date d = Date.valueOf("1993-05-18");
        java.sql.Date fecha = new java.sql.Date(d.getTime());
        Usuario usuario = new Usuario ("Mortadelo2", "4321", "Juan", "Magan", fecha, 971971971, "jm@gmail.com");
        
        UsuariosDB us = new UsuariosDB();
        
        try {
            if(us.crearUsuario(usuario)){
                System.out.println("se creo");
            }else
                System.out.println("valiste");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    } */
     
}
