package Entities;

import java.sql.Date;
import java.sql.Time;

public class Evento {
    
    private int id_evento;
    private String titulo;
    private String ubicacion;
    private Time hora_registro;
    private Date fecha_registro;
    private Time hora_evento;
    private Date fecha_evento;
    private String descripcion;
    private int num_ayudante;
    private boolean inscrito;
    private boolean aceptado;
    private boolean confirmado;
    private int id_necesitado;

    public Evento () {    
    }
    
    public Evento (int id_evento, String titulo, String ubicacion, Time hora_registro, Date fecha_registro, Time hora_evento, Date fecha_evento, String descripcion, int num_ayudante, boolean inscrito, boolean aceptado, boolean confirmado, int id_necesitado) {
        this.id_evento = id_evento;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.hora_registro = hora_registro;
        this.fecha_registro = fecha_registro;
        this.hora_evento = hora_evento;
        this.fecha_evento = fecha_evento;
        this.descripcion = descripcion;
        this.num_ayudante = num_ayudante;
        this.inscrito = inscrito;
        this.aceptado = aceptado;
        this.confirmado = confirmado;
        this.id_necesitado = id_necesitado;
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

    public Time getHora_registro() {
        return hora_registro;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public Time getHora_evento() {
        return hora_evento;
    }

    public void setHora_evento(Time hora_evento) {
        this.hora_evento = hora_evento;
    }

    public Date getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(Date fecha_evento) {
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

    public boolean isInscrito() {
        return inscrito;
    }

    public void setInscrito(boolean inscrito) {
        this.inscrito = inscrito;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public int getId_necesitado() {
        return id_necesitado;
    }

    public void setId_necesitado(int id_necesitado) {
        this.id_necesitado = id_necesitado;
    }
  
}
