<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Evento"%>
<%@page import="Database.EventosDB"%>
<%
    EventosDB listareventos = new EventosDB();
    ArrayList<Evento> listaEventos = new ArrayList<Evento>();

    try {
        listaEventos = listareventos.mostrarEventos();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
%>
<div class="row">

    <div class="col-md-2"></div>

    <div class="col-md-8">
        <% for (Evento evento : listaEventos) {
        %>

        <div class="blog-card">

            <div class="meta">
                <div class="photo" style="background-image: url(./img/panoramic-bcn.jpg)"></div>
                <ul class="details">

                    <br>
                    <li class="author"><%out.println(evento.getUbicacion());%></li>
                    <br>
                    <li class="author"><%out.println(evento.getNum_ayudante());%> personas</li>
                    <br>
                    <li class="author"><%out.println(evento.getFecha_evento());%></li>
                    <br>
                    <li class="author"><%out.println(evento.getHora_evento());%></li>

                </ul>
            </div>
            <div class="description">
                <h1><%out.println(evento.getTitulo());%></h1>
                <br><br>
                <h2>SOFIA CACERES MARTINEZ</h2>
                <br>
                <p><%out.println(evento.getDescripcion());%></p>
                <button type="button" class="btn btn-success">
                    INSCRIBIRME
                </button>

            </div>

        </div>

        <%}%>
    </div>

    <div class="col-md-2"></div>

</div>