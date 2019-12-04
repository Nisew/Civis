<%-- 
    Document   : navbarlogged
    Created on : 03-dic-2019, 10:45:12
    Author     : Usuario
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nombreUsuario="";
    Cookie cookies[] = request.getCookies();
    if (cookies != null) {
        for (Cookie c: cookies){
            if(c.getName().equals("uName")){
                nombreUsuario= c.getValue();
            }else{
                nombreUsuario="";
            }
            
            
        }
%>
<div class="row">
    <div class="col-md-12">
        <nav>
            <div class="container">
                <input id="responsive-menu" type="checkbox">
                <label for="responsive-menu">Menu <span id="menu-icon"></span></label>
                <div id="overlay"></div>
                <ul>
                    <li><h2><%out.print(nombreUsuario);%></h2></li>
                    <li><a href="./index.jsp">Home</a></li>
                    <li><a href="./necesitoAyuda.jsp">Necesito Ayuda</a></li>
                    <li><a href="./misInscripciones.jsp">Mis inscripciones</a></li>
                    <li><a href="evento?sa=showOwnEvents">Mis eventos</a></li>
                    <li><a href="usuario?sa=logOut">Logout</a></li>
                    
                </ul>
            </div>
        </nav>
    </div>
</div>
<%
} else {
%>

<div class="row">
    <div class="col-md-12">
        <nav>
            <div class="container">
                <input id="responsive-menu" type="checkbox">
                <label for="responsive-menu">Menu <span id="menu-icon"></span></label>
                <div id="overlay"></div>
                <ul>
                    <li><a href="./index.jsp">Home</a></li>
                    <li><a href="./login.jsp">Login</a></li>
                    
                </ul>
            </div>
        </nav>
    </div>
</div>
<% } %>
