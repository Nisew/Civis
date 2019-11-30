package Entities;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class Evento {
    
    private int id_evento;
    private String titulo;
    private String ubicacion;
    private String hora_registro;
    private String fecha_registro;
    private String hora_evento;
    private String fecha_evento;
    private String descripcion;
    private int num_ayudante;
    private boolean aceptado;
    private boolean confirmado;
    private int id_creador;

    public Evento () {
        
    }
    
    public Evento (String pTitulo) {
        this.titulo = pTitulo;
    }
    
    public Evento (int pId, String pTitulo){
        this.id_evento = pId;
        this.titulo = pTitulo;
    }

    public Evento(String titulo, String ubicacion, String hora_evento, String fecha_evento, String descripcion, int num_ayudante) {
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.hora_registro = horaActual();
        this.fecha_registro= fechaActual();
        this.hora_evento = hora_evento;
        this.fecha_evento = fecha_evento;
        this.descripcion = descripcion;
        this.num_ayudante = num_ayudante;
        this.id_creador = 1;
    }
    
    public Evento(int id_evento, String titulo, String ubicacion, String hora_registro, String fecha_registro, String hora_evento, String fecha_evento, String descripcion, int num_ayudante, int id_creador) {
        this.id_evento = id_evento;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.hora_registro = hora_registro;
        this.fecha_registro = fecha_registro;
        this.hora_evento = hora_evento;
        this.fecha_evento = fecha_evento;
        this.descripcion = descripcion;
        this.num_ayudante = num_ayudante;
        this.id_creador = id_creador;
    }
    public Evento(String titulo, String ubicacion, String hora_registro, String fecha_registro, String hora_evento, String fecha_evento, String descripcion, int num_ayudante, int id_creador) {
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.hora_registro = hora_registro;
        this.fecha_registro = fecha_registro;
        this.hora_evento = hora_evento;
        this.fecha_evento = fecha_evento;
        this.descripcion = descripcion;
        this.num_ayudante = num_ayudante;
        this.id_creador = id_creador;
    }
    
    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHora_registro() {
        return hora_registro;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public String getHora_evento() {
        return hora_evento;
    }

    public void setHora_evento(String hora_evento) {
        this.hora_evento = hora_evento;
    }

    public String getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(String fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNum_ayudante() {
        return num_ayudante;
    }

    public void setNum_ayudante(int num_ayudante) {
        this.num_ayudante = num_ayudante;
    }

  

    public int getId_creador() {
        return id_creador;
    }

    public void setId_creador(int id_creador) {
        this.id_creador = id_creador;
    }

    @Override
    public String toString() {
        return "Evento{" + "titulo=" + titulo + ", ubicacion=" + ubicacion + ", hora_registro=" + hora_registro + ", fecha_registro=" + fecha_registro + ", hora_evento=" + hora_evento + ", fecha_evento=" + fecha_evento + ", descripcion=" + descripcion + ", num_ayudante=" + num_ayudante + ", id_creador=" + id_creador + '}';
    }

  
    
    public static String horaActual(){
        

    DateFormat horaFormato = new SimpleDateFormat("HH:mm:ss");
    
    String horaActual = horaFormato.format(new Date());
    
        
        return horaActual;
    }
    

    public static String fechaActual(){
       
    DateFormat horaFormato = new SimpleDateFormat("YYYY-MM-dd");
    String fechaActual = horaFormato.format(new Date());
    return fechaActual;
    }
  
}
