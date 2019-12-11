package Entities;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Evento {

    //Atributos
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
    private String usuarioCreador;

    //Constructores
    public Evento() {
    }

    public Evento(String pTitulo) {
        this.titulo = pTitulo;
    }

    public Evento(String titulo, String ubicacion,
            String hora_registro, String fecha_registro, String hora_evento,
            String fecha_evento, String descripcion, int num_ayudante, int id_creador) {
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

    public Evento(int id_evento, String titulo, String ubicacion,
            String hora_registro, String fecha_registro, String hora_evento,
            String fecha_evento, String descripcion, int num_ayudante, int id_creador) {
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

    public Evento(int id_creador, int id_evento, String titulo,
            String descripcion, String ubicacion, String fecha_evento,
            String hora_evento, boolean aceptado, boolean confirmado,
            String fecha_registro, String hora_registro, int num_ayudante) {
        this.id_creador = id_creador;
        this.id_evento = id_evento;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.fecha_evento = fecha_evento;
        this.hora_evento = hora_evento;
        this.aceptado = aceptado;
        this.confirmado = confirmado;
        this.fecha_registro = fecha_registro;
        this.hora_registro = hora_registro;
        this.num_ayudante = num_ayudante;
    }

    public Evento(int id_creador, String usuarioCreador, int id_evento, String titulo,
            String descripcion, String ubicacion, String fecha_evento,
            String hora_evento, boolean aceptado, boolean confirmado,
            String fecha_registro, String hora_registro, int num_ayudante) {
        this.id_creador = id_creador;
        this.usuarioCreador = usuarioCreador;
        this.id_evento = id_evento;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.fecha_evento = fecha_evento;
        this.hora_evento = hora_evento;
        this.aceptado = aceptado;
        this.confirmado = confirmado;
        this.fecha_registro = fecha_registro;
        this.hora_registro = hora_registro;
        this.num_ayudante = num_ayudante;
    }

    //Getter y Setter
    public int getId_evento() {
        return id_evento;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
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

    public void setHora_registro(String hora_registro) {
        this.hora_registro = hora_registro;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
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

    public int getId_creador() {
        return id_creador;
    }

    public void setId_creador(int id_creador) {
        this.id_creador = id_creador;
    }

    @Override
    public String toString() {
        return "El evento: " + titulo + ", con id: " + id_evento + ", " + descripcion + ", en " + ubicacion
                + " el dia: " + fecha_evento + ", a las: " + hora_evento + ", necesita " + num_ayudante + " ayudante."
                + "\nEl evento fue creado el dia: " + fecha_registro + ", a las " + hora_registro
                + " , por: " + usuarioCreador + " , id:" + id_creador + ". El evento se encuentra aceptado: " + aceptado
                + " y confirmado: " + confirmado + "\n\n";
    }

    //Metodos
    public static String horaActual() {

        DateFormat horaFormato = new SimpleDateFormat("HH:mm:ss");
        String horaActual = horaFormato.format(new Date());
        return horaActual;
    }

    public static String fechaActual() {

        DateFormat horaFormato = new SimpleDateFormat("YYYY-MM-dd");
        String fechaActual = horaFormato.format(new Date());
        return fechaActual;
    }

}
