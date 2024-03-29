package Entities;

public class Ayudante {
    
    //Atributos
    private String usuario;
    private int id_usuario;
    private int id_evento;
    private boolean aceptado;
    private boolean confirmado;
    
    //Constructores
    public Ayudante(){
        this.aceptado= false;
        this.confirmado= false;
    }
    
    
    public Ayudante(String usuario, int id_evento){
        this.usuario = usuario;
        this.id_evento = id_evento;
    }
    
    public Ayudante(int id_usuario, int id_evento) {
        this.id_usuario = id_usuario;
        this.id_evento = id_evento;
        this.aceptado = false;
        this.confirmado = false;
    }
    
    public Ayudante(int id_usuario, String usuario, int id_evento){
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.id_evento = id_evento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Ayudante(int id_usuario, int id_evento, boolean aceptado, boolean confirmado) {
        this.id_usuario = id_usuario;
        this.id_evento = id_evento;
        this.aceptado = aceptado;
        this.confirmado = confirmado;
    }

    //Getter y Setter
    public boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public boolean getAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

   
}
