<%@page import="Database.AyudantesDB"%>
<%@page import="Entities.Ayudante"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Entities.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Database.UsuariosDB"%>
<%@page import="Database.EventosDB"%>
<%@page import="Entities.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    EventosDB eventosInscritos = new EventosDB();
    UsuariosDB uudb = new UsuariosDB();
    Ayudante ayu = new Ayudante();
    AyudantesDB ayuDB = new AyudantesDB();
    ArrayList<Evento> listaEventosInscrito = new ArrayList<Evento>();
    String nombreUsuario = "";
    Usuario userEventsInscritos = new Usuario();
    try {
        Cookie cookie[] = request.getCookies();

        for (Cookie c : cookie) {
            if (c.getName().equals("uName")) {
                nombreUsuario = c.getValue();
            }
        }

        userEventsInscritos = uudb.verUsuario(nombreUsuario);

        listaEventosInscrito = eventosInscritos.verEstadoInscripcion(userEventsInscritos);

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
    </head>
    <body>
        <!-- Inicio NavBar -->
        <jsp:include flush="true" page="navbarlogged.jsp"></jsp:include>
            <!-- Final NavBar -->

            <!-- Inicio visualizaciÃ³n eventos -->
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">         
                <% for (Evento evento : listaEventosInscrito) {%>
                <div class="blog-card">
                    <div class="meta">
                        <div class="photo" style="background-image: url(./img/panoramic-bcn.jpg)"></div>
                        <ul class="details">

                            <li class="author"><%=evento.getUbicacion()%></li>

                            <li class="author"><%=evento.getNum_ayudante()%> Persona</li>

                            <li class="author"><%=evento.getFecha_evento()%></li>

                            <li class="author"><%=evento.getHora_evento()%></li>
                        </ul>
                    </div>
                    <div class="description">
                        <h1><%=evento.getTitulo()%></h1>
                        <br><br>
                        <h2><%=
                            evento.getUsuarioCreador()
                            %></h2></h2>
                        <br>
                        <p>
                            <%=evento.getDescripcion()%>
                        </p>
                        <button type="button" class="btnIzquierda btn-normal">
                            ACEPTADO
                        </button>
                        <%
                            ayu = ayuDB.verAyudante(userEventsInscritos.getId_usuario(), evento.getId_evento());

                            if (ayu.getConfirmado() == false) {%>
                        <form action="ayudante?sa=confirmar" method="post">
                            <button type="submit" name="confirmar" value="<%=evento.getId_evento()%>" class="btn btn-success">
                                CONFIRMAR
                            </button>
                        </form>
                        <% } else {%>
                        <form action="" method="post">
                            <button type="submit" name="eliminar" value="<%=evento.getId_evento()%>" class="btn btn-success">
                                ELIMINAR
                            </button>
                        </form>
                        <% } %>
                    </div>
                </div>
                <% }%>
            </div>
            <div class="col-md-2"></div>
        </div>
        <!-- Fin visualizaciÃ³n eventos -->
    </body>
</html>
