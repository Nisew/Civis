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

        <div class="blog-card">
          <div class="meta">
            <div class="photo" style="background-image: url(./img/panoramic-bcn.jpg)"></div>
            <ul class="details">
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
            <h2>SOFIA CACERES MARTINEZ</h2>
            <br>
            <p></p>
            <div class="recuadroNombres">
              <i class="fas fa-users">Giulio Mezzetti</i>
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
          </div>
        </div>


        <div class="blog-card">
          <div class="meta">
            <div class="photo" style="background-image: url(./img/panoramic-bcn.jpg)"></div>
            <ul class="details">
              <li class="author">Carrer Llastics, 22 - Arc de Triomf</li>
              <br>
              <li class="author">3 personas</li>
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
            <p></p>
            <div class="recuadroNombres">
              <i class="fas fa-users">Giulio Mezzetti</i>
              <button type="button" class="btn btn-accept">
                A
              </button>
              <button type="button" class="btn btn-discard ">
                R
              </button>
              <br>
            </div>

            <div class="recuadroNombres">
              <i class="fas fa-users">RaÃºl Segui</i>
              <button type="button" class="btn btn-accept">
                A
              </button>
              <button type="button" class="btn btn-discard">
                R
              </button>
              <br>

            </div>
            <div class="recuadroNombres">
              <i class="fas fa-users">Anthony Alva</i>
              <button type="button" class="btn btn-accept">
                A
              </button>
              <button type="button" class="btn btn-discard ">
                R
              </button>
            </div>

          </div>
        </div>

      </div>

      <div class="col-md-2"></div>

    </div>
    <!-- Fin visualizaciÃ³n eventos -->

  </body>
</html>
