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

      <div class="col-md-3"></div>

      <div class="col-md-6">

        <div id="form-main">
          <div id="form-div">
            <form class="form" id="form1" action="evento?sa=newEvent" method="post">

              <p class="titulo">
                <input name="titulo" type="text" class="feedback-input" placeholder="Titulo" id="titulo" />
              </p>

              <p class="localidad">
                <input name="localidad" type="text" class="feedback-input" placeholder="Localidad" id="localidad" />
              </p>

              <p class="hora">
                <input name="hora" type="time" class="feedback-input" placeholder="Hora" id="hora" />
              </p>
              
              <p class="fecha">
                <input name="fecha" type="date" class="feedback-input" placeholder="Fecha" id="fecha" />
              </p>

              <p class="numPersonas">
                <input name="numPersonas" type="text" class="feedback-input" placeholder="Numero de Personas" id="numPersonas" />
              </p>

              <p class="descripcion">
                <textarea name="descripcion" class="feedback-input" placeholder="Descripci&oacute;n del voluntariado" id="descripcion"></textarea>
              </p>


              <div class="submit">
                <input type="submit" value="ENVIAR" id="button-blue"/>
                <div class="ease"></div>
              </div>
            </form>
          </div>
        </div>

      </div>

      <div class="col-md-3"></div>

    </div>
    <!-- Fin visualizaciÃ³n eventos -->

  </body>
</html>
