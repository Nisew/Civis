<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html>

<head>
  <title>Civis</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="./estilos.css">
</head>

<body>
    <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-lightx">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Necesito Ayuda</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Mis Eventos</a>
                </li>
                <li class="nav-item dropdown d-flex">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Login
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                            aria-describedby="basic-addon1">
                        <input type="text" class="form-control" placeholder="Password" aria-label="Password"
                            aria-describedby="basic-addon1">
                        <button class="btn btn-sm btn-outline-secondary" type="button">Iniciar sesión</button>
                        <div>¿No tienes cuenta? <a href="">Registrate aquí</a></div>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
  <!--<jsp:include page="navbar.jsp" flush="true" />-->
  <div class="container principal">
    <div class="row">
      <div class="col-6">
        Titulo<br>
        Localidad | fecha y hora <br>
        N&uacute;mero personas X <br>
        <br>
        <div class="feed">
          DescripcionDescripcionDescripcionDescripcion DescripcionDescripcionDescripcionDescripcionDescripcionDescripcion
        </div>
      </div>
      <div class="col-4">
        <div class=" botonmain">
        <button type="button" class="btn btn-secondary">INSCRIBIRSE</button>
      </div>
      </div>
    </div>
  </div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
  integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
  integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
  integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>