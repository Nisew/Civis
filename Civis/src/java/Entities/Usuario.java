package Entities;

import java.sql.Date;

public class Usuario {
 
    String usuario;
    String passwd;
    String nombre;
    String apellidos;
    Date fechaNacimiento;
    int telefono;
    String correo;

    public Usuario (String usuario, String passwd, String nombre, String apellidos, Date fechaNacimiento, int telefono, String correo) {
        this.usuario = usuario;
        this.passwd = passwd;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String corre) {
        this.correo = corre;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "usuario=" + usuario + ", passwd=" + passwd + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
}
