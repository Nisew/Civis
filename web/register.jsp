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
        <link rel="stylesheet" href="./styles/estilosFormLogin.css">
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
                            <li><a href="./index.jsp">Home</a></li>
                            <li><a href="./necesitoAyuda.html">Necesito Ayuda</a></li>
                            <li><a href="./misInscripciones.html">Mis inscripciones</a></li>
                            <li><a href="./misEventos.html">Mis eventos</a></li>
                            <li><a href="./login.jsp">Login</a></li>
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

                        <form class="form" id="formRegister" action="usuario?sa=newUsuario" method="post">

                            <p class="nombreUsuario">

                                <input name="nombreUsuario" type="text" class="feedback-input" placeholder="Nombre usuario" id="nombreUsuario" />
                            </p>

                            <p class="nombre">
                                <input name="nombre" type="text" class="feedback-input" placeholder="Nombre" id="nombre" />
                            </p>

                            <p class="apellidos">
                                <input name="apellidos" type="text" class="feedback-input" placeholder="Apellidos" id="apellidos" />
                            </p>
                            <p class="telefono">
                                <input name="telefono" type="text" class="feedback-input" placeholder="N&uacute;mero de telefono" id="telefono" />
                            </p>

                            <p class="fechaNacimiento">
                                <input name="fechaNacimiento" type="date" class="feedback-input" placeholder="Fecha Nacimiento" id="fechaNacimiento" />
                            </p>

                            <p class="correo">
                                <input name="correo" type="text" class="vfeedback-input" placeholder="Correo Electr&oacute;nico" id="correo" />
                            </p>

                            <p class="contrasenya">
                                <input name="contrasenya" type="password" class="feedback-input" placeholder="Contrase&ntilde;a" id="contrasenya" />
                              </p>

                            <div class="submit">
                                <input type="submit" value="REGISTER" id="button-blue"/>
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
