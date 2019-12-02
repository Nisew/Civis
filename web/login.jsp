<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>CIVIS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="./styles/estilosNavBar.css">
    <link rel="stylesheet" href="./styles/estilosCarta.css">
    <link rel="stylesheet" href="./styles/estilosFormLogin.css">
    <link rel="stylesheet" href="./styles/estilosFormEvento.css">
  </head>
  <body>

    <!-- Inicio NavBar -->
    <div class="row">

      <div class="col-md-12">
        <nav>
          <div class="container">
            <input id="responsive-menu" type="checkbox">
            <label for="responsive-menu">Menu <span id="menu-icon"></span></label>
            <div id="overlay"></div>
            <ul>
              <li><a href="./index.html">Home</a></li>
              <li><a href="./necesitoAyuda.html">Necesito Ayuda</a></li>
              <li><a href="./misInscripciones.html">Mis inscripciones</a></li>
              <li><a href="./misEventos.html">Mis eventos</a></li>
              <li><a href="./login.jsp">Login</a></li>
              <!-- <br><br>
              <li>Hola, Alejandro, bienvenido de nuevo</li> -->
            </ul>
          </div>
        </nav>
      </div>

    </div>
    <!-- Final NavBar -->

    <!-- Inicio visualizaciÃ³n eventos -->
    <div class="row">

      <div class="col-md-3"></div>

      <div class="col-md-6">

        <div id="form-main">
          <div id="form-div">
            <form class="form" id="formLogin" action="usuario?sa=userLogin" method="post" align:center>

              <p class="nombreUsuario">
                <input name="nombreUsuario" type="text" class="feedback-input" placeholder="Nombre usuario" id="nombreUsuario" />
              </p>

              <p class="contrasenya">
                <input name="contrasenya" type="password" class="feedback-input" placeholder="Contrase&ntilde;a" id="contrasenya" />
              </p>

              <div class="submit">
                <input type="submit" value="LOGIN" id="button-blue"/>
                <div class="ease"></div>
              </div>

              <div class="container">
                <p class="message">¿No tienes una cuenta? <a href="./register.html">Crea una ahora</a></p>
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
