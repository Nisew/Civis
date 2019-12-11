<%@page import="java.sql.SQLException"%>
<%@page import="Database.EventosDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Evento"%>
<%@page import="Database.UsuariosDB"%>
<%@page import="Entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    Usuario creador = new Usuario();
    UsuariosDB creadorDB = new UsuariosDB();
    EventosDB eventosDB = new EventosDB();
    ArrayList<Evento> eventos = new ArrayList<Evento>();

    String nombreUs = "";
    try {
        Cookie cookie[] = request.getCookies();

        for (Cookie c : cookie) {
            if (c.getName().equals("uName")) {
                nombreUs = c.getValue();
            }
        }

        Usuario userEventosPropios = creadorDB.verUsuario(nombreUs);
        eventos = eventosDB.listarEventosPropios(userEventosPropios);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <title>CIVIS</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="./styles/estilosNavBar.css">
        <link rel="stylesheet" href="./styles/estilosCarta.css">
        <link rel="stylesheet" href="./styles/estilosFormEvento.css">
        <link rel="stylesheet" href="./cssfonts/css/all.css">
    </head>
    <body>

        <!-- Inicio NavBar -->
        <jsp:include flush="true" page="navbarlogged.jsp"></jsp:include>

            <!-- Final NavBar -->

            <!-- Inicio visualizaciÃ³n eventos -->
            <div class="row">

                <div class="col-md-2"></div>

                <div class="col-md-8">
                <% for (Evento evento : eventos) { %>
                <div class="blog-card">
                    <div class="meta">
                        <div class="photo" style="background-image: url(./img/panoramic-bcn.jpg)"></div>
                        <ul class="details">
                            <li class="author"><%out.println(evento.getUbicacion());%></li>
                            <br>
                            <li class="author"><%out.println(evento.getNum_ayudante());%> Personas</li>
                            <br>
                            <li class="author"><%out.println(evento.getFecha_evento());%></li>
                            <br>
                            <li class="author"><%out.println(evento.getHora_evento());%></li>
                        </ul>
                    </div>
                    <div class="description">
                        <h1><%out.println(evento.getTitulo());%></h1>
                        <br><br>

                        <p></p>
                        <a href="ayudante?sa=listInscritos">
                            <div class="recuadroNombres">
                                <i class="fas fa-users">INSCRITOS</i>
                                <button type="button" class="btn btn-accept">
                                    <!-- <i class="fas fa-check"></i> -->
                                    A
                                </button>
                                <button type="button" class="btn btn-discard ">
                                    <!-- <i class="fas fa-times"></i> -->
                                    R
                                </button>
                                <br>
                            </div>
                        </a>
                    </div>
                </div>
                <%}%>
            </div>

            <div class="col-md-2"></div>

        </div>
        <!-- Fin visualizaciÃ³n eventos -->

    </body>
</html>
