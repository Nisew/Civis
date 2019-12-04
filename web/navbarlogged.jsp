
<%-- 
    Document   : navbarlogged
    Created on : 03-dic-2019, 10:45:12
    Author     : Usuario
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <%

            String nombrecuki = "";
            String nombreUsuario="";
            if (request.getCookies() != null) {
                Cookie ck[] = request.getCookies();
               
                for(int i=0;i<ck.length;i++){
                    if(ck[i].getName().equals("uName")){
                        nombreUsuario=ck[i].getValue();
                        
                    }
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
                    <li><a href="./index.jsp">Home</a></li>
                    <li><a href="./necesitoAyuda.jsp">Necesito Ayuda</a></li>
                    <li><a href="./misInscripciones.jsp">Mis inscripciones</a></li>
                    <li><a href="./misEventos.jsp">Mis eventos</a></li>
                    <li> <a href="usuario?sa=borrarCuki">Logout</a></li>
                    <% out.print("Bienvenido "+ nombreUsuario); %>
                    <li><a href="./perfil.jsp"></a></li>
                </ul>
            </div>
        </nav>
    </div>
</div>
