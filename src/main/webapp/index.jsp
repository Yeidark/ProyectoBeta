<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <ui:Composition>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
            <link href="assets/css/ohana.css" rel="stylesheet" type="text/css"/>
            <title>Mugs</title>
        </head>
        <body>
            <header>

                <a href="Cliente/ClientePaginaprincipal.xhtml">
                    <img class="logo" src="assets/img/Logo.nuevo.jpeg" alt="logoOhana"/>
                </a> 

                <nav class="li">
                    <li class="lo"><a href="Cliente/Clientepagquienes.xhtml" class="al">¿Quienes somos?</a></li>
                    <li class="lo"><a href="Cliente/ClienteMisionyvision.xhtml" class="al">Misión y visión</a></li>
                    <li class="lo"><a href="Cliente/ClienteTerminosycondiciones.xhtml" class="al">Terminos y condiciones</a></li>
                    <li class="lo"><a href="controlador?accion=Carrito" class="al"><i class="fas fa-cart-plus">(<label style="color: aqua">${contador}</label>)</i>Carrito</a></li>
                    <li class="lo"><a href="Cliente/DatosCliente.xhtml" class="al">Mi cuenta</a></li>

                    <li class="lo"><a href="general/iniciar_sesion.xhtml" class="al"> Cerrar sesion</a></li>
                </nav>
            </header>
            <nav id="menu">
                <ul class="nav">
                    <li><a href="Cliente/ClientePaginaprincipal.xhtml">Inicio</a></li>
                    <li><a href="./controlador?accion=home">Mugs</a></li>

                    <li><a href="">Camisetas</a>
                        <ul>
                            <li><a href="Cliente/ClienteCamisetashombre.xhtml">Hombres</a></li>
                            <li><a href="Cliente/ClienteCamisetasmujer.xhtml">Mujeres</a></li>
                        </ul>
                    </li>
                    <li><a href="controlador?accion=gorras">Gorras</a></li>
                </ul>
            </nav>

            
            <div class="container">
                
                    <c:forEach var="pro" items="${producto}">
                        <div class="item-text">
                            <div class="form-group">
                                <div class="card">
                                    <div class="card-header">
                                        <label class="col-sm-12">${pro.getNombres()}</label>                                    
                                    </div>
                                    <div class="card-body text-center d-flex">
                                        <label><i class="fas fa-dollar-sign">${pro.getPrecio()}</i></label>
                                        <img src="controladorImg?id=${pro.getId()}" width="200" height="170">
                                    </div>
                                    <div class="card-footer">
                                        <div class="col-sm-12">
                                            <label>${pro.getDescripcion()}</label>                                   
                                        </div>
                                        <div class=" col-sm-12 text-center">                                
                                            <a href="controlador?accion=AgregarCarrito&id=${pro.getId()}" class="btn btn2 btn-outline-primary">Agregar a Carrito<i class="fas fa-cart-plus"></i></a>
                                            <a href="controlador?accion=Comprar&id=${pro.getId()}" class="btn btn-danger">Comprar</a>
                                        </div>                         
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            

            <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
            <script src="pv/js/funciones.js" type="text/javascript"></script>
            
            <div class="social"> 
            <ul class="contacto">
                <div class="icono">
                    <li><a href="https://web.whatsapp.com/%F0%9F%8C%90/es" target="_blank"> <img style=" width: 30% ;height: 30%;" src="assets/img/whatsapp.png" target="_blank" alt="whatsapp"/></a></li><br/><br/>
                    <li style="list-style: none;">COMUNICATE CON NOSOTROS</li>
                    <li style="list-style: none;">3142332869</li>
                    <li style="list-style: none;">Ohana2021@gmail.com</li>
                    <li style="list-style: none;">Calle 24 sur #14-39</li>
                    <li style="list-style: none;">Tunjuelito</li>
                </div>
            </ul>
            <ul class="redes">
                <li style="list-style: none; margin-right: 4%;">SIGUENOS EN:</li>
                <li style="list-style: none; margin-right: 4%;"><a href="https://es-la.facebook.com/" target="_blank"><img src="assets/img/facebook.png" target="_blank" alt="facebook"
                                                                                                                           /></a></li>
                <li style="list-style: none; margin-right: 4%;"><a href="https://www.instagram.com/?hl=es-la" target="_blank"><img src="assets/img/instagram.png" alt="instagram"
                                                                                                                                   /></a></li>
                <li style="list-style: none; margin-right: 4%;"><a href="https://www.youtube.com/channel/UCnDDk7nFIeTG89geOq7VsvA?view_as=subscriber" target="_blank"><img src="assets/img/youtube.png" alt="youtube"
                                                                                                                                                                           /></a></li>
                <li style="list-style: none; margin-right: 4%;"><a href="https://www.google.com/intl/es-419/gmail/about/" target="_blank"><img src="assets/img/gmail.png" alt="gmail"
                                                                                                                                               /></a></li>
            </ul>
        </div> 
            
        </body>
    </ui:Composition>
</html>
