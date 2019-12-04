<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <% if(!nombreUsuario.equals("")){ %>
            <jsp:include flush="true" page="navbarlogged.jsp"></jsp:include>   
                <%}  else{%>
                
                <jsp:include flush="true" page="navbar.jsp"></jsp:include>   
                <%}%>
            
            <jsp:include flush="true" page="MostrarEventos.jsp"></jsp:include>

    </body>
</html>
