package Entities;

import java.sql.Date;

public class Usuario {

    private int id_usuario;
    private String usuario;
    private String contrasenya;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String telefono;
    private String correo;

    public Usuario() {
    }

    public Usuario(String pUsuario) {
        this.usuario = pUsuario;
    }

    public Usuario(String pUsuario, String pContrasenya) {
        this.usuario = pUsuario;
        this.contrasenya = pContrasenya;
    }

    public Usuario(int pId, String pUsuario) {
        this.id_usuario = pId;
        this.usuario = pUsuario;
    }

    public Usuario(int id_usuario, String usuario, String contrasenya, String nombre, String apellidos, String fechaNacimiento, String telefono, String correo) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Usuario(String usuario, String contrasenya, String nombre, String apellidos, String fechaNacimiento, String telefono, String correo) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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
        return "El id: " + id_usuario + ", con usuario: " + usuario
                + ", pass: " + contrasenya
                + ", " + nombre + ", " + apellidos
                + ", F.Nacimiento: " + fechaNacimiento
                + ", tel: " + telefono + ", correo: " + correo + "\n";
    }
}
