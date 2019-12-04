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

        <div class="blog-card">
          <div class="meta">
            <div class="photo" style="background-image: url(./img/panoramic-bcn.jpg)"></div>
            <ul class="details">
              <br>
              <li class="author">Carrer Pinetons, 42 - GrÃ¡cia</li>
              <br>
              <li class="author">1 Persona</li>
              <br>
              <li class="author">5 Diciembre 2019</li>
              <br>
              <li class="author">17:00</li>
            </ul>
          </div>
          <div class="description">
            <h1>Pasear dos perros malteses</h1>
            <br><br>
            <h2>SOFIA CACERES MARTINEZ</h2></h2>
            <br>
            <p>
              La funciÃ³n a realizar es la de pasear a dos perros malteses de 5 aÃ±os
              durante 45 mminutos aproximadamente. Se necesita a una persona dinamica
              ya que estos dos perros tienen mucha energia.
            </p>
            <button type="button" class="btnIzquierda btn-normal">
              ACEPTADO
            </button>

            <button type="button" class="btn btn-success">
              CONFIRMAR
            </button>
          </div>
        </div>


        <div class="blog-card">
          <div class="meta">
            <div class="photo" style="background-image: url(./img/panoramic-bcn.jpg)"></div>
            <ul class="details">
              <br>
              <li class="author">Carrer Llastics, 22 - Arc de Triomf</li>
              <br>
              <li class="author">3 Personas</li>
              <br>
              <li class="author">5 Diciembre 2019</li>
              <br>
              <li class="author">9:00</li>
            </ul>
          </div>
          <div class="description">
            <h1>Avaluar a unos alumnos</h1>
            <br><br>
            <h2>SOFIA CACERES MARTINEZ</h2>
            <br>
            <p>
              La funciÃ³n a realizar es la de avaluar un programa realizado por unos
              alumnos que estan realizando un bootcamp intensivo.
            </p>
            <button type="button" class="btnIzquierda btn-normal">
              RECHAZADO
            </button>

            <button type="button" class="btn btn-danger">
              ELIMINAR
            </button>

          </div>
        </div>

      </div>

      <div class="col-md-2"></div>

    </div>
    <!-- Fin visualizaciÃ³n eventos -->

  </body>
</html>
