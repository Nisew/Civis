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
        <jsp:include flush="true" page="navbar.jsp"></jsp:include>
        <!-- Final NavBar -->

        <!-- Inicio visualizaciÃ³n eventos -->
        <div class="row">

            <div class="col-md-3"></div>

            <div class="col-md-6">

                <div id="form-main">
                    <div id="form-div">

                        <form class="form" id="formRegister" action="usuario?sa=newUsuario" method="post">

                            <p class="nombreUsuario">

                                <input name="nombreUsuario" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="Nombre usuario" id="nombreUsuario" />
                            </p>

                            <p class="nombre">
                                <input name="nombre" type="text" class="validate[required,custom[email]] feedback-input" placeholder="Nombre" id="nombre" />
                            </p>

                            <p class="apellidos">
                                <input name="apellidos" type="text" class="validate[required,custom[email]] feedback-input" placeholder="Apellidos" id="apellidos" />
                            </p>
                            <p class="telefono">
                                <input name="telefono" type="text" class="validate[required,custom[email]] feedback-input" placeholder="N&uacute;mero de telefono" id="telefono" />
                            </p>

                            <p class="fechaNacimiento">
                                <input name="fechaNacimiento" type="date" class="validate[required,custom[email]] feedback-input" placeholder="Fecha Nacimiento" id="fechaNacimiento" />
                            </p>

                            <p class="correo">
                                <input name="correo" type="text" class="validate[required,custom[email]] feedback-input" placeholder="Correo Electr&oacute;nico" id="correo" />
                            </p>

                            <p class="contrasenya">
                                <input name="contrasenya" type="password" class="validate[required,custom[email]] feedback-input" placeholder="ContraseÃ±a" id="contrasenya" />
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
