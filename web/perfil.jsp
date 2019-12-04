<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <div class="perfil">

        </div>

      </div>

      <div class="col-md-2"></div>

    </div>
    <!-- Fin visualizaciÃ³n eventos -->

  </body>
</html>
